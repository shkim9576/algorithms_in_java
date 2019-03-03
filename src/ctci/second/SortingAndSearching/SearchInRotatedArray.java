package ctci.second.SortingAndSearching;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        SearchInRotatedArray o = new SearchInRotatedArray();
        int[] A = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(o.search(A, 5, 0, A.length-1));
    }

    int search(int[] A, int key, int l, int r) {
        if (l > r) return -1;
        int m = l + (r - l) / 2;

        if (A[m] == key) return m;
        if (A[m] > A[l]) {
            if (key >= A[l] && key <= A[m]) return search(A, key, l, m - 1);
            else return search(A, key, m + 1, r);
        } else if (A[m] < A[l]) {
            if (key >= A[m] && key <= A[r]) return search(A, key, m + 1, r);
            else return search(A, key, l, m - 1);
        } else if (A[l] == A[m]) {
            if (A[m] != A[r]) return search(A, key, m + 1, r);
            else {
                int index = search(A, key, l, m - 1);
                if (index >= 0) return index;
                return search(A, key, m + 1, r);
            }
        }

        return -1;
    }
}
