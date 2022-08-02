package integers_doubles;

public class IntegersToStrings {

    public static void main(String[] args) {
        System.out.println(reverse32BitInteger(-1534236469));
    }

    private static int reverse32BitInteger(int num) {
        // convert into string
        String numString = Integer.toString(num);

        // reverse it
        // If negative then start reversed string with -
        String revNumStr = numString.charAt(0) == '-' ? "-" : "";


        for (int i = numString.length() - 1; i >= 0; i--) {
            if (numString.charAt(i) != '-') {
                revNumStr += numString.charAt(i);
                System.out.println(numString.charAt(i));
            }
        }
        // then convert back into an integer

        // if want to increase limit use Long.parseLong as so
        long largerResult = Long.parseLong(revNumStr);


        // use a try catch - as limit of int is from -2,147,483,648 (-2^31) to 2,147,483,647 (2^31-1).
        // They said if out of range return 0
        // So for leetcode just do this!
        System.out.println(largerResult);
        try {
            int result = Integer.parseInt(revNumStr);
            return result;
        } catch (Exception e) {
            return 0;
        }

        // all dataType limits
        // https://www.baeldung.com/java-primitives#:~:text=Also%20known%20as%20an%20integer,(231%2D1).

    }


}
