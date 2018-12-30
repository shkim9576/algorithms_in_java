package leetcode.one.easy;

//https://leetcode.com/problems/range-addition-ii/
public class RangeAddition2 {

    public static void main(String[] args) {
        RangeAddition2 o = new RangeAddition2();
        System.out.println(o.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}})); //4
    }

    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) return m * n;

        int r = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;

        for (int[] op : ops) {
            r = Math.min(r, op[0]);
            c = Math.min(c, op[1]);
        }

        return r * c;
    }
}
