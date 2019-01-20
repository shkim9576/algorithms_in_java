package geeksforgeeks.five.hashmap;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
public class FindItineraryFromGivenListTickets {

    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        printResult(dataSet);
    }

    static void printResult(Map<String, String> map) {
        String from = "";

        for (String key : map.keySet()) {
            if (!map.containsValue(key)) {
                from = key;
                break;
            }
        }

        String to = map.get(from);
        while (to != null) {
            System.out.println(from + "->" + to);
            from = to;
            to = map.get(from);
        }
    }

}
