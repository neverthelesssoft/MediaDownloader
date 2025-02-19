package io.github.neverthelesssoft.mediadownloader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientProvider {
    private static final int CONNECT_TIMEOUT = 10_000;
    private static final int READ_TIMEOUT = 15_000;

    public static HttpURLConnection createDefault(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(CONNECT_TIMEOUT);
        connection.setReadTimeout(READ_TIMEOUT);
        connection.connect();
        return connection;
    }
}
