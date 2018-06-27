package shortestpath;

/**
 *
 * @author shivabp
 */
public class ShortestPathCalculations {

    public static int[] intermediateStations(double[] a, double[][] b, double[] c) {
        int[] stations = new int[2];
        double shortestPath = a[0] + b[0][0] + c[0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < c.length; j++) {
                double currentLength = a[i] + b[i][j] + c[j];
                if (shortestPath >= currentLength) {
                    shortestPath = currentLength;
                    stations[0] = i;
                    stations[1] = j;
                }
            }
        }
        return stations;
    }

    public static double length(double[] a, double[][] b, double[] c) {
        double shortestPath = a[0] + b[0][0] + c[0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < c.length; j++) {
                double currentLength = a[i] + b[i][j] + c[j];
                if (shortestPath >= currentLength) {
                    shortestPath = currentLength;
                }
            }
        }
        return shortestPath;
    }
}
