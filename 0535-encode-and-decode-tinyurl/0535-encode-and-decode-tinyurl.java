public class Codec {
    private HashMap<String, String> encodeMap = new HashMap<>();
    private HashMap<String, String> decodeMap = new HashMap<>();
    private String base = "http://tinyurl.com/";

    public String encode(String longUrl) {
        if (!encodeMap.containsKey(longUrl)) {
            String shortUrl = base + (encodeMap.size() + 1);
            encodeMap.put(longUrl, shortUrl);
            decodeMap.put(shortUrl, longUrl);
        }
        return encodeMap.get(longUrl);
    }

    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}