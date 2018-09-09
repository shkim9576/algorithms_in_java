package g4g1st.algorithm.dp;

public class MinAssemblyTime {

    public static void main(String[] args) {
        int[][] A = {{4, 5, 3, 2}, {2, 10, 1, 4}};
        int[][] T = {{0, 7, 4, 5}, {0, 9, 2, 8}};
        int[] enter = {10, 12};
        int[] exit = {18, 7};

        MinAssemblyTime ob = new MinAssemblyTime();
        System.out.println(ob.minAssemblyTime(A, T, enter, exit));  // 35
    }

    int minAssemblyTime(int[][] A, int[][] T, int[] enter, int[] exit) {

        int numStation = A[0].length;

        int[] T1 = new int[numStation];
        int[] T2 = new int[numStation];

        T1[0] = A[0][0] + enter[0];
        T2[0] = A[1][0] + enter[1];

        for (int i = 1; i < numStation; i++) {
            T1[i] = Math.min(T1[i - 1] + A[0][i], T2[i - 1] + A[0][i] + T[1][i]);
            T2[i] = Math.min(T2[i - 1] + A[1][i], T1[i - 1] + A[1][i] + T[0][i]);
        }

        return Math.min(T1[numStation - 1] + exit[0], T2[numStation - 1] + exit[1]);
    }

}
