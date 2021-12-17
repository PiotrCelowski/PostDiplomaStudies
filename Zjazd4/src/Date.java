import java.time.YearMonth;
import java.util.Calendar;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Date {
    private int day;
    private int month;
    private int year;

    private Map<Integer, String> literalMonths = Stream.of(new Object[][] {
            {1,"JAN"},
            {2,"FEB"},
            {3,"MAR"},
            {4,"APR"},
            {5,"MAY"},
            {6,"JUN"},
            {7,"JUL"},
            {8,"AUG"},
            {9,"SEP"},
            {10,"OCT"},
            {11,"NOV"},
            {12,"DEC"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]);

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDate(int day, int month, int year) {
        if(isDateValid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new RuntimeException("Wrong date format provided!");
        }
    }

    public Date() {
        java.util.Date date= new java.util.Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH);
        this.year = calendar.get(Calendar.YEAR);
    }

    public Date(int day, int month, int year) {
        if(isDateValid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new RuntimeException("Wrong date format provided!");
        }

    }

    private boolean isDateValid(int day, int month, int year) {
        if(isYearValid(year) && isMonthValid(month) && isDayValid(day ,month ,year)) {
            return true;
        }
        return false;
    }

    private boolean isYearValid(int year) {
        if(year > 0) {
            return true;
        }
        return false;
    }

    private boolean isMonthValid(int month) {
        if(month > 0 && month <= 12) {
            return true;
        }
        return false;
    }

    private boolean isDayValid(int day, int month, int year) {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();

        if(day > 0 && day <= daysInMonth) {
            return true;
        }
        return false;
    }

    public String getMonthDate(int month) {
        
    }

    @Override
    public String toString() {
        return this.day + "-" + this.month + "-" + this.year;
    }

    public static void main(String[] args) {
        Date rightNow = new Date();
        System.out.println(rightNow.toString());

        Date newDate = new Date(2,1,2021);
        System.out.println(newDate.toString());
    }
}
