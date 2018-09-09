package g4g1st.algorithm.dp;

public class MaxSumContSub {
    //

    public static void main(String[] args) {
        int[] A = {-2, -3, 4, -1, -2, 1, 5, -3}; // 7

        MaxSumContSub ob = new MaxSumContSub();
        System.out.println(ob.maxContSub(A));

        int[] B = {-2, -1, -4, -5}; // -1
        System.out.println(ob.maxContSub(B));
    }

    int maxContSub(int[] A) {
        if (A == null || A.length == 0) return 0;

        int size = A.length;
        int localSum = 0;
        int globalSum = Integer.MIN_VALUE;

        for (int i=0; i<size; i++) {
            localSum += A[i];
            if (localSum > globalSum) globalSum = localSum;
            if (localSum < 0) localSum = 0;
        }

        return globalSum;
    }

}
