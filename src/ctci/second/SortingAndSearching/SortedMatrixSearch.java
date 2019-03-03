package ctci.second.SortingAndSearching;

public class SortedMatrixSearch {

    public static void main(String[] args) {
        SortedMatrixSearch o = new SortedMatrixSearch();

        int[][] M = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
        System.out.println(o.search(M, 85));
        System.out.println(o.search(M, 100));
        System.out.println(o.search(M, 0));
    }

    private boolean search(int[][] M, int target) {
        int R = M.length;
        int C = M[0].length;

        int c = C - 1;
        int r = 0;
        while (c >= 0 && r < R) {
            if (M[r][c] == target) return true;
            if (M[r][c] < target) r++;
            else c--;
        }

        return false;
    }


}
