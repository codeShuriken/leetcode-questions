public class Codec {
    final Map<Integer, String> urlsMap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hashcode  = longUrl.hashCode();
        urlsMap.put(hashcode, longUrl);
        return "http://tinyurl.com/" + hashcode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int hashcode = Integer.parseInt(shortUrl.split("/")[3]);
        return urlsMap.get(hashcode);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));