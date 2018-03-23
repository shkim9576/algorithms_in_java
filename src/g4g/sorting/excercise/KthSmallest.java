package g4g.sorting.excercise;

public class KthSmallest {
    // https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/

    public static void main(String[] args) {
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        int k = 5;

        KthSmallest ob = new KthSmallest();
        int result = ob.kthSmallest(arr, k);
        System.out.println(result);
    }


    int kthSmallest(int[] A, int k) {
        if (A == null || A.length < k) return Integer.MAX_VALUE;
        return quickSort(A, 0, A.length - 1, k);
    }

    int quickSort(int[] A, int l, int r, int k) {
        if (l < r) {
            int partition = partition(A, l, r);
            if (partition == k - 1) return A[partition];
            if (partition >= k) return quickSort(A, l, partition - 1, k);
            return quickSort(A, partition, r, k);
        }
        return Integer.MAX_VALUE;
    }

    int partition(int[] A, int l, int r) {
        int middle = l + (r - l) / 2;
        int pivot = A[middle];

        while (l <= r) {
            while (A[l] < pivot) l++;
            while (A[r] > pivot) r--;
            if (l <= r) {
                swap(A, l, r);
                l++;
                r--;
            }
        }

        return l;
    }

    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
