package hash_maps;

import java.util.Arrays;
import java.util.HashMap;

public class FindingComplementaryPairsForASumTarget {

    // This method is of O(n) time complexity to find a pair of numbers in an array that sum up to a target value
    // As this method only loops through the array once
    // This is done by:
    // 1) Looping through the array
    // 2) storing the each of the array values as the key
    // 3) Storing the index as the Values
    // 4) A secondPair value is calculated each time and checked if present within the hashMap
    // if it is - the indexes of the pair of values are returned!


    // This is much more efficinet than my original method of looping through array
    // Then for each value in the array looping through the array to find the complementary pair to reach the target
    // My Old method would be of O(n^2) time complexity
    // This new method is better with O(n)!!!


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 5;
        System.out.println(Arrays.toString(findingComplementaryPairsForASumTarget(nums, target)));
    }

    public static int[] findingComplementaryPairsForASumTarget(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Key: actual value of the number
        // Value: Index (Stored using the for loop!)
        for(int i =0; i<nums.length; i++){
            // Loop through array
            // First check if the target - current value key exists!
            int secondPair = target - nums[i];
            // if exists return the pair of numbers as an array!
            if (map.containsKey(secondPair)) return new int[] {map.get(secondPair), i};
            map.put(nums[i], i);    // Else store the target value in the map
        }
        return new int[] { 0, 0 };
    }
}
