package leetcode.one.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntersectionOfTwoArrays o = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(o.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // 4,9
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) set.add(n);

        Set<Integer> inter = new HashSet<>();
        for (int n : nums2) if (set.contains(n)) inter.add(n);

        int[] result = new int[inter.size()];
        int i = 0;
        for (int n : inter) result[i++] = n;

        return result;
    }
}
