package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/submissions/
public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray o = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        o.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1)); // 1,2,2,3,5,6
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int wi = m + n - 1;
        m--;
        n--;
        while (n >= 0 && m >= 0) {
            if (nums1[m] > nums2[n]) nums1[wi] = nums1[m--];
            else nums1[wi] = nums2[n--];
            wi--;
        }

        while (n >= 0) nums1[wi--] = nums2[n--];
    }
}
