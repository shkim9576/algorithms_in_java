package geeksforgeeks.one.sorting.excercise;

public class SearchAlmost {
    //https://www.geeksforgeeks.org/search-almost-sorted-array/

    public static void main(String args[]) {
        //int arr[] = {3, 2, 10, 4, 40};
        int arr[] = {2, 1, 4, 3, 6, 5, 8, 7, 100, 105};

        SearchAlmost ob = new SearchAlmost();
        int target = 4;
        int result = ob.searchAlmost(arr, target);
        System.out.println(result);
    }

    int searchAlmost(int[] A, int target) {
        if (A == null || A.length == 0) return -1;

        // do binary geeksforgeeks.g4g1st.one.search
        int end = A.length - 1;
        int l = 0;
        int r = end;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (A[m] == target) return m;
            if (m > 0 && A[m - 1] == target) return m - 1;
            if (m < end && A[m + 1] == target) return m + 1;
            if (target < A[m]) r = m - 2;
            else l = m + 2;
        }

        return -1;
    }

}
