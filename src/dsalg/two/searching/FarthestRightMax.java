package dsalg.two.searching;

public class FarthestRightMax {

    public static void main(String[] args) {
        FarthestRightMax o = new FarthestRightMax();
        int[] A = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(o.findMax(A));
    }

    int findMax(int[] A) {
        int[] leftMin = new int[A.length];
        int[] rightMax = new int[A.length];

        leftMin[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], A[i]);
        }

        rightMax[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(A[i], rightMax[i + 1]);
        }

        int l = 0, r = 0, maxDiff = 0;
        while (l < A.length && r < A.length) {
            if (leftMin[l] < rightMax[r]) {
                maxDiff = Math.max(maxDiff, r - l);
                r++;
            } else {
                l++;
            }
        }

        return maxDiff;
    }
}
