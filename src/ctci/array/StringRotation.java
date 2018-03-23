package ctci.array;

public class StringRotation {

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        StringRotation ob = new StringRotation();
        System.out.println(ob.isRotation(s1, s2));
    }

    boolean isRotation(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 == l2) {
            s1 += s1;
            System.out.println(s1.indexOf(s2));
            return s1.indexOf(s2) >= 0;
        }
        return false;
    }
}
