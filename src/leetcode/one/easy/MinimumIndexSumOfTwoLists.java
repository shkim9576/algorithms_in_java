package leetcode.one.easy;

import java.util.*;

// https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists o = new MinimumIndexSumOfTwoLists();
        System.out.println(Arrays.toString(o.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}))); //[Shogun]
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);

        List<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (map.get(list2[i]) + i < min) {
                    min = map.get(list2[i]) + i;
                    result = new ArrayList<>();
                    result.add(list2[i]);
                } else if (map.get(list2[i]) + i == min) {
                    result.add(list2[i]);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
