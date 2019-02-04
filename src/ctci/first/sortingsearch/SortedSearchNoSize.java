package ctci.first.sortingsearch;

import java.util.Arrays;

public class SortedSearchNoSize {

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9, 11, 15, 20};
        SortedSearchNoSize ob = new SortedSearchNoSize();
        System.out.println(ob.search(new Listy(A), 15));
    }

    static class Listy {
        int[] elements;

        Listy(int[] elements) {
            this.elements = new int[elements.length * 2];
            Arrays.fill(this.elements, -1);
            for (int i = 0; i < elements.length; i++) this.elements[i] = elements[i];
        }

        int elementAt(int i) {
            return elements[i];
        }
    }

    int search(Listy listy, int x) {
        int curr = 0;
        int jump = 1;

        while (listy.elementAt(curr) != -1 && listy.elementAt(curr) < x) {
            curr += jump;
            jump *= 2;
        }

        int l = (curr / 2);
        int r = curr;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (listy.elementAt(m) == x) return m;
            if (listy.elementAt(m) > x) r = m - 1;
            else l = m + 1;
        }

        return -1;
    }

}
