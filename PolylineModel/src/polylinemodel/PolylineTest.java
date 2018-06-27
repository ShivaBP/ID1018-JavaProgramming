package polylinemodel;
/**
 *
 * @author shivabp
 */
import java.io.*; // PrintWriter
import java.util.Arrays;

class PolylineTest {

    public static void main(String[] args) {

        PrintWriter out = new PrintWriter(System.out, true);

        Point[] vertices = new Point[3];
        vertices[0] = new Point("A", 3, 4);
        vertices[1] = new Point("B", 1, 2);
        vertices[2] = new Point("C", 2, 3);
        Polyline p1 = new Polyline(vertices);
        out.println(p1);

        Point[] points = p1.getVertices();
        out.println(Arrays.toString(points));

        String colour = p1.getColour();
        out.println(colour);

        int width = p1.getWidth();
        out.println(width);

        double length = p1.length();
        out.println(length);

        p1.setColour("black");
        p1.setWidth(4);
        out.println(p1);

        Point vertex1 = new Point("D", 2, 3);
        Point vertex2 = new Point("S", 5, 1);
        p1.addLast(vertex1);
        p1.addBefore(vertex2, "m");
        p1.remove("C");
        out.println(p1);
        
        System.out.println("Iteration test:");
        Polyline.PolylineIterator iterator = p1.new PolylineIterator();
        while ( iterator.hasVertex()){
            System.out.println(iterator.vertex().toString());
            iterator.advance();
        }       
    }
}
