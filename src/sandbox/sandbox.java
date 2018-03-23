package sandbox;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sandbox {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.remove(20);
        System.out.println(set);

        List<Integer> list = new ArrayList<>();
        list.add(new Integer(100));
        list.add(new Integer(200));
        list.add(new Integer(300));
        list.remove(1);
        list.remove(1);
        System.out.println(list);
    }

}
