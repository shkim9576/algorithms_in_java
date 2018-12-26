package leetcode.one.easy;

//https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        FirstUniqueCharacterInString o = new FirstUniqueCharacterInString();
        System.out.println(o.firstUniqChar("loveleetcode")); //2
    }

    public int firstUniqChar(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) count[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }
}
