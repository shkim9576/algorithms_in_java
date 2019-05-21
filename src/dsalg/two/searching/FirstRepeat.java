package dsalg.two.searching;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeat {

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 2, 3};
        FirstRepeat o = new FirstRepeat();
        System.out.println(o.firstRepeat(A));
    }

    int firstRepeat(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        int minIndex = Integer.MAX_VALUE;
        int ans = -1;

        // value (K) : index (V)
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) { // repeated element
                if (map.get(A[i]) < minIndex) {
                    ans = A[i];
                    minIndex = map.get(A[i]);
                }
            } else {
                map.put(A[i], i);
            }
        }

        return ans;
    }
}
