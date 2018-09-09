package g4g1st.search.excercise;

public class FindPeak {
    // https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/

    public static void main(String[] args) {

        FindPeak ob = new FindPeak();
        int arr[] = {1, 3, 50, 10, 9, 7, 6};  // 50
        System.out.println("The maximum element is " + ob.findPeak(arr));
        System.out.println("The maximum element is " + ob.findPeakLinear(arr));

        arr = new int[]{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}; // 500
        System.out.println("The maximum element is " + ob.findPeak(arr));
        System.out.println("The maximum element is " + ob.findPeakLinear(arr));

        arr = new int[]{10, 20, 30, 40, 50}; // 50
        System.out.println("The maximum element is " + ob.findPeak(arr));
        System.out.println("The maximum element is " + ob.findPeakLinear(arr));

        arr = new int[]{120, 100, 80, 20, 0}; // 120
        System.out.println("The maximum element is " + ob.findPeak(arr));
        System.out.println("The maximum element is " + ob.findPeakLinear(arr));
    }


    int findPeak(int[] A) {
        if (A == null || A.length == 0) return -1;

        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (m == 0 || m == A.length - 1) {
                return Math.max(A[0], A[A.length - 1]);
            }

            if (A[m] > A[m + 1] && A[m] > A[m - 1]) return A[m];

            if (A[m] > A[m - 1] && A[m] < A[m + 1]) l = m + 1;
            else r = m - 1;
        }

        return -1;
    }

    int findPeakLinear(int[] A) {
        if (A == null || A.length == 0) return -1;
        if (A.length == 1) return A[0];
        if (A.length == 2) return Math.max(A[0], A[1]);

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) return A[i];
        }

        return Math.max(A[0], A[A.length - 1]);
    }

}
