package leetcode.one.easy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/positions-of-large-groups/
public class PositionOfLargeGroups {

    public static void main(String[] args) {
        PositionOfLargeGroups o = new PositionOfLargeGroups();
        System.out.println(o.largeGroupPositions("abbxxxxzzy")); //[[3, 6]]
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        int l = 0, r = 0, N = S.length();

        while (r < N) {
            while (r < N && S.charAt(l) == S.charAt(r)) r++;
            ;
            if (r - l >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(l);
                list.add(r - 1);
                result.add(list);
            }
            l = r;
        }

        return result;
    }
}
