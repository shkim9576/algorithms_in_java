package geeksforgeeks.one.array.excercise;

public class CountRotation {
    // https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/

    public static void main(String[] args) {
        int arr[] = {15, 18, 2, 3, 6, 12};

        CountRotation ob = new CountRotation();
        System.out.println(ob.countRotations(arr));
    }

    int countRotations(int[] A) {
        if (A == null || A.length < 2) return 0;
        if (A[0] < A[A.length - 1]) return 0; // not rotated

        return countRotations(A, 0, A.length - 1);
    }

    int countRotations(int[] arr, int low, int high) {

        if (high == low) return low;

        int mid = low + (high - low) / 2;

        if (mid < high && arr[mid + 1] < arr[mid]) return (mid + 1);

        if (mid > low && arr[mid] < arr[mid - 1]) return mid;

        return (arr[high] > arr[mid]) ? countRotations(arr, low, mid - 1) : countRotations(arr, mid + 1, high);
    }
}
