package hash_maps;

// IF YOU ARE USING HASHMAPS REMEMBER TO IMPORT!!!
import java.util.HashMap;

public class HashMapsBasics {

    public static void main(String[] args) {
        // IF YOU ARE USING HASHMAPS REMEMBER TO IMPORT them see line 4!!!

        // This is how to initialise a hashmap
        HashMap<String, Integer> map = new HashMap<>();
        // IMPORTANT: the key and value types cannot be primitives - must be Objects
        // As when getting - they could be null!! - this is not possible with primitives
        // hence HashMap<String, int> is not allowed as int is a primitive type - must be Integer!

        // to add in values
        map.put("One", 1);
        map.put("Two", 2);
        System.out.println(map);        // {One=1, Two=2}



        // to check if you have a key
        map.containsKey("Three");   // false



        // LOOPING THROUGH MAP!!
        // to loop through the map
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        // Loop gives
        // One => 1
        // Two => 2


        for (var entry : map.entrySet()) {
            // Do something here
            // e.g change all the values to 25
            entry.setValue(25);
        }
        System.out.println(map);    // {One=25, Two=25}

    }
}


