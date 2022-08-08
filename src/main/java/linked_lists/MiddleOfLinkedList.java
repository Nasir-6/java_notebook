package linked_lists;

public class MiddleOfLinkedList {

    public class ListNode {
        // Properties
        int val;
        ListNode next;

        // Constructors - need an empty one, one with val and another with val and next!!
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


        // This toString is made to override the default one of printing the memory location!
        // Goes through the list starting from the head - which we pass in
        @Override
        public String toString() {
            String result = "" + val;
            ListNode current = this.next;

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
        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        ListNode myLinkedList = middleOfLinkedList.makeALinkedList();

        ListNode middleOfList = middleOfLinkedList.middleNode(myLinkedList);
        System.out.println(middleOfList.toString());


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



    public ListNode middleNode(ListNode head) {
        // copy the head into two lists
        // slowPointer
        ListNode slowCurr = head;
        // FastPointer
        ListNode fastCurr = head;

        // DO while loop as long as fastPointer.next is not null
        // increment fastPointer twice as fast as slowPointer - so slow is always halfway!
        // Also return slowPointer after the intial increment of both slow and fast
        // as that means it will always return the middle rightmost node
        while(fastCurr.next != null){
            // go next in fastPointer
            fastCurr = fastCurr.next;
            // go next in slowPointer
            slowCurr = slowCurr.next;

            // check if fastPointer next is null
            if(fastCurr.next == null) return slowCurr;
            // if so return slowPointer curr value - as that is middle (rightmost val)
            // else just go to next in fast loop
            fastCurr = fastCurr.next;
        }


        // return slowPointer - as that is the middle
        return slowCurr;
    }
}
