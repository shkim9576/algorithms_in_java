package g4g.search.excercise;

public class Ceiling {
    // https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/

    public static void main(String[] args) {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int x = 0;
        x = 1;
        x = 5;
        x = 20;

        Ceiling ob = new Ceiling();
        ob.findCeilingAndFloor(arr, x);
    }

    void findCeilingAndFloor(int[] A, int x) {
        if (A == null || A.length == 0) return;

        int index = binarySearch(A, x);

        if (index <= 0) {
            System.out.println("celing is " + A[0]);
            System.out.println("no floor");
        } else if (index >= A.length - 1) {
            System.out.println("no celing");
            System.out.println("floor is " + A[A.length - 1]);
        } else if (A[index] == x) {
            System.out.println("ceiling is " + x);
            System.out.println("floor is " + x);
        } else {
            System.out.println("celing is " + A[index]);
            System.out.println("floor is " + A[index - 1]);
        }
    }

    int binarySearch(int A[], int x) {

        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == x) return m;
            else if (A[m] > x) r = m - 1;
            else l = m + 1;
        }

        return l;
    }

}
