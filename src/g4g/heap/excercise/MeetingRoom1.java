package g4g.heap.excercise;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom1 {
    // https://www.programcreek.com/2014/07/leetcode-meeting-rooms-java/

    public static void main(String[] args) {
        Interval[] A1 = new Interval[]{new Interval(1, 5), new Interval(3, 8)};  // false
        Interval[] A2 = new Interval[]{new Interval(1, 5), new Interval(6, 8)};  // true
        Interval[] A3 = new Interval[]{new Interval(10, 50), new Interval(3, 8)}; // true
        Interval[] A4 = new Interval[]{new Interval(10, 50), new Interval(3, 15)}; //false

        MeetingRoom1 ob = new MeetingRoom1();
        System.out.println(ob.meetingRoom(A1));
        System.out.println(ob.meetingRoom(A2));
        System.out.println(ob.meetingRoom(A3));
        System.out.println(ob.meetingRoom(A4));
    }

    static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    boolean meetingRoom(Interval[] A) {
        if (A == null || A.length == 0) return false;

        Arrays.sort(A, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i].end > A[i + 1].start) return false;
        }

        return true;
    }

}
