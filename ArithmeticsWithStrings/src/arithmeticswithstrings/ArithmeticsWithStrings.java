package arithmeticswithstrings;
/**
 *
 * @author shivabp
 */
import java.util.*; // Scanner 
import static java.lang.System.out;

public class ArithmeticsWithStrings {

    public static void main(String[] args) {
        out.println("OPERATIONS ON NATURAL NUMBERS " + "IN CHARACTER STRINGS");
        
        Scanner in = new Scanner(System.in);
        out.println("two natural numbers:");
        String tal1 = in.next();
        String tal2 = in.next();
        out.println();

        String sum = add(tal1, tal2);
        show(tal1, tal2, sum, '+');
       
        String differnce = subtract(tal1 , tal2);
        show(tal1, tal2 , differnce , '-');
    }

// The add method accepts two natural numbers represented as character strings and returns their sum as a
// character string.
    public static String add(String num1, String num2) {   
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt( num2);
        int addition = number1 + number2;
        String result= String.valueOf(addition);        
        return result;
    }

// The subtract method accepts two natural number represented as character strings and returns their
// difference as a character string.
// The first number is not smaller than the second 
    public static String subtract(String num1, String num2) {
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt( num2);
        int differnce = number1 - number2;
        String result= String.valueOf(differnce);        
        return result;
    }

// The show method presents two natural numbers, an operator and the result string.
    public static void show(String num1, String num2, String result, char operator) {

        int len1 = num1.length();
        int len2 = num2.length();
        int len = result.length();
        int maxLen = Math.max(Math.max(len1, len2), len);
        num1 = setLen(num1, maxLen - len1);
        num2 = setLen(num2, maxLen - len2);
        result = setLen(result, maxLen - len);

        out.println(" " + num1);
        out.println("" + operator + " " + num2);
        for (int i = 0; i < maxLen + 2; i++) {
            out.print("-");
        }
        out.println();
        out.println(" " + result + "\n");
    }

// The setLen method prepends the supplied number of spaces to the beginning of a string
    public static String setLen(String s, int nofSpaces) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < nofSpaces; i++) {
            sb.insert(0, " ");
        }
        return sb.toString();

    }

}
