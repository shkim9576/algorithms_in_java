package g4g.algorithm.dp;

public class SubsetSum {
    // https://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/

    public static void main(String[] args) {
        int A[] = {3, 34, 4, 12, 5, 2}; // true
        int sum = 9;

        SubsetSum ob = new SubsetSum();
        System.out.println(ob.subsetSum(A, sum));

        A = new int[] { 3, 2, 7, 1};  // true
        sum = 6;
        System.out.println(ob.subsetSum(A, sum));
    }

    boolean subsetSum(int[] A, int sum) {

        int size = A.length;
        boolean[][] solution = new boolean[size + 1][sum + 1];
        // if sum is not zero and subset is 0, we can't make it
        for (int i = 1; i <= sum; i++) {
            solution[0][i] = false;
        }
        // if sum is 0 the we can make the empty subset to make sum 0
        for (int i = 0; i <= size; i++) {
            solution[i][0] = true;
        }
        //
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= sum; j++) {
                //first copy the data from the top
                solution[i][j] = solution[i - 1][j];

                //If solution[i][j]==false check if can be made
                if (solution[i][j] == false && j >= A[i - 1])
                    solution[i][j] = solution[i][j] || solution[i - 1][j - A[i - 1]];
            }
        }
        return solution[size][sum];

    }

}
