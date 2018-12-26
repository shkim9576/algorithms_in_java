package leetcode.one.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate o = new ContainsDuplicate();
        System.out.println(o.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(o.containsDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 3}));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) return true;
            else set.add(n);
        }

        return false;
    }
}
