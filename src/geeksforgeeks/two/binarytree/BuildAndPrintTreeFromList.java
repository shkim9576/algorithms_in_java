package geeksforgeeks.two.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuildAndPrintTreeFromList {

    public static void main(String[] args) {
        List<Pair> list = new ArrayList<>();
        list.add(new Pair("Animal", "Dog"));
        list.add(new Pair("Animal", "Cat"));
        list.add(new Pair("Dog", "Dog1"));
        list.add(new Pair("Dog", "Dog2"));
        list.add(new Pair("Cat", "Cat1"));

        BuildAndPrintTreeFromList ob = new BuildAndPrintTreeFromList();
        ob.printTree(list);
    }

    static class Pair {
        String parent;
        String child;

        Pair(String p, String c) {
            parent = p;
            child = c;
        }
    }

    static class Node {
        String data;
        List<Node> children = new ArrayList<>();
        Node(String d) {
            data = d;
        }
    }

    void printTree(List<Pair> list) {
        Node root = buildTree(list);
        printTree(root, new StringBuilder());
    }

    Node buildTree(List<Pair> list) {
        Map<String, Node> graph = new HashMap<>();
        Set<String> allParentSet = new HashSet<>();
        Set<String> allChildSet = new HashSet<>();

        for (Pair pair : list) {
            Node p = graph.getOrDefault(pair.parent, new Node(pair.parent));
            Node c = graph.getOrDefault(pair.child, new Node(pair.child));
            p.children.add(c);
            graph.put(p.data, p);
            graph.put(c.data, c);

            allParentSet.add(pair.parent);
            allChildSet.add(pair.child);
        }

        for (String s : allChildSet) {
            allParentSet.remove(s);
        }

        return graph.get(allParentSet.iterator().next());
    }

    void printTree(Node root, StringBuilder tabs) {
        if (root == null) return;

        System.out.print(tabs);
        System.out.println(root.data);
        tabs.append("\t");

        for (Node n : root.children) {
            printTree(n, tabs);
        }
        tabs.deleteCharAt(tabs.length()-1);
    }
}
