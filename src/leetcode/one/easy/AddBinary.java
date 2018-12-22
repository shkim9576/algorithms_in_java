package leetcode.one.easy;

//https://leetcode.com/problems/add-binary/
public class AddBinary {
    public static void main(String[] args) {
        AddBinary o = new AddBinary();
        System.out.println(o.addBinary("11", "1")); // 100
        System.out.println(o.addBinary("1010", "1011")); // 10101
    }

    public String addBinary(String a, String b) {

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += Character.getNumericValue(a.charAt(i--));
            if (j >= 0) sum += Character.getNumericValue(b.charAt(j--));
            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}
