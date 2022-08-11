package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;  // DON't FORGET FOR LIST!
import java.util.Queue;

public class BreadthFirstBinaryTree {

    //    Definition for a Binary Tree (BT) node.
    public static class BTNode {
        int val;
        BTNode left;
        BTNode right;

        BTNode() {
        }

        BTNode(int val) {
            this.val = val;
        }

        BTNode(int val, BTNode left, BTNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // Create Binary tree
        // [3,9,20,null,null,15,7]
        //          3
        //         / \
        //        9   20
        //      /    /  \
        //     10   15   7
        // Note the null values for left/right nodes with no child!

        BTNode root = new BTNode(3);
        BTNode node9 = new BTNode(9);
        BTNode node20 = new BTNode(20);
        BTNode node10 = new BTNode(10);
        BTNode node15 = new BTNode(15);
        BTNode node7 = new BTNode(7);

        root.left = node9;
        root.right = node20;
        node9.left = node10;
        node20.left = node15;
        node20.right = node7;

        // DO a Breadth-First LEVEL ORDER traversal
        // Breadth meanining width - i.e we go across first before going deeper!
        // Expect Output: [[3],[9,20],[10,15,7]] - each level is a list in itself!!
        List<List<Integer>> list = DFlevelOrder(root);

        System.out.println(list);
    }

    public static List<List<Integer>> DFlevelOrder(BTNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge Case
        if (root == null) return result;

        // Initialise Queue - use a queue so can traverse level by level!!
        // NOTE: Need to use LinkedList as Queue is an interface - the implementation must be via another class! e.g LL
        Queue<BTNode> q = new LinkedList<>();
        // Two methods for FIFO implementation of queues
        // add - to add to back of q
        // remove() - to pop off the first in line

        // Start off with root
        q.add(root);
        while (!q.isEmpty()){
            // each level is a list which is created at the start and appended at the end
            List<Integer> oneLevel = new ArrayList<>();

            // Loop through current level stored in the queue
            // NOTE: Don't use q.size() in the for loop!! - as it changes!!
            int numOfNodesInCurrLevel = q.size();
            for (int i = 0; i < numOfNodesInCurrLevel; i++) {

                // pop off first queue value and evaluate its children - add them to the q
                BTNode currNode = q.remove();
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);

                // add the currNode to the one level list
                oneLevel.add(currNode.val);
            }
            result.add(oneLevel);
        }
        return result;
    }
}
