package leetcode.one.easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/distribute-candies/
public class DistributeCandies {

    public static void main(String[] args) {
        DistributeCandies o = new DistributeCandies();
        System.out.println(o.distributeCandies(new int[]{1, 1, 2, 2, 3, 3})); //3
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int c : candies) kinds.add(c);
        return Math.min(kinds.size(), candies.length / 2);
    }
}
