package ctci.first.moderate;

import java.util.HashMap;
import java.util.Map;

public class MasterMind {

    public static void main(String[] args) {
        String solution = "RGBY";
        String guess = "GGRR";

        MasterMind ob = new MasterMind();
        System.out.println(ob.estimate(solution, guess));
    }

    static class Result {
        int hit = 0;
        int phit = 0;

        Result(int h, int p) {
            hit = h;
            phit = p;
        }

        public String toString() {
            return "hit: " + hit + ", phit: " + phit;
        }
    }

    Result estimate(String solution, String guess) {
        int hit = 0;
        int phit = 0;

        for (int i=0; i<guess.length(); i++) {
            if (solution.charAt(i) == guess.charAt(i)) hit++;
        }

        Map<Character, Integer> count = new HashMap<>();
        for (int i=0; i<solution.length(); i++) {
            count.put(solution.charAt(i), count.getOrDefault(solution.charAt(i), 0) + 1);
        }

        for (int i=0; i<guess.length(); i++) {
            if (count.containsKey(guess.charAt(i))) {
                if (count.get(guess.charAt(i)) == 1) {
                    count.remove(guess.charAt(i));
                } else {
                    count.put(guess.charAt(i), count.get(guess.charAt(i))-1);
                }
                phit++;
            }
        }

        return new Result(hit, phit - hit);
    }
}
