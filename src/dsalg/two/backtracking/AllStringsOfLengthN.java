package dsalg.two.backtracking;

public class AllStringsOfLengthN {
    public static void main(String[] args) {
        AllStringsOfLengthN o = new AllStringsOfLengthN();
        o.generateAllNBits(3);
    }

    void generateAllNBits(int n) {
        dfs("", 0);
    }

    void dfs(String path, int level) {
        if (level == 3) {
            System.out.println(path);
            return;
        }
        dfs(path + "0", level + 1);
        dfs(path + "1", level + 1);
    }

}
