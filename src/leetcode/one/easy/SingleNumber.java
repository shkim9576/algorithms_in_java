package leetcode.one.easy;

//https://leetcode.com/problems/single-number/
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber o = new SingleNumber();
        System.out.println(o.singleNumber(new int[]{4, 1, 2, 1, 2})); //4
    }

    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) sum ^= n;

        return sum;
    }
}
