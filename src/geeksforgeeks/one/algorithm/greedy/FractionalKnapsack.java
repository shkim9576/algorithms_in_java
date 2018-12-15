package geeksforgeeks.one.algorithm.greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    // https://www.geeksforgeeks.org/fractional-knapsack-problem/

    public static void main(String[] args) {
        Pair[] pairs = {new Pair(60, 10), new Pair(100, 20), new Pair(120, 30)}; // 240
        int W = 50;

        FractionalKnapsack ob = new FractionalKnapsack();
        System.out.println(ob.fractionalKnapSack(pairs, W));
    }

    static class Pair {
        int value;
        int weight;

        Pair(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    int fractionalKnapSack(Pair[] pairs, int W) {

        Arrays.sort(pairs, (p1, p2) -> {
            double p1Ratio = p1.value / p2.weight;
            double p2Ratio = p2.value / p2.weight;
            double diff = p2Ratio - p1Ratio;
            if (diff > 0) return -1;
            else if (diff < 0) return 1;
            else return 0;
        });

        int pairIndex = 0;
        int result = 0;
        while (W > 0) {
            Pair p = pairs[pairIndex++];
            if (p.weight <= W) {
                W -= p.weight;
                result += p.value;
            } else {
                double portion = (double) W / p.weight;
                result += p.value * portion;
                W = 0;
            }
        }
        return result;
    }

}
