package ctci.second.array;

public class StringRotation {
    public static void main(String[] args) {
        StringRotation o = new StringRotation();
        System.out.println(o.isRotation("watermelon", "melonwater"));
        System.out.println(o.isRotation("watermelon", "melonwatre"));
    }

    private boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return (s1 + s1).indexOf(s2) >= 0;
    }
}
