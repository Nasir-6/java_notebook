package trees;

public class RecursiveIsValidBinarySearchTree {

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
        // [5,3,7,null,null,4,8]
        //          5
        //         / \
        //        3   7
        //          /  \
        //        (4)   8
        // Every child of node 7 should be greater than 5 and smaller than INF!! - i.e LB of limit is updated with 7!
        // THE 4 is on the RHS SO SHOULD BE More than 5!!
        // So expect FALSE

        BTNode root = new BTNode(5);
        BTNode node3 = new BTNode(3);
        BTNode node7 = new BTNode(7);
        BTNode node4 = new BTNode(4);
        BTNode node8 = new BTNode(8);

        root.left = node3;
        root.right = node7;
        node7.left = node4;
        node7.right = node8;


        // DO a DFS - but use a recursive solution as only way to update the limits whilst going down the two routes!!
        boolean isValidBST = isValidBinarySearchTree(root, null, null);

        System.out.println(isValidBST);
    }

    public static boolean isValidBinarySearchTree(BTNode node, Integer minLim, Integer maxLim) {
        if (node == null) return true;

        // if (node.val is less than the min) OR (greater than maxLim) IT IS INVALID!!
        // Also note
        if ((minLim != null && node.val <= minLim) || (maxLim != null && node.val >= maxLim))
            return false;

        // else carry on RECURSIVELY checking it's children - whilst passing in the updated limits!!
        return (isValidBinarySearchTree(node.left, minLim, node.val) && isValidBinarySearchTree(node.right, node.val, maxLim));
    }
}
