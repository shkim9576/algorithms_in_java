package geeksforgeeks.one.hash.excercise;

import java.util.HashSet;
import java.util.Set;

public class IsProduct {
    // https://www.geeksforgeeks.org/pair-with-given-product-set-1-find-if-any-pair-exists/

    public static void main(String[] args) {
        int arr[] = {10, 20, 9, 40};
        int x = 400;

        IsProduct ob = new IsProduct();
        System.out.println(ob.isProduct(arr, x));
        x = 190;
        System.out.println(ob.isProduct(arr, x));
    }

    boolean isProduct(int[] A, int x) {
        if (A == null || A.length <= 1) return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                return true;
            }
            if (A[i] != 0 && x % A[i] == 0) set.add(x / A[i]);
        }
        return false;
    }

}
