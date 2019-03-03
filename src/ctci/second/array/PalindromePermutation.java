package ctci.second.array;

public class PalindromePermutation {
    public static void main(String[] args) {
        PalindromePermutation o = new PalindromePermutation();
        System.out.println(o.isPalindromePermutation("Tact Coa"));
    }

    boolean isPalindromePermutation(String s) {
        s = s.toLowerCase();
        boolean[] flags = new boolean[256];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) flags[c] = flags[c] ? false : true;
        }
        boolean found = false;
        for (boolean flag : flags) {
            if (flag) {
                if (found) return false;
                found = true;
            }
        }
        return true;
    }
}
