package leastinteger;

/**
 *
 * @author shivabp
 */
public class Main {

    public static void main(String[] args) {
        
       // int[] elements = {5, 19, 7, -3, 20, 43, 17, -16, 10, -15, -32, 40, -7, -25, 37, -1};

        //19-element
        int[] elements = {5, 19, 7, -3, 20, 43, 17, -16, 10, -15, -32, 40, -7, -25, 37, -1, -100, 50, 66};
        int least = LeastInteger.min(elements);

        System.out.println("Lowest value element is: " + least + " \nNumber of elements:  " + elements.length);

    }

}
