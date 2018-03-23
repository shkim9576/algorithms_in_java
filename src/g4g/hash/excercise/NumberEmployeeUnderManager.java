package g4g.hash.excercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberEmployeeUnderManager {
    // https://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/

    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");

        NumberEmployeeUnderManager ob = new NumberEmployeeUnderManager();
        Map<String, Integer> result = ob.countEmployees(dataSet);
        System.out.println("result = " + result);
    }

    Map<String, Integer> countEmployees(Map<String, String> in) {
        Map<String, Integer> result = new HashMap<>();
        if (in == null || in.size() == 0) return result;

        String root = "";
        Map<String, List<String>> hMap = new HashMap<>();
        for (Map.Entry<String, String> entry : in.entrySet()) {

            List<String> employees;
            if (hMap.containsKey(entry.getValue())) {
                employees = hMap.get(entry.getValue());
            } else {
                employees = new ArrayList<>();
            }

            if (entry.getKey().equals(entry.getValue())) {
                root = entry.getKey();
            } else {
                employees.add(entry.getKey());
                hMap.put(entry.getValue(), employees);
            }
        }

        count(hMap, result, root);

        return result;
    }

    int count(Map<String, List<String>> hMap, Map<String, Integer> result, String root) {
        if (root == null) return 0;

        List<String> employees = hMap.get(root);
        if (employees == null) {
            result.put(root, 0);
            return 0;
        }

        int sum = employees.size();

        for (int i = 0; i < employees.size(); i++) {
            sum += count(hMap, result, employees.get(i));
        }
        result.put(root, sum);

        return sum;
    }
}
