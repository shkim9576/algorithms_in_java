package leetcode.one.easy;

public class JewelsAndStones {

    public static void main(String[] args) {
        JewelsAndStones o = new JewelsAndStones();
        System.out.println(o.numJewelsInStones("aA", "aAAbbbb")); //3
    }

    public int numJewelsInStones(String J, String S) {
        int result = 0;
        for (char c : S.toCharArray()) {
            if (J.indexOf(c) != -1) result++;
        }
        return result;
    }
}

