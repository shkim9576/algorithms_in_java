package dsalg.two.string;

public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords o = new ReverseWords();
        System.out.println(o.reverseWord("This is good coding practice!"));
    }

    String reverseWord(String s) {
        if (s == null || s.length() == 0) return "";

        String[] strs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]).append(" ");
        }

        return sb.toString().trim();
    }
}
