package geeksforgeeks.five.hashmap;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
public class FindArrayIsSubsetOfAnotherArray {

    public static void main(String[] args) {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};

        int m = arr1.length;
        int n = arr2.length;

        if (isSubset(arr1, arr2, m, n))
            System.out.println("arr2 is a subset of arr1");
        else
            System.out.println("arr2 is not a subset of arr1");
    }

    static boolean isSubset(int[] A, int[] B, int m, int n) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) set.add(a);
        for (int b : B) {
            if (!set.contains(b)) return false;
        }
        return true;
    }
}
