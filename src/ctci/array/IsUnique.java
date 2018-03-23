package ctci.array;

public class IsUnique {

    public static void main(String[] args) {
        String str1 = "abdekp"; // true
        String str2 = "axdza";  // false

        IsUnique ob = new IsUnique();
        System.out.println(ob.isUnique(str1));
        System.out.println(ob.isUnique(str2));
    }

    boolean isUnique(String s) {
        boolean[] exist = new boolean[256];
        for (char c : s.toCharArray()) {
            if (exist[c]) return false;
            exist[c] = true;
        }
        return true;
    }
}
