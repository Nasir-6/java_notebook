package integers_doubles;

public class DoublesToIntegers {

    // This example shows how to convert Doubles into integers - useful when you need to give medians of an array
    // as cannot use doubles to index an array!!! Need to cast as integers
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};   // median is 25 - as median index is 1.5 (
//        int[] arr = {10, 20, 30};     // median is 20 - as median index is 1 (integer)

        double medianWithoutCastingAsDouble = (arr.length - 1) / 2;
        System.out.println(medianWithoutCastingAsDouble);   // 1.0 - It loses the 0.5 as the result is not casted into a double!

        // IMPORTANT TAKE NOTE OF THIS!!!!!!!
        // This is the proper way to capture the double result!! - OTHERWISE WILL LOSE THE DECIMAL WITHOUT EVEN KNOWING!!!!
        // CAN LEAD TO A DEADLY BUG
        // cast as a double by using - (double)
        double median = (double) (arr.length - 1) / 2; // 1.5
        System.out.println(median);


        // check if it is an integer
        if (median % 1 == 0){
            // if it's an integer then cast into an integer!! - useful for indexing arrays
            // Multiple ways of doing it
            int medianInteger = (int) median;
            System.out.println(medianInteger);
            // Can index like so
            System.out.println(arr[medianInteger]);

            // OR can just do this straight!!!!
            System.out.println(arr[(int) median]);

        } else {
            // if not then give upper and lower bound and calculate median
            int upperBound = (int) Math.ceil(median);
            int lowerBound = (int) Math.floor(median);
            int actualMedian = (arr[upperBound] + arr[lowerBound]) / 2;
            System.out.println(actualMedian);

            // OR can just do this straight!!!!
            System.out.println((arr[(int) Math.ceil(median)] + arr[(int) Math.floor(median)]) / 2);

        }
    }
}
