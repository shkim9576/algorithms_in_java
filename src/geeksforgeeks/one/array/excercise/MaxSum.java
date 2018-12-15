package geeksforgeeks.one.array.excercise;

public class MaxSum {
    // https://www.geeksforgeeks.org/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/

    public static void main(String[] args) {
        int[] A = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        MaxSum ob = new MaxSum();
        System.out.println(ob.maxSum(A));
    }

    int maxSum(int[] A) {
        if (A == null || A.length == 0) return 0;

        int size = A.length;
        int arrSum = 0;
        int currVal = 0;

        for (int i=0; i<size; i++) {
            arrSum += A[i];
            currVal += i * A[i];
        }

        int max = currVal;

        for(int i=1; i<size; i++) {
            currVal += arrSum - size * A[size-i];
            max = Math.max(max, currVal);
        }

        return max;
    }

}
