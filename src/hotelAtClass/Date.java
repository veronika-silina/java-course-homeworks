package hotelAtClass;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);   //чтобы можно было проверять из другого класса, даже когда нет еще объекта
    }

    public boolean isLeapYear() {
        return isLeapYear(this.year); //из статического метода обратиться к параметрам объекта нельзя - надо создать экзепляр, а наоборот можно
    }

    private static boolean checkMonth(int month) {
        return (month >= 1) && (month <= 12);
    }

    public static int getDayPerMonth(int month, int year) {
        if (checkMonth(month)) {
            int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (isLeapYear(year) && (month == 2)) {
                return 29;
            } else {
                return days[month];
            }
        } else {
            return 0;
        }
    }

    public int daysFromNewYear() {
        int rez = 0;
        for (int i = 1; i < this.month; i++) {
            rez += getDayPerMonth(this.month, this.year);
        }
        rez += this.day;
        return rez;
    }

    public int daysToNewYear(){
        return getDaysPerYear() - this.daysFromNewYear();
    }

    public static int getDaysPerYear(int year){
        return (isLeapYear(year) ? 366 : 365);
    }

    public int getDaysPerYear(){
        return getDaysPerYear(this.year);
    }

    public int getDayPerMonth() {
        return getDayPerMonth(this.month, this.year);
    }
}