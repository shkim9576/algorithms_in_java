package dsalg.two.sorting;

import java.util.Arrays;

public class WhoWinElection {

    public static void main(String[] args) {
        int[] A = {1, 5, 2, 4, 2, 7, 4, 6, 7, 9, 7, 5, 7, 7, 1, 7};

        WhoWinElection o = new WhoWinElection();
        System.out.println(o.whoWinElection(A));
    }

    int whoWinElection(int[] votes) {
        int maxCount = 0;
        int maxCandidate = votes[0];
        int currCount = 0;
        int currCandidate = votes[0];

        //Arrays.sort(votes); // replace to counting sort
        countingSort(votes);

        for (int i = 0; i < votes.length - 1; i++) {
            if (votes[i] == currCandidate) {
                currCount++;
                if (currCount > maxCount) {
                    maxCandidate = currCandidate;
                    maxCount = currCount;
                }
            } else {
                currCandidate = votes[i];
                currCount = 1;
            }
        }

        return maxCandidate;
    }

    void countingSort(int[] A) {
        int[] C = new int[10];
        for (int i = 0; i < A.length; i++) {
            C[A[i]]++;
        }

        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }

        int[] O = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            O[C[A[i]] - 1] = A[i];
            C[A[i]]--;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = O[i];
        }
    }
}
