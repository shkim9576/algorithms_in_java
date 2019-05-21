package dsalg.one.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        TowerOfHanoi o = new TowerOfHanoi();
        o.towerOfHanoi(4, "A", "B", "C");
    }

    void towerOfHanoi(int n, String from, String to, String temp) {
        if (n < 1) return;
        if (n == 1) {
            System.out.printf("moving disk 1 from %s to %s \n", from, to);
            return;
        }

        towerOfHanoi(n - 1, from, temp, to);
        System.out.printf("moving disk %d from %s to %s \n", n, from, to);
        towerOfHanoi(n - 1, temp, to, from);
    }
}
