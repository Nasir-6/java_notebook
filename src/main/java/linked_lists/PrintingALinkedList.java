package linked_lists;

public class PrintingALinkedList {
    public static class ListNode {
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

        // The Dummy here is so you can print the list out again
        // It stores the whole list - remember if you have the head you essentially have the list
        // see the toString - it loops through using .next to print
        // Singly linked list you can only go forward!!
        // Think of it like this:
        // The value you are on is always the head of it's own linkedList!!!
        ListNode dummy = new ListNode(0);
        // Current is the ListNode/pointer which will change! - This is needed to build the list/links!!
        // It is always the tail of the list!!
        ListNode current = dummy;

        for (int i = 1; i < 10; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        System.out.println("This is the current ListNode!!!!");
        System.out.println(current.toString());
        // 9
        // Note: This will only give the current listNode!! - Not the actual list
        // To get the actual list you'll need to start at the head - This is the role of the dummy Node See below
        // DONT MAKE THE MISTAKE OF THINKING THIS IS THE LIST!!! AND RETURNING JUST THE TAIL OF THE LIST BY RETURNING current
        // This is why it is named current - makes it very clear what it is
        // You named it linkedList - which confused the hell out of yourself!!


        System.out.println("This is the ListNode dummy i.e");
        System.out.println(dummy.next.toString());
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        // NOTE: The dummy is used to actually print/return the list once it's been made
        // The .next links (->) are shown in this listNode as that is what that Node consists of!

    }

}
