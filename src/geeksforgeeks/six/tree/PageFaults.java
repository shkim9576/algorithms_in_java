package geeksforgeeks.six.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PageFaults {

    public static void main(String args[]) {
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int capacity = 4;
        System.out.println(pageFaults(pages, capacity));
    }

    static int pageFaults(int[] pages, int capacity) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        int fault = 0;
        for (int i = 0; i < pages.length; i++) {
            if (!set.contains(pages[i])) {
                fault++;

                if (set.size() >= capacity) {
                    set.remove(q.remove());
                }

                set.add(pages[i]);
                q.add(pages[i]);
            }
        }

        return fault;
    }
}
