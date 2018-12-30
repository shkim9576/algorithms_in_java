package leetcode.one.easy;

//https://leetcode.com/problems/lemonade-change/
public class LemonedeChange {

    public static void main(String[] args) {
        LemonedeChange o = new LemonedeChange();
        System.out.println(o.lemonadeChange(new int[]{5, 5, 5, 10, 20})); //true
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int b : bills) {
            if (b == 5) five++;
            else if (b == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                five--;
                ten--;
            } else five -= 3;
            if (five < 0) return false;
        }

        return true;
    }
}
