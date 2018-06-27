package polylinemodel;
import java.util.Arrays;

/**
 *
 * @author shivabp
 */
public class Polyline {

    private Point[] vertices;
    private String colour = "black";
    private int width = 1;

    public Polyline() {
        this.vertices = new Point[0];
    }

    public Polyline(Point[] vertices) {
        this.vertices = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    public Point[] getVertices() {
        return vertices;
    }

    public String getColour() {
        return colour;
    }

    public int getWidth() {
        return width;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double length() {
        double length = 0;
        for (int i = 0; i < this.vertices.length - 1; i++) {
            length = length + vertices[i].distance(vertices[i + 1]);
        }
        return length;
    }

    public void addLast(Point vertex) {
        Point[] h = new Point[this.vertices.length + 1];
        int i = 0;
        for (i = 0; i < this.vertices.length; i++) {
            h[i] = this.vertices[i];
        }
        h[i] = new Point(vertex);
        this.vertices = h;
    }

    public void addBefore(Point vertex, String vertexName) {
        Point[] h = new Point[this.vertices.length + 1];
        int pointer = 0;
        for (int i = 0; i < this.vertices.length; i++) {
            if (vertex.getName() == vertexName) {
                pointer = i;
            }
        }
        for (int i = 0; i < 1 + this.vertices.length; i++) {
            if (i < pointer) {
                h[i] = this.vertices[i];
            } else if (i == pointer) {
                h[i] = new Point(vertexName, vertex.getX(), vertex.getY());
            } else if (i > pointer) {
                h[i] = this.vertices[i - 1];
            }
        }
        this.vertices = h;
    }

    public void remove(String vertexName) {
        for (int i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i].name == vertexName) {
                for (int j = i + 1; j < this.vertices.length; j++) {
                    this.vertices[i] = this.vertices[j];
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Colour:" + colour);
        sb.append("   Width:" + width + "   Points: ");

        for (int i = 0; i < vertices.length; i++) {
            sb.append(" (" + vertices[i].getName() + ", " + vertices[i].getX() + ", " + vertices[i].getY() + ") ");
        }
        sb.append("}");
        return sb.toString();
    }

    public class PolylineIterator {

        private int current = -1;

        public PolylineIterator() {
            if (Polyline.this.vertices.length > 0) {
                current = 0;
            }
        }

        public boolean hasVertex() {
            return current != -1;
        }

        public Point vertex() throws java.util.NoSuchElementException {
            if (!this.hasVertex()) {
                throw new java.util.NoSuchElementException("end of iteration");
            }
            Point vertex = Polyline.this.vertices[current];
            return vertex;
        }

        public void advance() {
            if (current >= 0 && current < Polyline.this.vertices.length - 1) {
                current++;
            } else {
                current = -1;
            }
        }
    }
}
