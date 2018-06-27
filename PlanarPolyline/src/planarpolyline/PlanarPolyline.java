package planarpolyline;
import java.util.Arrays;

/**
 *
 * @author shivabp
 */
public class PlanarPolyline {

    public static void main(String[] args) {
        Polyline polyline = null;
        //polyline = new VPolyline(); 
        polyline = new NPolyline(); 

        polyline.add(new Point("A", 5, 6));
        polyline.add(new Point("B", 1, 2));
        polyline.add(new Point("C", 4, 3));
        polyline.add(new Point("D", 4, 4));
        polyline.add(new Point("E", 0, 6));
        Point[] points = polyline.getVertices();
        polyline.setColour("red");
        polyline.setWidth(4);
        System.out.println("( " + Arrays.toString(points) + " )" + ", Length: " + polyline.length() + ", Width: " + polyline.getWidth() + ", Color: " + polyline.getColor());
        System.out.println();
        System.out.println();

        polyline.insertBefore(new Point("T", 2, 2), "C");
        polyline.remove("E");
        points = polyline.getVertices();
        System.out.println("( " + Arrays.toString(points) + " )" + ", Length: " + polyline.length() + ", Width: " + polyline.getWidth() + ", Color: " + polyline.getColor());
        System.out.println();
        System.out.println();

        NPolyline one = new NPolyline();
        one.add(new Point("A", 5, 4));
        one.add(new Point("B", 2, 3));
        one.add(new Point("C", 1, 9));
        one.setColour("yellow");
        NPolyline two = new NPolyline();
        two.add(new Point("A", 5, 4));
        two.add(new Point("B", 3, 3));
        two.add(new Point("C", 9, 9));
        two.setColour("green");
        VPolyline three = new VPolyline();
        three.add(new Point("A", 5, 4));
        three.add(new Point("B", 6, 3));
        three.add(new Point("C", 1, 9));
        three.setColour("yellow");
        VPolyline four = new VPolyline();
        four.add(new Point("A", 5, 4));
        four.add(new Point("B", 3, 3));
        four.add(new Point("C", 9, 9));
        four.setColour("red");
        Polyline[] vpolyTest = {three, four};
        Polyline[] npolyTest = {one, two};
        Polyline[] vnpolyTest = {one, two, three, four};
        Polylines.shortestYellow(npolyTest);
        System.out.println();
        System.out.println();
        
        Polylines.shortestYellow(vpolyTest);
        System.out.println();
        System.out.println();
        
        Polylines.shortestYellow(vnpolyTest);
    }
}
