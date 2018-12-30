package leetcode.one.easy;

//https://leetcode.com/problems/monotonic-array/
public class MonotonicArray {

    public static void main(String[] args) {
        MonotonicArray o = new MonotonicArray();
        System.out.println(o.isMonotonic(new int[]{1, 2, 2, 3})); //true
    }

    public boolean isMonotonic(int[] A) {
        int increase = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (increase == -1) increase = 1;
                else if (increase == 0) return false;
            } else if (A[i] > A[i + 1]) {
                if (increase == -1) increase = 0;
                else if (increase == 1) return false;
            }
        }
        return true;
    }
}
