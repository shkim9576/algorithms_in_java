package ctci.second.bit;

public class FlipBitToWin {

    public static void main(String[] args) {
        FlipBitToWin o = new FlipBitToWin();

        int n = Integer.valueOf("11011101111", 2);
        System.out.println(o.longestSequence(n));
    }

    private int longestSequence(int n) {
        String s = Integer.toString(n, 2);
        int ans = 0;
        int prevCount = 0;
        int currCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' || (i == s.length() - 1)) {
                if (i == s.length() - 1 && s.charAt(i) == '1') currCount++;
                ans = Math.max(ans, prevCount + currCount);
                prevCount = currCount;
                currCount = 0;
            } else {
                currCount++;
            }
        }

        return ans + 1;
    }
}
