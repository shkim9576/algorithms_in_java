package g4g.sorting.excercise;

import java.util.Arrays;

public class Sort012 {
    // https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}; // 0 0 0 0 0 1 1 1 1 1 2 2

        Sort012 ob = new Sort012();
        ob.sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {0, 1, 2, 0, 1, 2}; // {0, 0, 1, 1, 2, 2}
        ob.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] A) {
        if (A == null || A.length <= 1) return;

        int size = A.length;
        int zero = 0;
        int wi = 0;
        while (zero < size && wi < size) {
            while (zero < size && A[zero] != 0) zero++;
            if (zero < size) swap(A, wi, zero);
            wi++;
            zero++;
        }

        wi = size - 1;
        int two = size - 1;
        while (wi >= 0 && two >= 0) {
            while (two >= 0 && A[two] != 2) two--;
            if (two >= 0) swap(A, wi, two);
            wi--;
            two--;
        }
    }

    void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

}
