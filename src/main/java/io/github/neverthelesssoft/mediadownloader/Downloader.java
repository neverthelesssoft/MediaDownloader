package io.github.neverthelesssoft.mediadownloader;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface Downloader {
    void download(String url, String destination) throws IOException;

    void download(String destination, HttpURLConnection connection) throws IOException;
}
