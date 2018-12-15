package geeksforgeeks.one.hash.excercise;

import java.util.HashSet;
import java.util.Set;

public class CheckTwoSetDisjoint {
    // https://www.geeksforgeeks.org/check-two-given-sets-disjoint/

    public static void main(String[] args) {
        int set1[] = {10, 5, 3, 4, 6};
        int set2[] = {8, 7, 9, 3};

        CheckTwoSetDisjoint ob = new CheckTwoSetDisjoint();
        boolean result = ob.checkDisjoint(set1, set2);
        System.out.println(result);
    }

    boolean checkDisjoint(int[] A1, int[] A2) {
        if (A1 == null && A2 == null) return true;
        if (A1 == null || A2 == null) return false;

        Set<Integer> set = new HashSet<>();
        for (int n : A1) set.add(n);
        for (int n : A2) {
            if (set.contains(n)) return false;
        }

        return true;
    }

}
