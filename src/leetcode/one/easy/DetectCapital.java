package leetcode.one.easy;

//https://leetcode.com/problems/detect-capital/
public class DetectCapital {

    public static void main(String[] args) {
        DetectCapital o = new DetectCapital();
        System.out.println(o.detectCapitalUse("USA"));
        System.out.println(o.detectCapitalUseExpress("USA"));
    }

    public boolean detectCapitalUseExpress(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        if (Character.isUpperCase(chars[0])) {
            return isAllLowerCase(chars, 1) || isAllUpperCase(chars, 1);
        }
        return isAllLowerCase(chars, 1);
    }

    boolean isAllLowerCase(char[] chars, int s) {
        for (int i = s; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) return false;
        }
        return true;
    }

    boolean isAllUpperCase(char[] chars, int s) {
        for (int i = s; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) return false;
        }
        return true;
    }
}
