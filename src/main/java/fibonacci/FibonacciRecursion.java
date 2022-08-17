package fibonacci;

public class FibonacciRecursion {

    public static void main(String[] args) {
        // For n  = 0, 1, 2, 3, 4, 5, 6
        // Expect = 0, 1, 1, 2, 3, 5, 8
        System.out.println(fibonacciRecursion(6));  // 8

    }

    // Tips for Recursion
    // 1) Establish th Base case - here it is F(0) = 0 & F(1) = 1
    // 2) Then establish the recursive case and call it within the function!
    // Here it is the F(n) = F(n-1) + F(n-2);
    public static int fibonacciRecursion(int n){
        // Base case - for F(0) & F(1)
        if(n == 0 || n == 1) return n;

        // Recursive case for any others
        return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
    }
}
