import java.util.HashMap;
import java.util.Random;

public class UrlShortener {
    private HashMap<String, String> urlMap;  // to store short and original URL mappings
    private String domain; // base URL
    private char[] characters; // characters allowed in short URL
    private Random random;

    public UrlShortener() {
        urlMap = new HashMap<>();
        domain = "http://short.url/";  // Example base domain
        characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray(); 
        random = new Random();
    }

    // Method to generate a random short URL
    public String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < 6; i++) {  // Short URL length is 6 characters
            shortUrl.append(characters[random.nextInt(characters.length)]);
        }
        return domain + shortUrl.toString();
    }

    // Method to shorten a URL
    public String shortenUrl(String longUrl) {
        String shortUrl = generateShortUrl();
        urlMap.put(shortUrl, longUrl);  // Store the mapping
        return shortUrl;
    }

    // Method to get the original URL from the short URL
    public String getOriginalUrl(String shortUrl) {
        return urlMap.get(shortUrl); // Retrieve the original URL
    }
}
