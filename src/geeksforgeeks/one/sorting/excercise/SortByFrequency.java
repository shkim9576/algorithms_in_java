package geeksforgeeks.one.sorting.excercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortByFrequency {
    // https://www.geeksforgeeks.org/sort-elements-by-frequency/

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 8, 5, 6, 8, 8}; // {8, 8, 8, 2, 2, 5, 5, 6}

        SortByFrequency ob = new SortByFrequency();
        System.out.println(ob.sortByFrequency(arr));

        arr = new int[] {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}; // {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
        System.out.println(ob.sortByFrequency(arr));
    }

    class Element {
        int index;
        int freq;

        Element(int index, int freq) {
            this.index = index;
            this.freq = freq;
        }
    }


    List<Integer> sortByFrequency(int[] A) {
        if (A == null || A.length == 0) return null;

        Map<Integer, Element> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                Element e = map.get(A[i]);
                e.freq++;
            } else {
                map.put(A[i], new Element(i, 1));
            }
        }

        Map<Integer, Element> sortedMap = new TreeMap<>(new ValueComp(map));
        sortedMap.putAll(map);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Element> e : sortedMap.entrySet()) {
            Element el = e.getValue();
            for (int i = 0; i < el.freq; i++) result.add(e.getKey());
        }

        return result;
    }

    static class ValueComp implements Comparator<Integer> {
        Map<Integer, Element> map = new HashMap<>();

        public ValueComp(Map<Integer, Element> map) {
            this.map.putAll(map);
        }

        @Override
        public int compare(Integer k1, Integer k2) {
            Element e1 = this.map.get(k1);
            Element e2 = this.map.get(k2);
            if (e1.freq != e2.freq) return e2.freq - e1.freq;
            return e1.index - e2.index;
        }
    }

}
