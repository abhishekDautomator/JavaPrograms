package Java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIExample {
    //Java 8 introduced the new `java.time` package to tackle the shortcomings of the previous 
    // `Date` and `Calendar` classes. This API provides immutable and thread-safe objects to 
    // manage date and time.
    public static void main(String[] args) {
        // Get the current date
        LocalDate date = LocalDate.now();

        // Get the current date and time
        LocalDateTime dateTime = LocalDateTime.now();

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = dateTime.format(formatter);

        System.out.println("Current Date: " + date);
        System.out.println("Formatted Date and Time: " + formattedDateTime);

        // Explanation:
        // 1. LocalDate and LocalDateTime are immutable classes for managing date and time.
        // 2. DateTimeFormatter is used to format date/time into a readable format.
        
            // Calculate the first day of the current year
            LocalDate firstDayOfYear = LocalDate.of(date.getYear(), 1, 1);
            System.out.println("First Day of the Year: " + firstDayOfYear);
            System.out.println("And the day is: "+firstDayOfYear.getDayOfWeek());
        
            // Parse a custom date string and format it
            String dateString = "2023-02-15";
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
            LocalDate parsedDate = LocalDate.parse(dateString, inputFormatter);
            System.out.println("Parsed and Formatted Date: " + parsedDate.format(outputFormatter));
        
            // Calculate the difference between two dates in days
            LocalDate startDate = LocalDate.of(2023, 1, 1);
            LocalDate endDate = LocalDate.of(2023, 12, 31);
            long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
            System.out.println("Days between " + startDate + " and " + endDate + ": " + daysBetween);
        
            // Handle invalid date format with a try-catch block
            String invalidDateString = "15-02-2023";
            try {
                LocalDate invalidDate = LocalDate.parse(invalidDateString, inputFormatter);
                System.out.println("Parsed Date: " + invalidDate);
            } catch (Exception e) {
                System.out.println("Error parsing date: " + e.getMessage());
            }
        }
}