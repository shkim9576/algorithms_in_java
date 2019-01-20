package geeksforgeeks.five.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
public class FindNumberOfEmployeesUnderEveryManager {

    //result = {D=0, E=1, F=5, A=0, B=0, C=2}
    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");

        populateResult(dataSet);
    }


    static void populateResult(Map<String, String> map) {
        Map<String, List<String>> mToe = new HashMap<>();

        String root = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String emp = entry.getKey();
            String mgr = entry.getValue();

            if (!emp.equals(mgr)) {
                List<String> empList = mToe.getOrDefault(mgr, new ArrayList<>());
                empList.add(emp);
                mToe.put(mgr, empList);
            } else {
                root = mgr;
            }
        }

        Map<String, Integer> result = new HashMap<>();
        countEmployees(root, mToe, result);
        System.out.println("result = " + result);
    }

    static int countEmployees(String person, Map<String, List<String>> mToe, Map<String, Integer> result) {

        // leaf node who is not a manager
        if (!mToe.containsKey(person)) {
            result.put(person, 0);
            return 0;
        }

        int count = mToe.get(person).size();
        for (String p : mToe.get(person)) {
            count += countEmployees(p, mToe, result);
        }

        result.put(person, count);
        return count;
    }
}
