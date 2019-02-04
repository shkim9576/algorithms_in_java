package geeksforgeeks.five.dp;

//https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs o = new MinCostClimbingStairs();
        System.out.println(o.minCostClimbingStairs(new int[]{0, 0, 0, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] T = new int[n];
        T[0] = cost[0];
        T[1] = cost[1];

        for (int i = 2; i < n; i++) {
            T[i] = Math.min(T[i - 1], T[i - 2]) + cost[i];
        }

        return Math.min(T[n-1], T[n-2]);
    }
}
