package microsoft;

public class Solution1185 {

    private static int LEAP_YEAR_DAYS = 366;
    private static int NON_LEAP_YEAR_DAYS = 365;

    public static String dayOfTheWeek(int day, int month, int year) {

        int days = 0;
        String[] dayOfWeek = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};

        for(int currYear = 1971; currYear < year; currYear++) {
            if(checkLeapYear(currYear)) days += LEAP_YEAR_DAYS;
            else days += NON_LEAP_YEAR_DAYS;
        }

        boolean currYearIsLeapYear = checkLeapYear(year);

        for(int currMonth = 1; currMonth < month; currMonth++) {
            if (currMonth == 2) days +=  currYearIsLeapYear ? 29 : 28;
            else if(currMonth == 4 || currMonth == 6 || currMonth == 9 || currMonth == 11) days += 30;
            else days += 31;
        }

        days += day-1;

        return dayOfWeek[days%7];

    }

    public static boolean checkLeapYear(int year) {
        if(year % 400 == 0) return true;

        if(year % 100 == 0) return false;

        if(year % 4 == 0) return true;

        return false;
    }

    public static void main(String[] args) {
        int day = 18, month = 7, year = 1999;
        System.out.println(dayOfTheWeek(day, month, year));
    }
}
