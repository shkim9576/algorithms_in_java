package geeksforgeeks.five.hashmap;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
public class GivenArrayAnotherXSumY {

    //10, 6
    //Array has two elements with given sum
    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, -8};
        int n = 16;

        // Function calling
        if (hasArrayTwoCandidates(A, n))
            System.out.println("Array has two " +
                    "elements with given sum");
        else
            System.out.println("Array doesn't have " +
                    "two elements with given sum");

    }

    static boolean hasArrayTwoCandidates(int[] A, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(sum - a)) {
                System.out.println(String.valueOf(a) + ", " + String.valueOf(sum - a));
                return true;
            }
            set.add(a);
        }

        return false;
    }
}
