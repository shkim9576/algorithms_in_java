package g4g1st.algorithm.dp;

public class MaxPairChain {
    // https://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/

    public static void main(String[] args) {
        Pair arr[] = new Pair[]{new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60)};

        MaxPairChain ob = new MaxPairChain();
        System.out.println(ob.getMaxChain(arr));
    }

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    int getMaxChain(Pair[] A) {
        if (A == null || A.length == 0) return -1;

        int size = A.length;
        int[] dp = new int[size];
        dp[0] = 1;

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j].b < A[i].a) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int i = 0; i < size; i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

}
