public class Main {
    public static void main(String[] args) {
        UrlShortener urlShortener = new UrlShortener();
        
        // Example of shortening a URL
	

        String longUrl = "https://www.google.com";
        String shortUrl = urlShortener.shortenUrl(longUrl);
        System.out.println("Shortened URL: " + shortUrl);
        
        // Example of retrieving original URL
        String originalUrl = urlShortener.getOriginalUrl(shortUrl);
        System.out.println("Original URL: " + originalUrl);
    }
}
