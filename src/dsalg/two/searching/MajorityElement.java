package dsalg.two.searching;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement o = new MajorityElement();
        int[] A = {1, 5, 5, 2, 5, 3, 5, 5, 4};
        System.out.println(o.majority(A));
    }

    int majority(int[] A) {
        int count = 0;
        int candidate = A[0];
        for (int i = 0; i < A.length; i++) {
            if (count == 0) {
                candidate = A[i];
                count = 1;
            } else if (A[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
