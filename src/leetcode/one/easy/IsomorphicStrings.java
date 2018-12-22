package leetcode.one.easy;

//https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings o = new IsomorphicStrings();
        System.out.println(o.isIsomorphic("egg", "add")); //true
        System.out.println(o.isIsomorphic("add", "egg")); //true
        System.out.println(o.isIsomorphic("foo", "bar")); //false
    }

    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
