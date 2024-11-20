package lab6_7_8;//lab6_7_8.Q4.) Create a class called date that include three instance variable a) month(type int) b)day (type int) and
//c) year (type int) . provide a constructer that initialize a three instance variable and assume the value
//provided are correct. Provide a set and a get method for each instance variable.Provide a method
//DisplayDate that display the month year and day separated by forward slashand write a test application
//named DateTest that demonstrate date capabilities.

class Date{
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void displayDate(){
        System.out.println(month+"/"+year+"/"+day);
    }
}

public class Q4 {
    public static void main(String[] args) {
        Date date=new Date(10,14,2024);
        date.displayDate();
        date.setMonth(12);
        date.setDay(30);
        date.setYear(2025);
        System.out.println("Updated date: ");
        date.displayDate();
    }

}
