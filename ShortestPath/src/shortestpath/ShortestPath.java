package shortestpath;
/**
 *
 * @author shivabp
 */
import java.util.Arrays;
import java.util.Scanner;
public class ShortestPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Please enter the number of station in zone 2:");
        int m = in.nextInt();
        double []a = new double [m];
        System.out.println("Please enter the length of stations between zone 1 and 2:");
        for(int i= 0 ; i <m ; i++){
            a[i] = in.nextInt();             
        }
        
        System.out.println("Please enter the number of station in zone 3:");
        int n = in.nextInt();
        double []c = new double [n];
        System.out.println("Please enter the length of stations between zone 3 and 4:");
        for(int i= 0 ; i <n ; i++){
            c[i] = in.nextInt();             
        }
        
        double [][]b = new double [m][n];
        System.out.println("Please enter the length of stations between zone 2 and 3:");
        for(int i= 0 ; i < m ; i++){
            for ( int j= 0 ; j < n ; j++){
                b[i][j] = in.nextInt();
                
            }         
        } 
        
        int [] stations = ShortestPathCalculations.intermediateStations(a, b, c);
        double length = ShortestPathCalculations.length(a, b, c);
        System.out.println("The intermediate stations of the shortest path are: " + Arrays.toString(stations));
        System.out.println("The total length of the shortest path is: " + length);
        
    }   
}
