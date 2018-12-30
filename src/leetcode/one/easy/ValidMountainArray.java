package leetcode.one.easy;

//https://leetcode.com/problems/valid-mountain-array/
public class ValidMountainArray {

    public static void main(String[] args) {
        ValidMountainArray o = new ValidMountainArray();
        System.out.println(o.validMountainArray(new int[]{0, 3, 2, 1})); //true
    }

    public boolean validMountainArray(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < A.length - 1 && A[l] < A[l + 1]) l++;
        while (r > 0 && A[r] < A[r - 1]) r--;

        return l < A.length - 1 && r > 0 && l == r;
    }
}
