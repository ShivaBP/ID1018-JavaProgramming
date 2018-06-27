package planarpolyline;
/**
 *
 * @author shivabp
 */
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    public String name;
    public int x;
    public int y;
    
   public Point(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y=y;       
    }

    public Point(Point p1) {
        this.x = p1.x;
        this.y= p1.y;
        this.name=p1.name;
    }

    public String getName() {
        return name;
    }

    int getY() {
        return y;
    }

    int getX() {
       return x;
    }

    double distance(Point p2) {
     double Ycoordinate = p2.y - y;
     double Xcoordinate = p2.x - x ;
     double distance = sqrt(pow(Xcoordinate, 2)+ pow(Ycoordinate, 2));
     return distance;
    }

    void setX(int i) {
        this.x=i;
    }

    void setY(int i) {
       this.y=i;
    }
    
    public String toString(){
        return "("+ name + ", "+ x + ", " + y + ")";
    }
    
}
