package io.github.neverthelesssoft.mediadownloader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DefaultDownloader implements Downloader {

    private static final int BUFFER_SIZE = 8192;

    @Override
    public void download(String url, String destination) throws IOException {
        HttpURLConnection connection = HttpClientProvider.createDefault(url);
        download(destination, connection);
    }

    @Override
    public void download(String destination, HttpURLConnection connection) throws IOException {
        connection.connect();
        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to download file. HTTP Code: " + connection.getResponseCode());
        }

        try (InputStream in = connection.getInputStream();
             OutputStream out = Files.newOutputStream(Paths.get(destination), StandardOpenOption.CREATE)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
