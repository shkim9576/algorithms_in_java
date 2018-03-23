package g4g.hash.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByShift {
    // https://www.geeksforgeeks.org/group-shifted-string/

    public static void main(String[] args) {
        String[] str = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"};

        GroupByShift ob = new GroupByShift();
        Map<String, List<String>> result = ob.groupShiftedString(str);
        System.out.println(result);
    }

    Map<String, List<String>> groupShiftedString(String[] A) {
        Map<String, List<String>> result = new HashMap<>();
        if (A == null || A.length == 0) return result;

        for (String str : A) {
            String key = getKey(str);
            List<String> list = result.getOrDefault(key, new ArrayList<>());
            list.add(str);
            result.put(key, list);
        }

        return result;
    }

    String getKey(String str) {
        if (str == null || str.length() == 0) return "--";
        if (str.length() == 1) return "-";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            int diff = str.charAt(i) - str.charAt(i - 1);
            diff = diff < 0 ? diff + 26 : diff;
            sb.append(diff);
        }
        return sb.toString();
    }

}
