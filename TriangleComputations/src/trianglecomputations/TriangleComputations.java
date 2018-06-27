package trianglecomputations;
/**
 *
 * @author shivabp
 */
import java.util.*; 
public class TriangleComputations {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter the length of side a of the triangle:");
        double a = in.nextDouble();
        System.out.println("Please enter the length of side b of the triangle:");
        double b = in.nextDouble();
        System.out.println("Please enter the length of side c of the triangle:");
        double c = in.nextDouble();
        
        double circumradius = TriangleAndItsCircles.CircumcircleRadius(a, b, c);
        double inradius = TriangleAndItsCircles.InnercircleRadius(a, b, c);
        
        System.out.println("The area of the triangle is: " + Triangle.Heron(a, b, c));
        System.out.println();
        System.out.println("The perimeter of the triangle is: " + Triangle.Circumference(a, b, c));
        System.out.println();        
        System.out.println("The circumradius of the triangle is: " + circumradius);
        System.out.println();
        System.out.println("The inradius of the triangle is: " + inradius);        
    }   
}
