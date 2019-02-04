package ctci.first.moderate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumSwap {

    public static void main(String[] args) {
        int[] A = {4, 1, 2, 1, 1, 2};
        int[] B = {3, 6, 3, 3};

        SumSwap ob = new SumSwap();
        System.out.println(Arrays.toString(ob.sumSwap(A, B)));
    }

    int[] sumSwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int a : A) sumA += a;
        for (int b : B) sumB += b;
        int big = sumA > sumB ? sumA : sumB;
        int small = sumA > sumB ? sumB : sumA;
        int diff = big - small;
        if (diff % 2 == 1) return null;

        Set<Integer> set = new HashSet<>();
        if (big == sumA) {
            for (int a : A) set.add(a);
        } else {
            for (int b : B) set.add(b);
        }

        if (small == sumA) {
            for (int a : A) {
                if (set.contains(a + diff / 2)) return new int[]{a, a + diff / 2};
            }
        } else {
            for (int b : B) {
                if (set.contains(b + diff / 2)) return new int[]{b, b + diff / 2};
            }
        }

        return null;
    }
}
