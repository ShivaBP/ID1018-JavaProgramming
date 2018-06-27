package polylinemodel;
import java.util.Random;

/**
 *
 * @author shivabp
 */
public class SelectPolyline {

    public static final Random rand = new Random();
    public static final int NOF_POLYLINES = 10;

    public static void main(String[] args) {
        Polyline[] polylines = new Polyline[NOF_POLYLINES];

        for (int i = 0; i < NOF_POLYLINES; i++) {
            polylines[i] = randomPolyline();
            System.out.println("Polyline " + (i + 1) + ": " + polylines[i].toString() + " with length of: " + polylines[i].length()+ "\n");
        }

        Polyline shortest = polylines[0];
        int shortestindex = 0;
        for (int i = 1; i < NOF_POLYLINES; i++) {
            if (polylines[i].getColour() == "Yellow") {
                if (polylines[i].length() < shortest.length()) {
                    shortest = polylines[i];
                    shortestindex = i;
                }
            }
        }

        if (shortest != null) {
            System.out.println("The shortest yellow polyline is polyline " + shortestindex + " : " + shortest.toString() + " with length of: " + shortest.length());
            System.out.println();
        } else {
            System.out.println("There was no yellow polyline at all.");
            System.out.println();
        }
    }

// The randomPoint method returns a new Point with a name
// randomly chosen from the single letters A--Z. Coordinates are random.
    public static Point randomPoint() {
        String n = "" + (char) (65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);

        return new Point(n, x, y);
    }

// The method randomPolyline returns a random polyline, 
//with a colour either blue, red, or yellow. 
//The names of the vertices are single letters from the set A--Z.  
    public static Polyline randomPolyline() {

        Polyline polyline = new Polyline();
        int nofVertices = 2 + rand.nextInt(7);
        int nofSelectedVertices = 0;
        boolean[] selectedNames = new boolean[27];
        String[] colour = {"Blue", "Red", "Yellow"};
        int colourindex = rand.nextInt(3);
        String theColour = colour[colourindex];
        Point chosenPoint = null;
        char chosenChar = 0;

        while (nofSelectedVertices < nofVertices) {
            chosenPoint = randomPoint();
            chosenChar = (chosenPoint.getName()).charAt(0);
            int ascii = (int) chosenChar - 65;

            if (selectedNames[ascii]) {
                continue;
            }

            polyline.addLast(chosenPoint);
            selectedNames[ascii] = true;
            nofSelectedVertices++;
        }
        polyline.setColour(theColour);

        return polyline;
    }
}
