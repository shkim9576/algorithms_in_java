package leetcode.one.easy;

import java.util.Arrays;

//https://leetcode.com/problems/heaters/submissions/
public class Heaters {

    public static void main(String[] args) {
        Heaters o = new Heaters();
        System.out.println(o.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4})); //1
    }

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;
    }

    public int findRadiusBinarySearch(int[] houses, int[] heaters) {
        if (houses == null || heaters == null) return Integer.MAX_VALUE;

        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int radius = getRadius(house, heaters);
            result = Math.max(radius, result);
        }

        return result;
    }

    int getRadius(int house, int[] heaters) {
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        int start = 0, end = heaters.length - 1;

        while (start <= end) {
            int m = start + (end - start) / 2;

            if (heaters[m] == house) return 0;
            else if (house > heaters[m]) {
                left = house - heaters[m];
                start = m + 1;
            } else {
                right = heaters[m] - house;
                end = m - 1;
            }
        }

        return Math.min(left, right);
    }
}
