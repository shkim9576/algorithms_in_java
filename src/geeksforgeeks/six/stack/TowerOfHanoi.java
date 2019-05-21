package geeksforgeeks.six.stack;

public class TowerOfHanoi {

    public static void main(String[] args) {
        TowerOfHanoi o = new TowerOfHanoi();
        o.towerOfHanoi(3, "A", "B", "C");
    }

    void towerOfHanoi(int n, String from, String to, String temp) {
        if (n == 1) {
            System.out.println("Move disk 1 " + from + " - " + to);
            return;
        }

        towerOfHanoi(n - 1, from, temp, to);
        System.out.println("Move disk " + n + " " + from + " - " + to);
        towerOfHanoi(n - 1, temp, to, from);
    }
}
