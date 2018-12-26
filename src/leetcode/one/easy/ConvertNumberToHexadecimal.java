package leetcode.one.easy;

//https://leetcode.com/problems/convert-a-number-to-hexadecimal/
public class ConvertNumberToHexadecimal {

    public static void main(String[] args) {
        ConvertNumberToHexadecimal o = new ConvertNumberToHexadecimal();
        System.out.println(o.toHex(26)); //1a
    }

    public String toHex(int num) {
        if (num == 0) return "0";

        long n = num & 0x00000000ffffffffL;
        char[] unit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(unit[(int) (n % 16)]);
            n /= 16;
        }

        return sb.reverse().toString();
    }
}
