package ctci.array;

public class URLify {

    public static void main(String[] args) {
        String s = " abc d ef z              ";  // %20abc%20d%20ef%20z
        URLify ob = new URLify();
        System.out.println(ob.urlify(s, 11));
    }

    String urlify(String s, int l) {
        int orgIndex = l - 1;
        int numSpace = count(s, l);
        int newIndex = l + 2 * numSpace - 1;

        char[] chars = s.toCharArray();
        while (numSpace > 0) {
            if (chars[orgIndex] == ' ') {
                numSpace--;
                chars[newIndex--] = '0';
                chars[newIndex--] = '2';
                chars[newIndex--] = '%';
            } else {
                chars[newIndex--] = chars[orgIndex];
            }
            orgIndex--;
        }

        return new String(chars).trim();
    }

    int count(String s, int l) {
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == ' ') count++;
        }
        return count;
    }
}
