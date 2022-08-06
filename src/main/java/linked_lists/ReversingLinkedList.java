package linked_lists;

public class ReversingLinkedList {
    public static class ListNode {
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


        ReversingLinkedList.ListNode dummyToReverse = new ReversingLinkedList.ListNode(0);
        // Current is the ListNode/pointer which will change! - This is needed to build the list/links!!
        // It is always the tail of the list!!
        ReversingLinkedList.ListNode current = dummyToReverse;

        for (int i = 1; i < 10; i++) {
            current.next = new ReversingLinkedList.ListNode(i);     // NOTE: SET current.next value!!!
            current = current.next;             // THEN SET current to the next value!!!
        }


        System.out.println("This is the ListNode dummyToReverse i.e");
        System.out.println(dummyToReverse.next.toString());
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9



        //========================== TIME TO REVERSE THE LIST!!!!!!!! ==========================
        // Now reverse it
        dummyToReverse = dummyToReverse.next;
        ListNode curr = dummyToReverse;

        // Need a next pointer which will save curr.next value while curr.next is updated to the prev Value!!
        // Go ahead and keep breaking next link and redirecting to prev
        // prev starts off as null - then keeps getting updated to curr.next whilst curr.next goes to next value
        // until curr is null - i.e end of the list to be reversed

        ListNode prev = null;
        ListNode nxt = null;        // nxt pointer is just here to save the curr.next value whilst curr.next is updated


        while (curr != null){
            // save the curr.next value - this link will be lost so need to keep - so can keep RHS of old list!
            nxt = curr.next;
            // Now point the curr.next value to prev - so it starts to point to prev value! - breaks previous curr.next link!
            curr.next = prev;
            // Now store the new redirected/reversed list in prev - since we will be reupdating curr with the RHS of old list
            prev = curr;        // curr here is with redirected next link!
            // Reupdate curr - with RHS of old list
            curr = nxt;     // curr here is the old next link - original direction!
        }

        System.out.println(prev.toString());

    }
}
