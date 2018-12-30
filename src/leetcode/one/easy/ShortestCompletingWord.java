package leetcode.one.easy;

public class ShortestCompletingWord {

    public static void main(String[] args) {
        ShortestCompletingWord o = new ShortestCompletingWord();
        System.out.println(o.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"})); //steps
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        String target = licensePlate.toLowerCase();

        int[] charMap = new int[26];
        for (int i = 0; i < target.length(); i++) {
            if (Character.isLetter(target.charAt(i))) charMap[target.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        String result = null;

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (matches(word, charMap) && word.length() < min) {
                min = word.length();
                result = word;
            }
        }

        return result;
    }

    private boolean matches(String word, int[] charMap) {
        int[] targetMap = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetterOrDigit(word.charAt(i))) targetMap[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charMap[i] != 0 && targetMap[i] < charMap[i]) return false;
        }

        return true;
    }

}
