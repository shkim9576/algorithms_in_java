package dsalg.two.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymmetricPairs {

    public static void main(String[] args) {
        SymmetricPairs o = new SymmetricPairs();
        int[][] A = {{1, 3}, {2, 6}, {3, 5}, {7, 4}, {5, 3}, {8, 7}};
        List<Pair> ans = o.pair(A);
        System.out.println(ans);
    }

    List<Pair> pair(int[][] A) {
        List<Pair> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] a : A) {
            if (map.containsKey(a[0])) {
                ans.add(new Pair(a[0], a[1]));
            } else {
                map.put(a[1], a[0]);
            }
        }

        return ans;
    }

    static class Pair {
        int key;
        int value;

        Pair(int k, int v) {
            this.key = k;
            this.value = v;
        }

        public String toString() {
            return key + "-" + value;
        }
    }
}
