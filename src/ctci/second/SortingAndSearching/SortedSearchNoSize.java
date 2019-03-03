package ctci.second.SortingAndSearching;

import java.util.ArrayList;
import java.util.List;

public class SortedSearchNoSize {

    public static void main(String[] args) {
        SortedSearchNoSize o = new SortedSearchNoSize();
        System.out.println(o.search(341)); //13
    }

    private int search(int val) {
        Listy listy = new Listy();
        if (listy.elementAt(0) == val) return 0;

        int index = 1;
        while (listy.elementAt(index) == -1 || listy.elementAt(index) < val) index *= 2;
        return search(listy, val, index / 2, index);
    }

    private int search(Listy listy, int val, int l, int r) {
        int m = (l + r) / 2;
        if (listy.elementAt(m) == val) return m;
        else if (listy.elementAt(m) == -1 || listy.elementAt(m) > val) return search(listy, val, l, m - 1);
        else return search(listy, val, m + 1, r);
    }

    static class Listy {
        List<Integer> listy = new ArrayList<>();

        Listy() {
            listy.add(5);
            listy.add(5);
            listy.add(15);
            listy.add(17);
            listy.add(20);
            listy.add(20);
            listy.add(35);
            listy.add(41);
            listy.add(41);
            listy.add(141);
            listy.add(160);
            listy.add(163);
            listy.add(241);
            listy.add(341);
            listy.add(441);
            listy.add(541);
            listy.add(777);
            listy.add(777);
        }

        int elementAt(int i) {
            if (i >= listy.size()) {
                return -1;
            }
            return listy.get(i);
        }
    }
}
