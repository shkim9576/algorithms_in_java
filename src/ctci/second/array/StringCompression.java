package ctci.second.array;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression o = new StringCompression();
        System.out.println(o.compress("aabcccccaaa"));
    }

    private String compress(String s) {
        if (s == null || s.length() < 2) return s;
        StringBuilder sb = new StringBuilder(s.length());
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i)).append(count);
                count = 0;
            }
        }
        return sb.length() > s.length() ? s : sb.toString();
    }
}
