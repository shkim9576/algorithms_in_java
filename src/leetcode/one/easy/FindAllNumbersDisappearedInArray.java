package leetcode.one.easy;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindAllNumbersDisappearedInArray {

    public static void main(String[] args) {
        FindAllNumbersDisappearedInArray o = new FindAllNumbersDisappearedInArray();
        System.out.println(o.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1})); //5,6
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
