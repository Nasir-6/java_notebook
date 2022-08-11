package trees;

import java.util.ArrayList;
import java.util.List;      // IMPORT THIS FOR LIST!!!!
import java.util.Stack;     // IMPORT THIS FOR STACK!!

public class DepthFirstTraversal {
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

        // For a Depth First Traversal
        // Depth meaning down/deep - i.e it will go down before moving across!!
        // it will go as deep as possible returning each node - until it can't
        // 1 > 3 > 5
        // Then it will move onto the sibling node of the deepest node
        // 1 > 3 > 5 > 6
        // Then it will go back up and do the same for the rest of the nodes
        // 1 > 3 > 5 > 6 > 2 > 4
        // It's like traversing Deep on the left and then moving right and coming back up

        // Expected DFS List [1, 3, 5, 6, 2, 4]

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
            // else loop through currNode.children in reverse!!
            // DepthFirst traversal - go deep until you can't - Work down the LHS!!
            // If you start at the first child the stack will keep the RH Node on top and work through RHS!
            for (int i = currNode.children.size()-1; i >= 0; i--) {
                // push each to the stack
                stack.push(currNode.children.get(i));
            }
        }
        return traversalList;
    }


}
