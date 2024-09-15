import daysAndDates.DaysOfWeek;

public class TestDaysOfWeek {

    public static void main(String[] args) {
        System.out.println("Days Of week: ");

        for (int i = 1; i <= 7; i++) {  // Fixed loop range
            System.out.println("Number: " + i + "\tDay Of Week: " + DaysOfWeek.DayOfWeekStr(i));
        }
    }
}

package daysAndDates;

public class DaysOfWeek {
    public static String DayOfWeekStr(int NumberOfDay) {
        String dayStr = "";
        switch (NumberOfDay) {
            case 1:
                dayStr = "Sunday";
                break;
            case 2:
                dayStr = "Monday";
                break;
            case 3:
                dayStr = "Tuesday";
                break;
            case 4:
                dayStr = "Wednesday";
                break;
            case 5:
                dayStr = "Thursday";
                break;
            case 6:
                dayStr = "Friday";  // Corrected day
                break;
            case 7:
                dayStr = "Saturday";
                break;
            default:
                dayStr = "Invalid day";  // Added default case
                break;
        }
        return dayStr;  // Added return statement
    }
}
