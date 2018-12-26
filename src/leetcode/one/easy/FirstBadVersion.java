package leetcode.one.easy;

//https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {

    public static void main(String[] args) {
        FirstBadVersion o = new FirstBadVersion();
        System.out.println(o.firstBadVersion(5)); // 4
    }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) r = m - 1;
            else l = m + 1;
        }

        return l;
    }

    public boolean isBadVersion(int n) {
        return n >= 4;
    }
}
