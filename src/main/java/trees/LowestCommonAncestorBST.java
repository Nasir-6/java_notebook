package trees;

public class LowestCommonAncestorBST {

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
        // [6,2,8,0,4,7,9,null,null,3,5]
        //                6
        //             /     \
        //         *|2|       8
        //          /  \     / \
        //         0  |4|   7   9
        //             / \
        //            3  5
        // Note the null values for left/right nodes with no child!
        // To find LCA of two nodes e.g (p=2, q=4)
        // It is Expected to be 2 - *as node itself can be an ancestor!

        BTNode root = new BTNode(6);
        BTNode node2 = new BTNode(2);
        BTNode node8 = new BTNode(8);
        BTNode node0 = new BTNode(0);
        BTNode node4 = new BTNode(4);
        BTNode node7 = new BTNode(7);
        BTNode node9 = new BTNode(9);
        BTNode node3 = new BTNode(3);
        BTNode node5 = new BTNode(5);

        root.left = node2;
        root.right = node8;

        node2.left = node0;
        node2.right = node4;

        node4.left = node3;
        node4.right = node5;

        node8.left = node7;
        node8.right = node9;


        BTNode lca = findLowestCommonAncestor(root, node2, node4);
        System.out.println(lca.val);

    }

    public static BTNode findLowestCommonAncestor(BTNode root, BTNode p, BTNode q){
            // Basic principle is check current node

        BTNode currNode = root;

        while (currNode != null){

            // NOTE: IN a Binary Search Tree - if a value is above the currNode value IT IS IN the right branch and vice-versa
            if(p.val > currNode.val && q.val > currNode.val){
                // if both p and q are in right branch - make currNode = currNode.right
                currNode = currNode.right;
            } else if (p.val < currNode.val && q.val < currNode.val){
                // if both p and q are in left branch - make currNode = currNode.left
                currNode = currNode.left;
            } else {
                // There is a split
                return currNode;
            }
        }

        // WONT ACTUALLY GET HERE - more for IntelliJ!
        return null;
    }



}
