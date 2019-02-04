package ctci.first.sortingsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"abc", "cba", "acb", "xy", "yz", "zzaa", "az", "azaz"};

        GroupAnagrams ob = new GroupAnagrams();
        String[] result = ob.sortAnagram(strs);
        System.out.println(Arrays.toString(result));
    }

    String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    String[] sortAnagram(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String sorted = sort(strs[i]);
            List list = map.getOrDefault(sorted, new ArrayList<>());
            list.add(strs[i]);
            map.put(sorted, list);
        }

        String[] result = new String[strs.length];
        int i = 0;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> anagrams = entry.getValue();
            for (String a : anagrams) result[i++] = a;
        }

        return result;
    }

}
