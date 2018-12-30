package leetcode.one.easy;

//https://leetcode.com/problems/robot-return-to-origin/
public class RobotReturnToOrigin {
    public static void main(String[] args) {
        RobotReturnToOrigin o = new RobotReturnToOrigin();
        System.out.println(o.judgeCircle("UD")); //true
    }

    public boolean judgeCircle(String moves) {
        int y = 0, x = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') y++;
            if (c == 'D') y--;
            if (c == 'L') x--;
            if (c == 'R') x++;
        }

        return x == 0 && y == 0;
    }
}
