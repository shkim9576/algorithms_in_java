package ctci.second.SortingAndSearching;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams o = new GroupAnagrams();
        String[] ans = o.groupAnagrams(new String[]{"abc", "zyx1", "12534", "cba", "x1yz", "12453", "bac"});
        System.out.println(Arrays.toString(ans));
    }

    private String[] groupAnagrams(String[] strs) {
        String[] ans = new String[strs.length];
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String sorted = sort(s);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }

        int index = 0;
        for (List<String> list : map.values()) {
            for (String s : list) ans[index++] = s;
        }

        return ans;
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
