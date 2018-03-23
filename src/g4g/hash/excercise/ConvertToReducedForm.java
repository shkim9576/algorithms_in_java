package g4g.hash.excercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConvertToReducedForm {
    // https://www.geeksforgeeks.org/convert-an-array-to-reduced-form-set-1-simple-and-hashing/

    public static void main(String[] args) {
        int arr[] = {10, 20, 15, 12, 11, 50};

        ConvertToReducedForm ob = new ConvertToReducedForm();
        ob.convertToReducedForm(arr);
        System.out.println(Arrays.toString(arr));
    }

    void convertToReducedForm(int[] A) {
        if (A == null || A.length == 0) return;

        int[] B = A.clone();
        Arrays.sort(B);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = map.get(A[i]);
        }
    }

}
