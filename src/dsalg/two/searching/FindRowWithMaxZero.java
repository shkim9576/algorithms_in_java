package dsalg.two.searching;

public class FindRowWithMaxZero {

    public static void main(String[] args) {
        FindRowWithMaxZero o = new FindRowWithMaxZero();
        int[][] M = {{1, 1, 1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 0}};
        System.out.println(o.findRowWithMaxZero(M));
    }

    int findRowWithMaxZero(int[][] M) {
        int row = 0, col = M[0].length - 1;
        int count = 0, max = 0, ans = 0;

        while (row < M.length && col >= 0) {
            if (M[row][col] == 0) {
                count++;
                if (count > max) {
                    max = count;
                    ans = row;
                }
                col--;
                continue;
            } else {
                row++;
            }
        }

        return ans;
    }
}
