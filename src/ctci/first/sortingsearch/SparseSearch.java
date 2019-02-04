package ctci.first.sortingsearch;

public class SparseSearch {

    public static void main(String[] args) {
        String[] strs = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};  // 4
        SparseSearch ob = new SparseSearch();
        System.out.println(ob.sparseSearch(strs, "ball"));
    }

    int sparseSearch(String[] strs, String s) {

        int l = 0;
        int r = strs.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (strs[m].isEmpty()) m = findNonEmptyString(strs, l, r, m);

            if (m < l || m > r) return -1;
            if (s.equals(strs[m])) return m;
            if (s.compareTo(strs[m]) < 0) r = m - 1;
            else l = m + 1;
        }

        return -1;
    }

    int findNonEmptyString(String[] strs, int l, int r, int m) {
        int left = m;
        int right = m;
        while (left >= l || right <= r) {
            if (!strs[left].isEmpty()) return left;
            if (!strs[right].isEmpty()) return right;
            left--;
            right++;
        }
        return -1;
    }
}


