package g4g.array.excercise;

public class SortedRotated {
    // https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

    public static void main(String[] args) {
        int[] A = {3, 4, 5, 6, 7, 8, 9, 10, 1, 2};

        SortedRotated ob = new SortedRotated();
        System.out.println(ob.search(A, 3)); //0
        System.out.println(ob.search(A, 2)); //9
        System.out.println(ob.search(A, 7)); //4
        System.out.println(ob.search(A, 1)); //8
        System.out.println(ob.search(A, 20)); //-1

        System.out.println(ob.searchRec(A, 3)); //0
        System.out.println(ob.searchRec(A, 2)); //9
        System.out.println(ob.searchRec(A, 7)); //4
        System.out.println(ob.searchRec(A, 1)); //8
        System.out.println(ob.searchRec(A, 20)); //-1
    }

    int search(int[] A, int x) {
        if (A == null || A.length == 0) return -1;

        int size = A.length;
        int l = 0;
        int r = size - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == x) return m;

            if (A[m] > A[l]) { // left sorted
                if (A[m] > x && x >= A[l]) r = m - 1;
                else l = m + 1;
            } else {  // right sorted
                if (A[m] < x && x <= A[r]) l = m + 1;
                else r = m - 1;
            }
        }

        return -1;
    }

    int searchRec(int[] A, int x) {
        if (A == null || A.length == 0) return -1;

        return helper(A, 0, A.length - 1, x);
    }

    int helper(int[] A, int l, int r, int x) {
        if (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == x) return m;

            if (A[m] > A[l]) { // left sorted
                if (x < A[m] && x >= A[l]) {
                    return helper(A, l, m - 1, x);
                } else {
                    return helper(A, m + 1, r, x);
                }
            } else { // right sorted
                if (x > A[m] && x <= A[r]) {
                    return helper(A, m + 1, r, x);
                } else {
                    return helper(A, l, m - 1, x);
                }
            }
        }

        return -1;
    }

}
