package leetcode.one.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public static void main(String[] args) {
        PrimeNumberOfSetBitsInBinaryRepresentation o = new PrimeNumberOfSetBitsInBinaryRepresentation();
        System.out.println(o.countPrimeSetBits(6, 10)); // 4
    }

    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));

        int result = 0;
        for (int i = L; i <= R; i++) {
            int bits = 0;
            int n = i;

            while (n > 0) {
                if ((n & 1) == 1) bits++;
                n = n >> 1;
            }

            if (primes.contains(bits)) result++;
        }

        return result;
    }
}
