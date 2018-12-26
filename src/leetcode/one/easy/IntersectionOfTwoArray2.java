package leetcode.one.easy;

import java.util.*;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/
public class IntersectionOfTwoArray2 {

    public static void main(String[] args) {
        IntersectionOfTwoArray2 o = new IntersectionOfTwoArray2();
        System.out.println(Arrays.toString(o.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}))); //2,2
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums1) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int n : nums2) {
            if (count.containsKey(n)) {
                result.add(n);
                count.put(n, count.get(n) - 1);
                if (count.get(n) == 0) count.remove(n);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (int n : result) arr[i++] = n;

        return arr;
    }
}
