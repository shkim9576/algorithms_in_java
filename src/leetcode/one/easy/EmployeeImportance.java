package leetcode.one.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/employee-importance/
public class EmployeeImportance {

    public static void main(String[] args) {
        EmployeeImportance o = new EmployeeImportance();
        o.test(o);
    }

    public void test(EmployeeImportance o) {

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;

        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = new ArrayList<Integer>();
        e1.subordinates.add(e2.id);
        e1.subordinates.add(e3.id);

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        System.out.println(o.getImportance(list, 1)); //11
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) map.put(e.id, e);

        return helper(map, id);
    }

    public int helper(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int result = e.importance;

        if (e.subordinates != null) {
            for (int i : e.subordinates) {
                result += helper(map, i);
            }
        }

        return result;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
