package leetcode.one.easy;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        PeakIndexInMountainArray o = new PeakIndexInMountainArray();
        System.out.println(o.peakIndexInMountainArray(new int[]{0, 2, 1, 0})); //1
    }

    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (A[m] < A[m + 1]) l = m;
            else if (A[m] < A[m - 1]) r = m;
            else return m;
        }

        return 0;
    }
}
