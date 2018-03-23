package g4g.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {
    // https://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/

    public static void main(String[] args) {
        int A[][] = {{5, 9}, {1, 2}, {3, 4}, {0, 6}, {5, 7}, {8, 9}}; // output: (1, 2), (3, 4), (5, 7), (8, 9)

        ActivitySelection ob = new ActivitySelection();
        System.out.println(ob.activitySelection(A));
    }

    List<Activity> activitySelection(int[][] a) {
        if (a == null || a.length == 0) return null;
        int n = a.length;

        List<Activity> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Activity(a[i][0], a[i][1]));
        }

        Collections.sort(list, (a1, a2) -> {
            if (a1.end != a2.end) return a1.end - a2.end;
            return a1.start - a2.start;
        });

        List<Activity> result = new ArrayList<>();
        int selected = 0;
        result.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start >= list.get(selected).end) {
                result.add(list.get(i));
                selected = i;
            }
        }

        return result;
    }

    class Activity {
        int start;
        int end;

        Activity(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public String toString() {
            return "(" + this.start + ", " + this.end + ")";
        }
    }

}


