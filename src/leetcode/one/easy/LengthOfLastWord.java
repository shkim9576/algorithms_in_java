package leetcode.one.easy;

//https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord o = new LengthOfLastWord();
        System.out.println(o.lengthOfLastWord("Hello World")); //5
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();

        int result = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) != ' ') result++;
            else return result;
        }

        return result;
    }
}
