package dsalg.two.tree;

public class HeightNary {

    public static void main(String[] args) {
        int[] A = {-1, 0, 1, 6, 6, 0, 0, 2, 7};

        HeightNary o = new HeightNary();
        System.out.println(o.height(A));
    }

    int height(int[] A) {
        if (A == null) return 0;

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            int j = i;
            while (A[j] != -1) {
                count++;
                j = A[j];
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
