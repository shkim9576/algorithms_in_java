package leetcode.one.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/buddy-strings/
public class BuddyStrings {

    public static void main(String[] args) {
        BuddyStrings o = new BuddyStrings();
        System.out.println(o.buddyStrings("aaaaaaabc", "aaaaaaacb")); //true
    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        Set<Character> set = new HashSet<>();
        int diff = 0;
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diff++;
                indexes.add(i);
            }
            set.add(A.charAt(i));
        }

        if (A.equals(B)) return set.size() < A.length();

        return diff == 2 &&
                A.charAt(indexes.get(0)) == B.charAt(indexes.get(1)) &&
                A.charAt(indexes.get(1)) == B.charAt(indexes.get(0));
    }
}
