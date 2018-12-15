package geeksforgeeks.one.hash.excercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingElementsInRange {
    // https://www.geeksforgeeks.org/find-missing-elements-of-a-range/

    // Driver program to test above function
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 4};
        int low = -2, high = 10;

        MissingElementsInRange ob = new MissingElementsInRange();
        ob.findMissingElementsInRangeSet(arr, low, high);
        System.out.println("");
        ob.findMissingElementsInRangeSort(arr, low, high);
    }

    void findMissingElementsInRangeSet(int[] A, int low, int high) {
        if (A == null || A.length == 0) return;

        Set<Integer> set = new HashSet<>();
        for (int n : A) set.add(n);

        for (int i = low; i <= high; i++) {
            if (!set.contains(i)) System.out.print(i + " ");
        }
    }


    void findMissingElementsInRangeSort(int[] A, int low, int high) {
        if (A == null || A.length == 0) return;

        Arrays.sort(A);
        int index = binarySearch(A, low);

        int curr = low;
        while (index < A.length && curr <= high) {
            if (A[index] != curr) System.out.print(curr + " ");
            else index++;
            curr++;
        }

        while (curr <= high) {
            System.out.print(curr + " ");
            curr++;
        }
    }

    int binarySearch(int[] A, int x) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == x) return m;
            else if (A[m] < x) l = m + 1;
            else r = m - 1;
        }
        return l;
    }

}
