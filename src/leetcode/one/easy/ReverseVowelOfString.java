package leetcode.one.easy;

//https://leetcode.com/problems/reverse-vowels-of-a-string/
public class ReverseVowelOfString {

    public static void main(String[] args) {
        ReverseVowelOfString o = new ReverseVowelOfString();
        System.out.println(o.reverseVowels("hello")); //holle
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while (l < r) {
            while (l < r && !isVowel(chars[l])) l++;
            while (l < r && !isVowel(chars[r])) r--;
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }

        return new String(chars);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
