import java.util.LinkedHashMap;
import java.util.Map;

public class Collections {
    public static void main(String... args) {


        Map<String, String> allInfo = new LinkedHashMap<>();


        allInfo.put("StreetAddress", "1234 Main st");
        allInfo.put("City", "Austin");
        allInfo.put("State", "TX");
        allInfo.put("ZIP", "78732");

        System.out.println(allInfo.values());
        System.out.println(allInfo.keySet());

        for (Map.Entry<String, String> e : allInfo.entrySet()) {
            String key = e.getKey();
            String value = e.getValue();
            System.out.println(key + ": " + value);
        }


        //allInfo.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
    }
}

