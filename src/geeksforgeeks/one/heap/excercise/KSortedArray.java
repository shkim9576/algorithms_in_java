package geeksforgeeks.one.heap.excercise;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedArray {
    // https://www.programcreek.com/2014/05/merge-k-sorted-arrays-in-java/

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = {0, 9, 10, 11};

        KSortedArray ob = new KSortedArray();
        List<Integer> result = ob.mergeKSortedArray(new int[][]{arr1, arr2, arr3});
        System.out.println(result);
    }

    class ArrayContainer implements Comparable<ArrayContainer> {
        int[] arr;
        int index;

        ArrayContainer(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        public int compareTo(ArrayContainer o) {
            return this.arr[this.index] - o.arr[o.index];
        }
    }

    ArrayList<Integer> mergeKSortedArray(int[][] arrs) {
        if (arrs == null || arrs.length == 0) return null;

        PriorityQueue<ArrayContainer> q = new PriorityQueue<>();

        for (int i = 0; i < arrs.length; i++) {
            q.add(new ArrayContainer(arrs[i], 0));
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            ArrayContainer ac = q.remove();
            result.add(ac.arr[ac.index]);

            if (ac.index < ac.arr.length - 1) {
                q.add(new ArrayContainer(ac.arr, ac.index + 1));
            }
        }
        return result;
    }

}
