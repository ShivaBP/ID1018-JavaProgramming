package temperature_readings;
/**
 *
 * @author shivabp
 */
import java.util.*; 
public class Temperature_Readings {
    public static void main(String[] args) {    
        System.out.println("TEMPERATURES\n");
        Scanner in = new Scanner(System.in);

        // Get user input
        System.out.print("number of weeks: ");
        int nofWeeks = in.nextInt();
        System.out.print("number of measurements per week: ");
        int nofMeasurementsPerWeek = in.nextInt();

        // store and temperatures
        double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];
        for (int week = 1; week <= nofWeeks; week++) {
            System.out.println("temperatures - week " + week + ":");
            for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++) {
                t[week][reading] = in.nextDouble();
            }
        }
        System.out.println();
        System.out.println("The temperatures:");
        for (int week = 1; week <= nofWeeks; week++) {
            for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++) {
                System.out.print(t[week][reading] + " ");
            }
            System.out.println();
        }
        System.out.println();
 
        //store , calculate and show weekly results
        double[] minT = new double[nofWeeks + 1];
        double[] maxT = new double[nofWeeks + 1];
        double[] sumT = new double[nofWeeks + 1];
        double[] avgT = new double[nofWeeks + 1];
        for (int week = 1; week <= nofWeeks; week++) {
            minT[week] = t[week][1];
            maxT[week] = t[week][1];
            sumT[week] = t[week][1];
            avgT[week] = 0.0;
            for (int reading = 2; reading <= nofMeasurementsPerWeek; reading++) {
                if (t[week][reading] < minT[week]) {
                    minT[week] = t[week][reading];
                }
                if (maxT[week] < t[week][reading]) {
                    maxT[week] = t[week][reading];
                }
                sumT[week] = sumT[week] + t[week][reading];
            }
            avgT[week] = sumT[week] / nofMeasurementsPerWeek;
        }
        System.out.println("Weekly calculations of least and greates temperature as well as the sum and average of temperatures per week:");
        System.out.println();
        for (int week = 1; week <= nofWeeks; week++) {
            System.out.println("Week " + week + ": " + "Least: " + minT[week] + "  Greatest: " + maxT[week] + "  Sum: " + sumT[week] + "  Average: " + avgT[week]);
            System.out.println();
            System.out.println();
        }
        System.out.println();

        //store , calculate and show results for the whole measurement period
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double avgTemp = 0.0;        
        for (int week=2 ; week <= nofWeeks ; week++){
            if(minT[week] < minTemp){
                minTemp = minT[week] ;
            }
            if (maxTemp < maxT[week]){
                maxTemp = maxT[week];
            } 
            sumTemp = sumTemp + sumT[week];
            avgTemp = sumTemp / nofWeeks ;
         }
        System.out.println("Caalculations of least and greates temperature as well as the sum and average of temperatures for the whole measurement period:");
        System.out.println();
        System.out.println("Least: " + minTemp + "  Greatest: " + maxTemp + "  Sum: " + sumTemp + "  Average: " + avgTemp);
        System.out.println();
        System.out.println();    
    }
}
