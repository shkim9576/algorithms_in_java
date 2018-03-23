package g4g.search.excercise;

public class FixedPoint {
    // https://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/

    public static void main(String args[]) {
        int arr[] = {-10, -1, 0, 3, 10, 11, 30, 50, 100};  // 3

        FixedPoint ob = new FixedPoint();
        System.out.println(ob.fixedPoint(arr));
    }

    int fixedPoint(int[] A) {
        if (A == null || A.length == 0) return -1;

        int l=0;
        int r=A.length-1;

        while(l <= r) {
            int m = l + (r - l)/2;

            if (A[m] == m) return m;
            else if (A[m] < m) l = m + 1;
            else r = m - 1;
        }

        return -1;
    }

}
