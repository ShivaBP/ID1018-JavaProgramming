package trianglecomputations;
/**
 *
 * @author shivabp
 */
import java.lang.Math;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
public class Triangle {
    public static double Area(double base , double height){
        double area = (base * height)/2 ;
        return area;
    }
    
    public static double Circumference(double a, double b , double c){
        double circumference =  a + b + c ;
        return circumference;
    }
    
    public static double Heron(double a, double b , double c){
        double half = Triangle.Circumference(a, b, c) /2 ;
        double temp = half * (half - a)* (half -b )* (half -c);
        double area = sqrt(temp);
        return area;
    }
    
    public static double MedianOfA(double a, double b , double c){
        double temp = 2*pow(b, 2)+ 2*pow(c , 2) - pow(a,2);
        double root = sqrt(temp);
        double median = root /2 ;
        return median;
    }
    
    public static double Bisector(double sideA , double sideB, double angle){
        double angleComputation = cos(angle/2) ;
        double temp1 = 2 * sideA * sideB * angleComputation;
        double temp2 = sideA + sideB ;
        double angleBisector = temp1 / temp2 ;
        return angleBisector;
    } 
}
