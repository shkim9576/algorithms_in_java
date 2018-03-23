package g4g.string.excercise;

public class IsPangram {
    // https://www.geeksforgeeks.org/pangram-checking/

    public static void main(String[] args) {
        IsPangram ob = new IsPangram();
        System.out.println(ob.isPangram("The quick brown fox jumps over the lazy dog")); //true
        System.out.println(ob.isPangram("The quick brown fox jumps over the dog")); // false
    }

    boolean isPangram(String in) {
        if (in == null || in.length() < 26) return false;

        boolean[] flags = new boolean[26];
        for (char c : in.toCharArray()) {
            int index = -1;
            if (c >= 'A' && c <= 'Z') index = c - 'A';
            if (c >= 'a' && c <= 'z') index = c - 'a';
            if (index != -1) flags[index] = true;
        }

        for (boolean b : flags) {
            if (!b) return false;
        }

        return true;
    }

}
