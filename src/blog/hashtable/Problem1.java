package blog.hashtable;

import java.util.HashMap;

public class Problem1 {

    public static void main(String[] args) {
        Problem1 p = new Problem1();
        int[] A = new int[]{11, 1, 13, 21, 3, 7, 11};
        int[] B = new int[]{11, 3, 11, 7, 1};
        System.out.println(p.IsSubset(A, B));
        A = new int[]{1, 2, 2, 3, 4, 5, 6};
        B = new int[]{1, 2, 4};
        System.out.println(p.IsSubset(A, B));
        A = new int[]{10, 5, 2, 23, 19};
        B = new int[]{19, 5, 3};
        System.out.println(p.IsSubset(A, B));
    }

    boolean IsSubset(int[] A, int[] B) {
        if (A == null && B == null) {
            return true;
        }

        if (B == null || A == null) {
            return false; // one is null and another is not null.
        }

        if (B.length > A.length) {
            return false;
        }

        HashMap<Integer, Integer> table = new HashMap<>();

        for (int i : B) {
            int count = table.getOrDefault(i, 0);
            table.put(i, count + 1);
        }

        for (int i : A) {
            int count = table.getOrDefault(i, 0);
            if (count == 1) table.remove(i);
            else if (count > 1) table.put(i, count - 1);

            if (table.size() == 0) return true;
        }

        return false;
    }
}
