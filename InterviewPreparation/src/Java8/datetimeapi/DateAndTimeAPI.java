package Java8.datetimeapi;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateAndTimeAPI {
    public static void main(String[] args) {
        System.out.println("Local date "+LocalDate.now());
        System.out.println("Local time "+LocalTime.now());
        System.out.println("Local datetime "+LocalDateTime.now());

        LocalDate date = LocalDate.now();
        String d = date.getDayOfMonth()+"-"+date.getMonthValue()+"-"+date.getYear();
        System.out.println("date in dd-mm-yyyy format : "+d);
        System.out.println("Current date : "+date);

        LocalDate sixMonthsFromToday = LocalDate.now().plusMonths(6);
        System.out.println("Date after 6 months from today : "+sixMonthsFromToday);
        System.out.println("Age : "+-LocalDate.from(LocalDate.of(1993,5,28))
                .compareTo(LocalDate.now()));

        LocalDate bDay = LocalDate.of(1993,5,28);

        Period p = Period.between(date,bDay);

        System.out.println("Exact age : "+p);

        System.out.println(date.isLeapYear()?"Current year is a leap year":"Current year is not a leap year");
    }
}
