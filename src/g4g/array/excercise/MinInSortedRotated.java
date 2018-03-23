package g4g.array.excercise;

public class MinInSortedRotated {
    // https://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/

    public static void main(String[] args) {
        MinInSortedRotated ob = new MinInSortedRotated();

        int arr1[] = {5, 6, 1, 2, 3, 4};
        System.out.println("The minimum element is " + ob.findMin(arr1));
        System.out.println("The minimum element is " + ob.findMinItr(arr1));
        int arr2[] = {1, 2, 3, 4};
        System.out.println("The minimum element is " + ob.findMin(arr2));
        System.out.println("The minimum element is " + ob.findMinItr(arr2));
        int arr3[] = {1};
        System.out.println("The minimum element is " + ob.findMin(arr3));
        System.out.println("The minimum element is " + ob.findMinItr(arr3));
        int arr4[] = {1, 2};
        System.out.println("The minimum element is " + ob.findMin(arr4));
        System.out.println("The minimum element is " + ob.findMinItr(arr4));
        int arr5[] = {2, 1};
        System.out.println("The minimum element is " + ob.findMin(arr5));
        System.out.println("The minimum element is " + ob.findMinItr(arr5));
        int arr6[] = {5, 6, 7, 1, 2, 3, 4};
        System.out.println("The minimum element is " + ob.findMin(arr6));
        System.out.println("The minimum element is " + ob.findMinItr(arr6));
        int arr7[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("The minimum element is " + ob.findMin(arr7));
        System.out.println("The minimum element is " + ob.findMinItr(arr7));
        int arr8[] = {2, 3, 4, 5, 6, 7, 8, 1};
        System.out.println("The minimum element is " + ob.findMin(arr8));
        System.out.println("The minimum element is " + ob.findMinItr(arr8));
        int arr9[] = {3, 4, 5, 1, 2};
        System.out.println("The minimum element is " + ob.findMin(arr9));
        System.out.println("The minimum element is " + ob.findMinItr(arr9));
    }

    int findMin(int[] A) {
        if (A == null || A.length == 0) return -1;

        return findMin(A, 0, A.length - 1);
    }

    int findMin(int[] A, int left, int right) {
        if (left == right) return A[left]; // single element
        if ((right - left) == 1) return Math.min(A[right], A[left]); // two element return min

        int middle = left + (right - left) / 2;

        if (A[left] < A[right]) return A[left];  // not rotated;

        return A[middle] > A[left] ? findMin(A, middle, right) : findMin(A, left, middle);
    }

    int findMinItr(int[] A) {
        if (A == null || A.length == 0) return -1;
        if (A.length == 1) return A[0];

        int left = 0;
        int right = A.length - 1;

        if (A[left] < A[right]) return A[left]; // not rotated

        while (left <= right) {
            if ((right - left) == 1) return A[right]; // single element

            int middle = left + (right - left) / 2;
            if (A[middle] > A[left]) left = middle;
            else right = middle;
        }

        return A[left];
    }
}
