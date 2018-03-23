package g4g.graph.excercise;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    // https://www.programcreek.com/2014/05/leetcode-course-schedule-java/

    public static void main(String[] args) {


        Prerequisite p1 = new Prerequisite(1, 0);
        Prerequisite p2 = new Prerequisite(0, 1);

        Prerequisite p3 = new Prerequisite(0, 1);
        Prerequisite p4 = new Prerequisite(1, 2);
        Prerequisite p5 = new Prerequisite(3, 4);

        CourseSchedule ob = new CourseSchedule();
        System.out.println(ob.canFinish(2, new Prerequisite[]{p1, p2}));
        System.out.println(ob.canFinish(5, new Prerequisite[]{p3, p4, p5}));
    }

    static class Prerequisite {
        int courseId;
        int preId;

        Prerequisite(int c, int p) {
            this.courseId = c;
            this.preId = p;
        }
    }

    public boolean canFinish(int numCourses, Prerequisite[] pre) {
        if (pre == null) return false;
        if (numCourses == 0 || pre.length == 0) return true;

        // count prerequisite
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < pre.length; i++) {
            pCounter[pre[i].preId]++;
        }

        // courses that have no prerequisite
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) q.add(i);
        }

        int numNoPre = q.size();

        while (!q.isEmpty()) {
            int top = q.remove();
            for (int i = 0; i < pre.length; i++) {
                if (pre[i].courseId == top) {
                    pCounter[pre[i].preId]--;
                    if (pCounter[pre[i].preId] == 0) {
                        numNoPre++;
                        q.add(pre[i].preId);
                    }
                }
            }
        }

        return numNoPre == numCourses;
    }

}
