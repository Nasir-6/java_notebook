package linked_lists;

public class ReversingLinkedList {
    public class ListNode {
        // Properties
        int val;
        ReversingLinkedList.ListNode next;

        // Constructors - need an empty one, one with val and another with val and next!!
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ReversingLinkedList.ListNode next) {
            this.val = val;
            this.next = next;
        }


        // This toString is made to override the default one of printing the memory location!
        // Goes through the list starting from the head - which we pass in
        @Override
        public String toString() {
            String result = "" + val;
            ReversingLinkedList.ListNode current = this.next;

            // IMPORTANT NOTE: if you want the value - you must use .val!!
            // Otherwise you will just get the memory location!!

            // Tip: always deal with current value, once that is done then update pointers at the end using .next!
            // This will ensure all values in the list are made
            while (current != null) {
                result = result + " -> " + current.val;

                // Update pointer
                current = current.next;

            }
            return result;
        }
    }

    public static void main(String[] args) {

        ReversingLinkedList reversingLinkedList = new ReversingLinkedList();
        ReversingLinkedList.ListNode myLinkedList = reversingLinkedList.makeALinkedList();


        ListNode reversedList = reversingLinkedList.reverseList(myLinkedList);
        System.out.println(reversedList);

    }

    public ListNode makeALinkedList(){
        ListNode dummy = new ListNode(0);
        // Current is the ListNode/pointer which will change! - This is needed to build the list/links!!
        // It is always the tail of the list!!
        ListNode current = dummy;

        for (int i = 1; i < 10; i++) {
            current.next = new ListNode(i);     // NOTE: SET current.next value!!!
            current = current.next;             // THEN SET current to the next value!!!
        }


        System.out.println("This is the ListNode that was created");
        System.out.println(dummy.next.toString());
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        return dummy.next;
    }



    // This is the actual method that reverses the list - used in LeetCode
    public ListNode reverseList(ListNode head) {

        // Initiliase curr, prev and nxt variables
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt = null;

        /* What happens in the while loop?
         Essentially the old curr.next link is redirected to the previous node
         whilst at the same time it moves onto the curr.next node in the list
         Now in order to break the link/redirect it and move onto the curr.next
         We need to store the next node value before the link is broken - thus a nxt Node is created!
         This is updated to store the nextNode in the list before the link is broken!
         So curr can be reassigned to it's old list Links at the end of each loop!
         */

        while(curr != null){
            nxt = curr.next;    //Store old curr with RHS links
            curr.next = prev;   // Now redirect the curr.next to prev value - i.e point left
            prev = curr;        // Now store this updated curr with redirected link in prev - to use later
            curr = nxt;         // move onto next ListNode on list - reupdate curr to old list
        }

        // prev is the reversed list
        return prev;
    }
}
