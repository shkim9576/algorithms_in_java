package leetcode.one.easy;

import java.util.List;

class Node {
    int val;
    List<Node> children;

    public Node(int v, List<Node> c) {
        this.val = v;
        this.children = c;
    }
}