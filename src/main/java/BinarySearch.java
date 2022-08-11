public class BinarySearch {
    // Tip: BinarySearch can only be used for sorted array - so look out for these!

    public static void main(String[] args) {
        int [] nums = {-1,0,3,5,9,12};
        int target = 9;

        int indexOfTarget = binarySearchIterative(nums, target);
        if (indexOfTarget == -1){
            System.out.println("Target " + target + " is not in the array!");
        } else {
            System.out.println("Target " + target + " was found at index " + indexOfTarget + " in the array.");
        }
    }

    /*
        BinarySearch Time Complexity: O(log n) - log base 2!
        The way binary search works is by using a left and right pointer
        Checks value halfway through left and rigth pointer
        If the value is greater than target move right pointer to the index before
        If value is smaller than target move the left pointer to the index after
        Do this until left pointer > right pointer
        Or target is found
        IF not return -1
     */
    private static int binarySearchIterative(int[] nums, int target) {
        // initialise pointers
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){

            // THIS METHOD MAY overflow if left or right index very large numbers close to max int value (2^31)
//            int midIndex = (l + r) / 2;
            // This second way of getting the midIndex is used instead
            // Never overflow as right is always bigger than left
            // So always between 0 and max of int value (2^31)
            int midIndex = l + ( (r - l)  / 2 );

            int value = nums[midIndex];
            if (value == target) return midIndex;
            if (value > target) r = midIndex - 1;
            if (value < target) l = midIndex + 1;
        }
        return -1;
    }

}
