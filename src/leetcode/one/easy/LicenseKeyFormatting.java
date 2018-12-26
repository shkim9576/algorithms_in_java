package leetcode.one.easy;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        LicenseKeyFormatting o = new LicenseKeyFormatting();
        System.out.println(o.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    public String licenseKeyFormatting(String S, int K) {

        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '-') {
                if (count / K == 1) {
                    sb.append("-");
                    count = 0;
                }

                sb.append(chars[i]);
                count++;
            }
        }

        return sb.reverse().toString().toUpperCase();
    }
}
