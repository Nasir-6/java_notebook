package fibonacci;

public class FibonacciDPBottomUp {
    public static void main(String[] args) {

        // For n  = 0, 1, 2, 3, 4, 5, 6
        // Expect = 0, 1, 1, 2, 3, 5, 8
        System.out.println(fibonacciBottomUp(6));   // 8

    }

    // DP aims to optimise solutions by storing and using intermediate solutions (so no need to recompute) - works well with repetitive algorithms

    // Tips for solving DP problems
    // 1) First solve recursively
    // 2) Try to use Memoization - Store intermediate solutions and use them
    // Do this by spotting any patterns where results are recalculated - to cut down any unnecessary computations
    // 3) Try the Bottom Up approach - If you don't like Recursion - start from the base case and use a for loop to work up to the solution

    // For the bottom up approach to the fibonacci problem you only need to work your way from the base solution.
    // Use 3 variables - as only need to keep hold of the last 2 values to find the current value
    // nMinus2 = to hold value of F(n-2)
    // nMinus1 = to hold value of F(n-1)
    // curr = to hold actual value
    // Time Complexity O(n) as loop only runs for n amount to times
    // This is a huge improvement compared to the O(2^n) solution via recursion!
    public static int fibonacciBottomUp(int n){
        // Base case return 0 or 1
        if(n == 1 || n == 0) return n;

        int nMinus2 = 0;  // F(0)
        int nMinus1 = 1;  // F(1)
        int curr = 1;       // F(2)

        // Now loop through until n
        for (int i = 2; i < n; i++) {
            // nMinus2 is now nMinus1
            nMinus2 = nMinus1;
            // nMinus1 is now curr
            nMinus1 = curr;
            // curr is now nMinus1 + nMinus2
            curr = nMinus1 + nMinus2;
        }
        return curr;
    }
}
