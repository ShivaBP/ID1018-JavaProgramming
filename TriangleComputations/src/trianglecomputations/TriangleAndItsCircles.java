package trianglecomputations;
/**
 *
 * @author shivabp
 */
public class TriangleAndItsCircles {
    public static double CircumcircleRadius ( double a, double b , double c){
        double area = Triangle.Heron(a, b, c);
        double circumradius = (a * b *c ) / (4 * area ) ;
        return circumradius ;
    }
    
    public static double InnercircleRadius (double a , double b , double c){
        double s = Triangle.Circumference(a, b, c) / 2;
        double area  =  Triangle.Heron(a, b, c);
        double inradius = area /s ;
        return inradius ;
    }
}
