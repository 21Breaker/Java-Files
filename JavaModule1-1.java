public class Conversion {

    /** 
     * Convert from feet to meters 
     * @param foot the value in feet
     * @return the converted value in meters
     */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /** 
     * Convert from meters to feet 
     * @param meter the value in meters
     * @return the converted value in feet
     */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        System.out.println("Feet to Meters:");
        System.out.println("Feet\tMeters");
        
        // Loop to convert feet to meters for values 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d\t%.3f%n", i, footToMeter(i));
        }

        System.out.println("\nMeters to Feet:");
        System.out.println("Meters\tFeet");
        
        // Loop to convert meters to feet for values 20 to 65 in increments of 5
        for (int i = 20; i <= 65; i += 5) {
            System.out.printf("%d\t%.3f%n", i, meterToFoot(i));
        }
    }
}
