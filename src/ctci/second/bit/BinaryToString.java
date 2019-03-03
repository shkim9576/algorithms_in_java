package ctci.second.bit;

public class BinaryToString {

    public static void main(String[] args) {
        BinaryToString o = new BinaryToString();
        System.out.println(o.printBinary(0.75));
    }

    private String printBinary(double num) {
        if (num >= 1 || num <= 0) return "Error";

        StringBuilder ans = new StringBuilder();
        double div = 0.5;
        ans.append("0.");
        while (num > 0) {
            if (ans.length() > 32) return "Error";
            if (num >= div) {
                ans.append(1);
                num -= div;
            } else {
                ans.append(0);
            }
            div /= 2;
        }

        return ans.toString();
    }
}
