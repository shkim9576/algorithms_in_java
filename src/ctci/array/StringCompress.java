package ctci.array;

public class StringCompress {

    public static void main(String[] args) {
        String s = "aabcccccaaa";

        StringCompress ob = new StringCompress();
        System.out.println(ob.compresS(s));
        System.out.println(ob.compresS("aaa"));
        System.out.println(ob.compresS("x"));
    }

    String compresS(String s) {
        if (s == null || s.length() < 2) return s;

        StringBuilder sb = new StringBuilder();
        int count = 0;
        char curr = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == curr) {
                count++;
            } else {
                sb.append(curr).append(count);
                count = 1;
            }
            curr = s.charAt(i);
        }

        sb.append(curr).append(count);
        return sb.length() < s.length() ? sb.toString() : s;
    }
}
