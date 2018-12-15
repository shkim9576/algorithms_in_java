package geeksforgeeks.one.sorting.excercise;

public class CountOnes {
    // https://www.geeksforgeeks.org/count-1s-sorted-binary-array/

    public static void main(String args[]) {
        //int arr[] = {1, 1, 1, 1, 0, 0, 0};
        //int arr[] = {0, 0, 0, 0};
        int arr[] = {1, 1, 1, 1};

        CountOnes ob = new CountOnes();
        int result = ob.countOnes(arr);
        System.out.println(result);
    }

    int countOnes(int[] A) {
        if (A == null) return 0;

        // binary geeksforgeeks.g4g1st.one.search
        int size = A.length;
        int l = 0;
        int r = size - 1;
        int count = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == 1 && (m == size - 1 || A[m + 1] == 0)) {
                count = m + 1;
                break;
            }
            if (A[m] == 0) r = m - 1;
            else l = m + 1;
        }

        return count;
    }

}
