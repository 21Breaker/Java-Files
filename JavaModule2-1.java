import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate {
    private int year;
    private int month; // 0-based, 0 is January
    private int day;

    // No-arg constructor that creates a MyDate object for the current date
    public MyDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    // Constructor that constructs a MyDate object with a specified elapsed time since midnight, January 1, 1970, in milliseconds
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    // Constructor that constructs a MyDate object with the specified year, month, and day
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Getter method for year
    public int getYear() {
        return year;
    }

    // Getter method for month
    public int getMonth() {
        return month;
    }

    // Getter method for day
    public int getDay() {
        return day;
    }

    // Method named setDate that sets a new date for the object using the elapsed time
    public void setDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) {
        // Create a MyDate object for the current date
        MyDate date1 = new MyDate();
        System.out.println("Current date: " + date1.getYear() + "-" + (date1.getMonth() + 1) + "-" + date1.getDay());

        // Create a MyDate object with a specified elapsed time
        MyDate date2 = new MyDate(34355555133101L);
        System.out.println("Date from elapsed time: " + date2.getYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDay());
    }
}
