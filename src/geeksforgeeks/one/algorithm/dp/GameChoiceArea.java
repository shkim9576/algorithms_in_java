package geeksforgeeks.one.algorithm.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameChoiceArea {
    // https://www.geeksforgeeks.org/game-theory-choice-area/

    public static void main(String[] args) {
        Area X = new Area(3, 2);
        Area Y = new Area(-5, -10);
        Area Z = new Area(-20, 5);

        int A = 20;
        int B = 8;

        GameChoiceArea ob = new GameChoiceArea();
        System.out.println(ob.findMaxSurvivialTime(X, Y, Z, A, B)); // 5
    }

    static class Area {
        int a;
        int b;

        Area(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int hashCode() {
            return Objects.hash(a, b);
            /*
            int result = 17;
            result = 31 * result + a;
            result = 31 * result + b;
            return result;
            */
        }

        public boolean equals(Object o) {
            if (o.equals(this)) return true;
            if (o == null) return false;
            if (!(o instanceof Pair)) return false;

            Pair p = (Pair) o;
            return p.a == this.a && p.b == this.b;
        }
    }

    int findMaxSurvivialTime(Area X, Area Y, Area Z, int A, int B) {

        if (A <= 0 || B <= 0) return 0;

        Map<Pair, Integer> memo = new HashMap<>();
        return max(maxSurvival(X, Y, Z, A + X.a, B + X.b, "X", memo),
                   maxSurvival(X, Y, Z, A + Y.a, B + Y.b, "Y", memo),
                   maxSurvival(X, Y, Z, A + Z.a, B + Z.b, "Z", memo));
    }

    int maxSurvival(Area X, Area Y, Area Z, int A, int B, String last, Map<Pair, Integer> memo) {
        if (A <= 0 || B <= 0) return 0;

        Pair p = new Pair(B, B);
        if (memo.containsKey(p)) return memo.get(p);

        int temp = 0;
        switch (last) {
            case "X":
                temp = 1 + max(maxSurvival(X, Y, Z, A + Y.a, B + Y.b, "Y", memo), maxSurvival(X, Y, Z, A + Z.a, B + Z.b, "Z", memo));
                break;
            case "Y":
                temp = 1 + max(maxSurvival(X, Y, Z, A + X.a, B + X.b, "X", memo), maxSurvival(X, Y, Z, A + Z.a, B + Z.b, "Z", memo));
                break;
            case "Z":
                temp = 1 + max(maxSurvival(X, Y, Z, A + Y.a, B + Y.b, "Y", memo), maxSurvival(X, Y, Z, A + X.a, B + X.b, "X", memo));
                break;
        }
        memo.put(p, temp);

        return temp;
    }

    int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

}
