package leetcode.one.easy;

//https://leetcode.com/problems/long-pressed-name/
public class LongPressedName {

    public static void main(String[] args) {
        LongPressedName o = new LongPressedName();
        System.out.println(o.isLongPressedName("alex", "aaleex")); //true
        System.out.println(o.isLongPressedName("a", "ab")); //false
    }

    public boolean isLongPressedName(String name, String typed) {
        int ti = 0, ni = 0;
        while (ti < typed.length()) {
            if (ni < name.length() && name.charAt(ni) == typed.charAt(ti)) ni++;
            else if (ti == 0 || typed.charAt(ti) != typed.charAt(ti - 1)) return false;
            ti++;
        }

        return ni == name.length();
    }
}
