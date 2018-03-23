package g4g.heap.excercise;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom2 {
    // https://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/

    public static void main(String[] args) {
        Interval[] A1 = new Interval[]{new Interval(1, 6), new Interval(3, 8), new Interval(4, 10), new Interval(30, 80), new Interval(2, 15)};

        MeetingRoom2 ob = new MeetingRoom2();
        System.out.println(ob.meetingRoom(A1));
    }

    static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    int meetingRoom(Interval[] A) {
        if (A == null || A.length == 0) return 0;

        Arrays.sort(A, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        int max = 0;
        int count = 1;
        int index = 0;
        while (index < A.length-1) {
            while(index < A.length-1 && A[index].end < A[index+1].start) index++;

            while(index < A.length-1 && A[index].end > A[index+1].start) {
                count++;
                index++;
            }
            max = Math.max(max, count);
            count = 0;
        }

        return max;
    }


}
