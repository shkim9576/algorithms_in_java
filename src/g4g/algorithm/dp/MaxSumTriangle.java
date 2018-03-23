package g4g.algorithm.dp;

public class MaxSumTriangle {
    // https://www.geeksforgeeks.org/maximum-path-sum-triangle/

    public static void main(String[] args) {
        int[][] T = {{1, 0, 0}, {4, 8, 0}, {1, 5, 3}};  // 14

        MaxSumTriangle ob = new MaxSumTriangle();
        System.out.println(ob.maxSumTriangle(T));
    }

    int maxSumTriangle(int[][] T) {
        int R = T.length;
        int sum = 0;
        for (int r = 0; r < R; r++) {
            sum += findMax(T[r]);
        }
        return sum;
    }

    int findMax(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i : A) max = Math.max(max, i);
        return max;
    }

}
