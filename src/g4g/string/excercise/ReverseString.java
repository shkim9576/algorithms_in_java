package g4g.string.excercise;

public class ReverseString {
    // https://www.geeksforgeeks.org/reverse-a-string-using-recursion/

    public static void main(String[] args) {
        ReverseString ob = new ReverseString();
        System.out.println(ob.reverse("abcdef"));
    }

    String reverse(String str) {
        return reverse(str, 0, str.length() - 1);
    }

    String reverse(String str, int l, int r) {
        if (l >= r) return str;

        char[] chars = str.toCharArray();
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
        return reverse(new String(chars), l+1, r-1);
    }

}
