package ternary_operator;

public class TernaryOperator {

    public static void main(String[] args) {
        String numString = Integer.toString(-29120);

        // Ternary operator
        // Variable declaration = (condition to test) ? Value if true : Value if false;
        String revNumStr = numString.charAt(0) == '-' ? "-" : "";
    }
}
