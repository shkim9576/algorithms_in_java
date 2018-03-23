package ctci.moderate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairWithSum {
    public static void main(String[] args) {
        int[] A = {3, 2, 4, 1, 10, -2, 4};

        PairWithSum ob = new PairWithSum();
        System.out.println(ob.getPairSums(A, 5));
    }

    static class Pair {
        int a;
        int b;

        Pair(int x, int y) {
            a = x;
            b = y;
        }

        public String toString() {
            return "a:" + a + "-b:" + b;
        }
    }

    List<Pair> getPairSums(int[] A, int sum) {
        List<Pair> result = new ArrayList<>();
        Set<Integer> diffSet = new HashSet<>();
        for (int a : A) {
            if (diffSet.contains(sum - a)) {
                result.add(new Pair(a, sum - a));
            }
            diffSet.add(a);
        }
        return result;
    }
}
