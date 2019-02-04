package geeksforgeeks.five.searching;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinWindowSubstring o = new MinWindowSubstring();
        System.out.println(o.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int l = 0, r = 0;
        int min = Integer.MAX_VALUE, ml = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        boolean increasing = true;
        while (r < s.length() || l < s.length()) {
            if (increasing && r < s.length()) { // have not found, moving right point
                char c = s.charAt(r);

                if (tMap.containsKey(c)) {
                    sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                    if (sMap.equals(tMap)) {
                        if (r - l < min) {
                            min = r - l;
                            ml = l;
                        }
                        increasing = false;
                    }
                }
                if (increasing) r++;
            } else { // found, moving left point
                char x = s.charAt(l);
                l++;

                if (tMap.containsKey(x)) {
                    sMap.put(x, sMap.get(x) - 1);
                }

                if (tMap.equals(sMap)) {
                    if (r - l < min) {
                        min = r - l;
                        ml = l;
                    }
                } else {
                    increasing = true;
                }
            }
        }

        return s.substring(ml, ml + min + 1);
    }
}
