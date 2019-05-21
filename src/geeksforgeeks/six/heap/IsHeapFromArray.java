package geeksforgeeks.six.heap;

public class IsHeapFromArray {

    public static void main(String[] args) {
        int arr[] = {90, 15, 10, 7, 12, 2, 7, 3};
        int n = arr.length;
        IsHeapFromArray o = new IsHeapFromArray();
        if (o.isHeap(arr)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    boolean isHeap(int[] A) {
        if (A == null || A.length == 0) return true;

        int n = A.length;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            if (2 * i + 1 < n && A[i] < A[2 * i + 1]) return false;
            if (2 * i + 2 < n && A[i] < A[2 * i + 2]) return false;
        }
        return true;
    }
}
