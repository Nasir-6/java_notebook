package trees;

import java.util.ArrayList;
import java.util.List;      // IMPORT THIS FOR LIST!!!!
import java.util.Stack;     // IMPORT THIS FOR STACK!!

public class TreeTraversal {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {
        //create Tree
        // [1,null,3,2,4,null,5,6]
        //          1
        //      /   |   \
        //      3   2   4
        //     / \
        //    5   6

        // Expect [1, 3, 5, 6, 2, 4]

        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        root.children = new ArrayList<Node>(){{
            add(node3);
            add(node2);
            add(node4);
        }};

        node3.children = new ArrayList<Node>(){{
            add(node5);
            add(node6);
        }};

        System.out.println(root.children.get(0).val);

        // Traverse the tree
        List<Integer> list = traverseTree(root);


        //sout the traversal list
        System.out.println(list);   // [1, 3, 5, 6, 2, 4]


    }

    private static List<Integer> traverseTree(Node root) {

        // Edge case
        if(root == null) return new ArrayList<>();

        // Initialise list
        List<Integer> traversalList = new ArrayList<>();

        Stack<Node> stack = new Stack<>();

        // start from root push to stack
        stack.push(root);

        // while stack.length > 0 ;
        while (!stack.isEmpty()) {
            // pop and store in currNode
            Node currNode = stack.pop();
            // add currNode to the traversalList
            traversalList.add(currNode.val);

            // if no children move on
            if (currNode.children == null) continue;
            // else loop through currNode.children in reverse!! - DepthFirst traversal - go deep until you can't
            for (int i = currNode.children.size()-1; i >= 0; i--) {
                // push each to the stack
                stack.push(currNode.children.get(i));
            }
        }
        return traversalList;
    }


}
