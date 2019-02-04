package ctci.first.array;

public class IsPermutationPalidrome {

    public static void main(String[] args) {
        String s = "Tact Coa"; // true
        IsPermutationPalidrome ob = new IsPermutationPalidrome();
        System.out.println(ob.isPermPal(s));

        s = "ab"; // false
        System.out.println(ob.isPermPal(s));

        s = "aabbc"; // true
        System.out.println(ob.isPermPal(s));

    }

    boolean isPermPal(String s) {
        s = s.toLowerCase();
        boolean[] flags = new boolean[256];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') flags[c] = flags[c] ? false : true;
        }

        int numSingles = 0;
        for (boolean b : flags) {
            if (b) numSingles++;
            if (numSingles > 1) return false;
        }

        return true;
    }
}
