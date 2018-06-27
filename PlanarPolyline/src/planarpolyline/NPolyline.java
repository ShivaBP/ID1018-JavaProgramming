package planarpolyline;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author shivabp
 */
public class NPolyline implements Polyline {

    private static class Node {

        public Point vertex;
        public Node nextNode;

        public Node(Point vertex) {
            this.vertex = vertex;
            nextNode = null;
        }
    }
    private Node vertices;
    private String colour = "black";
    private int width = 1; // pixels
    private int size = 0;

    public NPolyline() {
        this.vertices = null;
    }

    public NPolyline(Point[] vertices) {
        if (vertices.length > 0) {
            Node node = new Node(new Point(vertices[0]));
            this.vertices = node;
            int pos = 1;
            while (pos < vertices.length) {
                node.nextNode = new Node(new Point(vertices[pos++]));
                node = node.nextNode;
            }
        }
        this.size = size + vertices.length + 1;
    }

    public Point[] getVertices() {
        Point[] points = new Point[size];
        int index = 0;
        Node current = vertices;

        while (current != null && index < size) {
            points[index] = current.vertex;
            index++;
            current = current.nextNode;
        }
        return points;
    }

    public String getColor() {
        return colour;
    }

    public int getWidth() {
        return width;
    }

    public double length() {
        double length = 0;
        Node current = vertices;
        while (current.nextNode != null) {
            length = length + current.vertex.distance(current.nextNode.vertex);
            current = current.nextNode;
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
        Node current = vertices;
        if (vertices != null) {
            while (current.nextNode != null) {
                current = current.nextNode;
            }
            current.nextNode = new Node(vertex);
        } else {
            vertices = new Node(vertex);
        }
        this.size = size + 1;
    }

    public void insertBefore(Point vertex, String vertexName) {
        Node current = vertices;
        while (current.nextNode != null && current.nextNode.vertex.getName() != vertexName) {
            current = current.nextNode;
        }
        Node temp = current.nextNode;
        current.nextNode = new Node(vertex);
        current.nextNode.nextNode = temp;
        this.size = size + 1;
    }

    public void remove(String vertexName) {
        Node current = this.vertices;
            if (current.vertex.getName() == vertexName) {
                this.vertices = current.nextNode;
            } else {
                while (current.nextNode != null) {
                    if (current.nextNode.vertex.getName() == vertexName) {
                        current.nextNode = current.nextNode.nextNode;
                        break;
                    }
                    current = current.nextNode;
                }
            }   
        this.size = size - 1;
    }

    public String toString() {
        String output = "{[";
        Node current = vertices;
        while (current.nextNode != null) {
            output = output + current.vertex + ", ";
            current = current.nextNode;
        }
        return output + current.vertex + "], " + this.colour + ", " + this.width + this.length() + "}";
    }

    public Iterator<Point> iterator() {
        return new NPolylineIterator();
    }

    public class NPolylineIterator implements Iterator<Point> {

        private Node current;

        public NPolylineIterator() {
            if (vertices != null) {
                current = vertices;
            }
        }

        public boolean hasNext() {
            if (current.nextNode != null) {
                return true;
            }
            return false;
        }

        public Point next() throws java.util.NoSuchElementException {
            if (!this.hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return current.nextNode.vertex;
        }
    }
}
