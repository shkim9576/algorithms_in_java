package ctci.second.SortingAndSearching;

public class SparseSearch {

    public static void main(String[] args) {
        SparseSearch o = new SparseSearch();
        String[] strs = {"abc", "", "", "", "", "", "dad", "", "", "earth", "", "", "hello", "", "", "", "large", "", "", "xxx", ""};
        System.out.println(o.search(strs, "hello")); //12
        System.out.println(o.search(strs, "nothing")); //12
    }

    private int search(String[] strs, String target) {
        if (strs == null || target == null) return -1;
        return search(strs, target, 0, strs.length - 1);
    }

    private int search(String[] strs, String target, int l, int r) {
        int m = (l + r) / 2;

        if (strs[m].isEmpty()) {
            int left = m - 1, right = m + 1;
            while (true) {
                if (left < l && right > r) return -1;
                else if (left >= l && !strs[left].isEmpty()) {
                    m = left;
                    break;
                } else if (right <= r && !strs[right].isEmpty()) {
                    m = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if (strs[m].equals(target)) return m;
        else if (strs[m].compareTo(target) < 0) return search(strs, target, m + 1, r);
        else return search(strs, target, l, m - 1);
    }
}
