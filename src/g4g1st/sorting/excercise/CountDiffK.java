package g4g1st.sorting.excercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountDiffK {
    // https://www.geeksforgeeks.org/count-pairs-difference-equal-k/

    public static void main(String[] args) {
        CountDiffK ob = new CountDiffK();

        int[] A = {1, 5, 3, 4, 2};
        Set<Pair> result = ob.findPairs(A, 3);  // 1 and 4, 2 and 5
        System.out.println(result);

        A = new int[]{8, 12, 16, 4, 0, 20}; // {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
        result = ob.findPairs(A, 4);
        System.out.println(result);
    }

    Set<Pair> findPairs(int[] A, int k) {
        if (A == null || A.length <= 1 || k < 0) return null;

        Arrays.sort(A);

        int size = A.length;
        int l = 0;
        int r = 1;
        Set<Pair> result = new HashSet<>();

        while (l < size && r < size) {
            int diff = A[r] - A[l];
            if (diff == k) {
                result.add(new Pair(A[l], A[r]));
                r++;
            } else if (diff < k) r++;
            else l++;
        }

        return result;
    }

    static class Pair {
        int first;
        int second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }

        public int hashCode() {
            int prime = 31;
            int result = 17;
            result = result * prime + first;
            result = result * prime + second;
            return result;
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) o;

            return this.first == p.first && this.second == p.second;
        }

        public String toString() {
            return "{" + first + ", " + second + "}";
        }
    }

}
