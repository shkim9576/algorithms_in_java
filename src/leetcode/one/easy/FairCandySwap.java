package leetcode.one.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/fair-candy-swap/
public class FairCandySwap {

    public static void main(String[] args) {
        FairCandySwap o = new FairCandySwap();
        System.out.println(Arrays.toString(o.fairCandySwap(new int[]{1, 1}, new int[]{2, 2}))); //[1, 2]
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;
        Set<Integer> setB = new HashSet<>();

        for (int a : A) sa += a;
        for (int b : B) {
            sb += b;
            setB.add(b);
        }

        int delta = (sb - sa) / 2;
        for (int a : A) {
            if (setB.contains(a + delta)) {
                return new int[]{a, a + delta};
            }
        }

        return new int[]{0, 0};
    }
}
