package ctci.second.array;

public class URLify {
    public static void main(String[] args) {
        URLify o = new URLify();
        System.out.println(o.replaceSpaces("Mr John Smith       ", 13));
    }

    private String replaceSpaces(String s, int n) {
        char[] chars = s.toCharArray();
        int numWhites = 0;
        for (int i=0; i<n; i++) {
            if (chars[i] == ' ') numWhites++;
        }

        int ri = n - 1;
        int wi = n + (2 * numWhites) - 1;
        while (numWhites > 0) {
            if (chars[ri] == ' ') {
                chars[wi--] = '0';
                chars[wi--] = '2';
                chars[wi--] = '%';
                numWhites--;
            } else {
                chars[wi--] = chars[ri];
            }
            ri--;
        }

        return new String(chars).trim();
    }
}
