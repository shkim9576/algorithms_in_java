package leetcode.one.easy;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/
public class ReverseWordsInString3 {

    public static void main(String[] args) {
        ReverseWordsInString3 o = new ReverseWordsInString3();
        System.out.println(o.reverseWords("Let's take LeetCode contest")); //s'teL ekat edoCteeL tsetnoc
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }

        return String.join(" ", words);
    }

    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            char t = chars[l];
            chars[l] = chars[r];
            chars[r] = t;
            l++;
            r--;
        }
        return new String(chars);
    }
}
