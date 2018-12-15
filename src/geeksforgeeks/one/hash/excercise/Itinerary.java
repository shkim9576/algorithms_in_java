package geeksforgeeks.one.hash.excercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Itinerary {

    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        Itinerary ob = new Itinerary();
        List<String> result = ob.buildItinerary(dataSet);
        System.out.println(result);
    }

    List<String> buildItinerary(Map<String, String> in) {
        List<String> result = new LinkedList<>();
        if (in == null || in.size() == 0) return result;

        String city = "";
        for (Map.Entry<String, String> entry : in.entrySet()) {
            if (!in.containsValue(entry.getKey())) {
                city = entry.getKey(); // starting point
                break;
            }
        }

        while (city != null) {
            if (in.get(city) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(city).append("->").append(in.get(city));
                result.add(sb.toString());
            }
            city = in.get(city);
        }

        return result;
    }

}
