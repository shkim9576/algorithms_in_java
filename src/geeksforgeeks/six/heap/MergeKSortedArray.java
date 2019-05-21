package geeksforgeeks.six.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    public static void main(String[] args) {
        MergeKSortedArray o = new MergeKSortedArray();

        int arr[][] = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11, 12}};

        System.out.println(o.mergeKSortedArray(arr));
    }


    List<Integer> mergeKSortedArray(int[][] A) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data);
        for (int i = 0; i < A.length; i++) {
            pq.add(new Node(A[i][0], i, 0));
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node n = pq.remove();
            ans.add(n.data);
            if (n.col < A[n.row].length - 1) {
                pq.add(new Node(A[n.row][n.col + 1], n.row, n.col + 1));
            }
        }

        return ans;
    }

    static class Node {
        int data;
        int row;
        int col;

        Node(int d, int r, int c) {
            this.data = d;
            this.row = r;
            this.col = c;
        }
    }
}
