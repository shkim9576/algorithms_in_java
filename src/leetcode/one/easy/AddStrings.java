package leetcode.one.easy;

//https://leetcode.com/problems/add-strings/
public class AddStrings {

    public static void main(String[] args) {
        AddStrings o = new AddStrings();
        System.out.println(o.addStrings("123", "1234")); //1357
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int sum = i >= 0 ? num1.charAt(i) - '0' : 0;
            sum += j >= 0 ? num2.charAt(j) - '0' : 0;
            sum += carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
