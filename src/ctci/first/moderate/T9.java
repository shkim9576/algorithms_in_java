package ctci.first.moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T9 {


    static Map<Character, Integer> charToCode = new HashMap<>();

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("used");
        words.add("test");
        words.add("bank");
        words.add("coding");
        words.add("tree");
        words.add("wonderful");
        words.add("end");

        charToCode.put('a', 2);
        charToCode.put('b', 2);
        charToCode.put('c', 2);
        charToCode.put('d', 3);
        charToCode.put('e', 3);
        charToCode.put('f', 3);
        charToCode.put('g', 4);
        charToCode.put('h', 4);
        charToCode.put('i', 4);
        charToCode.put('j', 5);
        charToCode.put('k', 5);
        charToCode.put('l', 5);
        charToCode.put('m', 6);
        charToCode.put('n', 6);
        charToCode.put('o', 6);
        charToCode.put('p', 7);
        charToCode.put('q', 7);
        charToCode.put('r', 7);
        charToCode.put('s', 7);
        charToCode.put('t', 8);
        charToCode.put('u', 8);
        charToCode.put('v', 8);
        charToCode.put('w', 9);
        charToCode.put('x', 9);
        charToCode.put('y', 9);
        charToCode.put('z', 9);

        T9 ob = new T9();
        System.out.println(ob.getWords(words, 8733));

    }


    List<String> getWords(List<String> dict, int code) {

        Map<Integer, List<String>> codeToWords = new HashMap<>();
        for (String d : dict) {
            int c = convert(d);
            List<String> list = codeToWords.getOrDefault(c, new ArrayList<>());
            list.add(d);
            codeToWords.put(c, list);
        }
        return codeToWords.get(code);
    }


    int convert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(charToCode.get(c));
        }
        return Integer.valueOf(sb.toString());
    }
}
