package g4g1st.search.excercise;

import java.util.Arrays;

public class TwoSmallest {

    public static void main(String[] args) {
        int arr[] = {12, 13, 1, 10, 34, 1}; // 1, 10

        TwoSmallest ob = new TwoSmallest();
        int[] result = ob.findTwoSmallest(arr);
        System.out.println(Arrays.toString(result));
    }

    int[] findTwoSmallest(int[] A) {
        if (A == null || A.length < 2) return null;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i : A) {
            if (i < first) {
                second = first;
                first = i;
            } else if (i > first && i < second) {
                second = i;
            }
        }

        return new int[]{first, second};
    }

}
