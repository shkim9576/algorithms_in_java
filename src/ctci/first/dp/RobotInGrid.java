package ctci.first.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RobotInGrid {

    public static void main(String[] args) {
        boolean[][] M = {{true, true, false, true},
                         {true, false, false, true},
                         {true, true, false, true},
                         {false, true, true, true},
                         {true, true, false, true}};

        boolean[][] M2 = {{true, true, true, false},
                         {false, false, true, false},
                         {false, false, true, true},
                         {false, false, false, true},
                         {false, false, false, true}};

        RobotInGrid ob = new RobotInGrid();

        ArrayList<Point> result = ob.findPath(M);
        System.out.println(result);

    }

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public String toString() {
            return "r=" + r + "/c=" + c;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return r == p.r && c == p.c;
        }

        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    ArrayList<Point> findPath(boolean[][] M) {
        int numR = M.length;
        int numC = M[0].length;

        ArrayList<Point> path  = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        if (findPath(M, numR-1, numC-1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    boolean findPath(boolean[][] M, int r, int c, ArrayList<Point> path, Set<Point> failedPoint) {
        if (r < 0 || c < 0 || !M[r][c]) return false;

        Point p = new Point(r,c);
        if (failedPoint.contains(p)) return false;

        if (findPath(M, r-1, c, path, failedPoint) || findPath(M, r, c-1, path, failedPoint) || (r==0 && c==0)) {
            path.add(p);
            return true;
        }

        failedPoint.add(p);
        return false;
    }

}
