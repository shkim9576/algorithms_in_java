package leetcode.one.easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
public class XOfKindInDeckOfCards {

    public static void main(String[] args) {
        XOfKindInDeckOfCards o = new XOfKindInDeckOfCards();
        System.out.println(o.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1})); //true
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);

        int result = 0;
        for (int i : count.values()) result = gcd(i, result);

        return result > 1;
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
