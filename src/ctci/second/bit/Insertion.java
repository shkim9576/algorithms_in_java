package ctci.second.bit;

public class Insertion {

    public static void main(String[] args) {
        Insertion o = new Insertion();
        int N = Integer.valueOf("10000000000", 2);
        int M = Integer.valueOf("10011", 2);
        int ans = o.merge(N, M, 2, 6);
        System.out.println(Integer.toString(ans, 2));
    }

    private int merge(int N, int M, int i, int j) {
        int ones = ~0;
        int leftMask = ones << (j + 1);
        int rightMask = (1 << i) - 1;
        int mask = leftMask | rightMask;
        int cleaned = mask & N;
        int shifted = M << i;
        return cleaned | shifted;
    }

}
