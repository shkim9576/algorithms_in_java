package geeksforgeeks.one.hash.excercise;

import java.util.HashSet;
import java.util.Set;

public class SubsetAnother {
    // https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/

    public static void main(String[] args) {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};

        SubsetAnother ob = new SubsetAnother();
        boolean result = ob.isSubset(arr1, arr2);
        System.out.println(result);
    }

    boolean isSubset(int[] A1, int[] A2) {
        if (A1 == null || A2 == null) return false;

        int[] longer = A1.length > A2.length ? A1 : A2;
        int[] shorter = A1.length < A2.length ? A1 : A2;

        Set<Integer> set = new HashSet<>();
        for (int n : longer) set.add(n);

        for (int n : shorter) {
            if (!set.contains(n)) return false;
        }

        return true;
    }
}
