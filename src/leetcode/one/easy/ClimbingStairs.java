package leetcode.one.easy;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs o = new ClimbingStairs();
        System.out.println(o.climbStairs(4)); // 5
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;

        int first = 1;
        int second = 2;
        int third = second + first;

        for (int i = 2; i < n; i++) {
            third = second + first;
            first = second;
            second = third;
        }

        return third;
    }
}
