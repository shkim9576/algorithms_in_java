package dsalg.two.string;

public class Combination {

    public static void main(String[] args) {
        Combination o = new Combination();
        o.combination("ABC", new StringBuffer(), 0);
    }

    void combination(String s, StringBuffer sb, int index) {
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            System.out.println(sb.toString());
            combination(s, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
