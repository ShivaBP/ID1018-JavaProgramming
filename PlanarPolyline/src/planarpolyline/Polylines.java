package planarpolyline;
/**
 *
 * @author shivabp
 */
public class Polylines {

    public static void shortestYellow(Polyline[] polylines) {
        Polyline yellow = polylines[0];
        Polyline shortest = polylines[0];
        double shortestLength = 900;

        System.out.println("The Yellow polylines in the given list of polylines are:");
        for (int i = 0; i < polylines.length; i++) {
            if (polylines[i].getColor() == "yellow") {
                System.out.println(polylines[i].toString());
                shortestLength = polylines[i].length();
                if (polylines[i].length() <= shortestLength) {
                    shortest = polylines[i];
                    shortestLength = polylines[i].length();
                }
            }
        }
        System.out.println("The shortest yellow polyline is:");
        System.out.println(shortest.toString());
    }
}
