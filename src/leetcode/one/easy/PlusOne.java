package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/plus-one/
public class PlusOne {

    public static void main(String[] args) {
        PlusOne o = new PlusOne();

        System.out.println(Arrays.toString(o.plusOne(new int[]{1,2,3}))); //124
        System.out.println(Arrays.toString(o.plusOne(new int[]{9,9,9}))); //1000
    }

    public int[] plusOne(int[] digits) {

        for(int i=digits.length-1; i>=0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        if(digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            for (int i=0; i<digits.length; i++) {
                result[i+1] = digits[i];
            }
            result[0] = 1;
            return result;
        }

        return digits;
    }
}
