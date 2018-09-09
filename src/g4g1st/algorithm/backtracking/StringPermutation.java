package g4g1st.algorithm.backtracking;

public class StringPermutation {
    // https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

    public static void main(String[] args) {
        String str = "ABC";
        StringPermutation ob = new StringPermutation();
        ob.permutation(str);
    }

    void permutation(String str) {
        if (str == null || str.length() == 0) return;
        permutation(str, 0, str.length() - 1);
    }

    void permutation(String str, int l, int r) {
        if (l == r) System.out.println(str);

        for (int i = l; i <= r; i++) {
            str = swap(str, l, i);
            permutation(str, l + 1, r);
            str = swap(str, l, i);
        }
    }

    String swap(String s, int l, int r) {
        char[] chars = s.toCharArray();
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
        return new String(chars);
    }

}
