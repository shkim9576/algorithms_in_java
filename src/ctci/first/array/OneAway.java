package ctci.first.array;

public class OneAway {
    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "ple"; // true

        OneAway ob = new OneAway();
        System.out.println(ob.oneAway(s1, s2));

        s1 = "pales";
        s2 = "pale"; // true
        System.out.println(ob.oneAway(s1, s2));

        s1 = "pale";
        s2 = "bale"; // true
        System.out.println(ob.oneAway(s1, s2));

        s1 = "pale";
        s2 = "bae"; // false;
        System.out.println(ob.oneAway(s1, s2));
    }

    boolean oneAway(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (Math.abs(l1 - l2) > 1) return false;

        String shorter = l1 > l2 ? s2 : s1;
        String longer = l1 > l2 ? s1 : s2;
        boolean found = false;

        if (l1 == l2) {
            for (int i = 0; i < l1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (found) return false;
                    else found = true;
                }
            }
        } else {
            for (int s = 0, l = 0; s < shorter.length(); s++, l++) {
                if (shorter.charAt(s) != longer.charAt(l)) {
                    if (found) return false;
                    else {
                        found = true;
                        l++;
                    }
                }
            }
        }

        return true;
    }
}
