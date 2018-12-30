package leetcode.one.easy;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget o = new FindSmallestLetterGreaterThanTarget();
        System.out.println(o.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (letters[m] > target) r = m;
            else l = m + 1;
        }

        return target >= letters[l] ? letters[0] : letters[l];
    }
}
