package ctci.first.sortingsearch;

public class SortedMatrixSearch {

    public static void main(String[] args) {
        int[][] M = {{1, 3, 5, 7, 9},
                     {10, 13, 15, 17, 19},
                     {20, 23, 25, 27, 29},
                     {30, 33, 35, 37, 39},
                     {40, 43, 45, 47, 49}};

        SortedMatrixSearch ob = new SortedMatrixSearch();
        System.out.println(ob.find(M, 37));
    }

    boolean find(int[][] M, int x) {

        int numR = M.length;
        int numC = M[0].length;
        int rowIndex = 0;
        int colIndex = numC - 1;

        while (rowIndex >= 0 && rowIndex < numR && colIndex >= 0 && colIndex < numC) {
            if (M[rowIndex][colIndex] == x) return true;
            if (M[rowIndex][colIndex] > x) colIndex--;
            else rowIndex++;
        }

        return false;
    }

}
