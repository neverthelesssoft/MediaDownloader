# Media Downloader

A Java library for downloading files with customizable parameters

### Example with default HttpURLConnection params
```java
String path = "sample-image.jpg";
String url = "https://example.com/images/sample-image.jpg";

Downloader downloader = new DefaultDownloader();
        
downloader.download(url, path);
```



### Example with custom HttpURLConnection params
```java
String path = "sample-image.jpg";
String url = "https://example.com/images/sample-image.jpg";

HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
connection.setRequestProperty("User-Agent", "Mozilla/5.0");
connection.setRequestMethod("GET");
connection.setConnectTimeout(15_000);
connection.setReadTimeout(10_000);
connection.connect();

Downloader downloader = new DefaultDownloader();

downloader.download(path, connection);
```