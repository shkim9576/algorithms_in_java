package dsalg.two.string;

public class Permutation {

    public static void main(String[] args) {
        Permutation o = new Permutation();
        o.permutation("ABC");
    }

    void permutation(String s) {
        permutation(s.toCharArray(), 0, s.length() - 1);
    }

    void permutation(char[] chars, int l, int r) {
        if (l == r) System.out.println(new String(chars));
        else {
            for (int i = l; i <= r; i++) {
                swap(chars, i, l);
                permutation(chars, l + 1, r);
                swap(chars, i, l);
            }
        }
    }

    void swap(char[] chars, int x, int y) {
        char c = chars[x];
        chars[x] = chars[y];
        chars[y] = c;
    }
}
