package planarpolyline;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author shivabp
 */
public class VPolyline implements Polyline {

    private int width = 1;
    private String colour = "black";
    private Point[] vertices;

    public VPolyline() {
        this.vertices = new Point[0];
    }

    public VPolyline(Point[] vertices) {
        this.vertices = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    public Point[] getVertices() {
        return vertices;
    }

    public String getColor() {
        return colour;
    }

    public int getWidth() {
        return width;
    }

    public double length() {
        double length = 0;
        for (int i = 0; i < this.vertices.length - 1; i++) {
            length = length + vertices[i].distance(vertices[i + 1]);
        }
        return length;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void add(Point vertex) {
        Point[] h = new Point[this.vertices.length + 1];
        int i = 0;
        for (i = 0; i < this.vertices.length; i++) {
            h[i] = this.vertices[i];
        }
        h[i] = new Point(vertex);
        this.vertices = h;
    }

    public void insertBefore(Point vertex, String vertexName) {
        Point[] store = new Point[vertices.length + 1];
        int index = 0;
        for (int i=0  ;  i < vertices.length  ; i++ ) {
            if (vertices[i].getName() == vertexName) {
                store[index] = vertex;
                index++;
            }
            store[index] = vertices[i];
            index++;
        }
        this.vertices = store;
    }

    public void remove(String vertexName) {
        Point[] store = new Point[vertices.length - 1];
        int index = 0;
        for (int i=0  ;  i < vertices.length  ; i++)
            if (vertices[i].getName() != vertexName){
                 store[index] = vertices[i];
                index++;
            }
        this.vertices = store;
    }

    public String toString() {
        return "{" + Arrays.toString(this.vertices) + ", " + this.colour + ", " + this.width + this.length() + "}";
    }

    public Iterator<Point> iterator() {
        return new VPolylineIterator();
    }

    public class VPolylineIterator implements Iterator<Point> {

        private int current = -1;

        public VPolylineIterator() {
            if (VPolyline.this.vertices.length > 0) {
                current = 0;
            }
        }

        public boolean hasNext() {
            return current != -1;
        }

        public Point next() throws java.util.NoSuchElementException {
            if (!this.hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Point vertex = VPolyline.this.vertices[current];
            if (current >= 0 && current < VPolyline.this.vertices.length - 1) {
                current++;
            } else {
                current = -1;
            }
            return vertex;
        }

    }

}
