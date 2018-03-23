package g4g.sorting.excercise;

public class FindCommon {
    // https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/

    public static void main(String args[]) {
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        FindCommon ob = new FindCommon();
        ob.findCommons(ar1, ar2, ar3);
    }

    void findCommons(int[] A1, int[] A2, int[] A3) {
        if(A1 == null || A2 == null || A3 == null) return;

        int s1 = A1.length;
        int s2 = A2.length;
        int s3 = A3.length;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        while(i1 < s1 && i2 < s2 && i3 < s3) {
            while(A1[i1] > A2[i2]) i2++;
            while(A2[i2] > A3[i3]) i3++;
            while(A3[i3] > A1[i1]) i1++;

            if (A1[i1] == A2[i2] && A2[i2] == A3[i3]) {
                System.out.println(A1[i1]);
                i1++;
                i2++;
                i3++;
            }
        }
    }

}
