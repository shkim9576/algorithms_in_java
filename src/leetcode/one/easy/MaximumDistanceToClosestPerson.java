package leetcode.one.easy;

//https://leetcode.com/problems/maximize-distance-to-closest-person/
public class MaximumDistanceToClosestPerson {


    public static void main(String[] args) {
        MaximumDistanceToClosestPerson o = new MaximumDistanceToClosestPerson();
        System.out.println(o.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1})); //2
    }

    public int maxDistToClosest(int[] seats) {
        int i, j, res = 0, n = seats.length;
        for (i = j = 0; j < n; ++j)
            if (seats[j] == 1) {
                if (i == 0) res = Math.max(res, j - i);
                else res = Math.max(res, (j - i + 1) / 2);
                i = j + 1;
            }
        res = Math.max(res, n - i);
        return res;
    }
}
