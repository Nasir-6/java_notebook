package hash_maps;

import java.util.HashMap;

public class StringReconstruction {


    // This challenge sees if it can reconstruct string1 using the second string
    // It does this by storing the occurrences of each character of string 1 in a hashmap
    // Then it loops through the second string and checks if there are enough characters to form string 1
    // This is done by checking the hashmap for it and if so it also deducts the occurrence -
    // so if it is needed again and not enough occurrences are there it will return false


    public static void main(String[] args) {

        String str1 = "brag to day";
        String str2 = "grab today";
        System.out.println(canReconstruct(str1, str2)); // false
        // As str2 cannot be reconstructed into str1 as missing an extra space!!!

        String str3 = "brag today";
        String str4 = "grab to day";
        System.out.println(canReconstruct(str3, str4)); // true
        // as str4 can be reconstructed into str3 as the additional space is not needed

    }

    public static boolean canReconstruct(String str1, String str2) {
        HashMap<Character, Integer> str1Map = new HashMap<>();


        for (int i =0; i<str2.length(); i++){
            Character key = str2.charAt(i);
            Integer count = str1Map.containsKey(key) ? str1Map.get(key) : 0;
            str1Map.put(key, count + 1);
        }

        for (int i =0; i<str1.length(); i++){
            // Go through the ransom note and see if enough letters in str2 Map
            // if find key
            Character key = str1.charAt(i);
            Integer count = str1Map.containsKey(key) ? str1Map.get(key) : 0;
            if(count == 0) return false;
            str1Map.put(key, count - 1);
        }
        return true;
    }
}
