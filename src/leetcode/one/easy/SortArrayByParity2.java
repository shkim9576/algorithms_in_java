package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/sort-array-by-parity-ii/
public class SortArrayByParity2 {

    public static void main(String[] args) {
        SortArrayByParity2 o = new SortArrayByParity2();
        System.out.println(Arrays.toString(o.sortArrayByParityII(new int[]{4, 2, 5, 7}))); //[4, 5, 2, 7]
    }

    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];

        int x = 0;
        int y = 1;
        for (int a : A) {
            if (a % 2 == 0) {
                result[x] = a;
                x += 2;
            } else {
                result[y] = a;
                y += 2;
            }
        }

        return result;
    }
}
