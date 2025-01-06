import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;

public class DateDifferences {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.now();
        String formattedDate = localDate.format(dateTimeFormatter);
        System.out.println("Current time: " + formattedDate);
        
        LocalDateTime utcNow = LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println("UTC time: " + utcNow);
        LocalDateTime istNow = convertUTCToIST(utcNow);
        System.out.println("IST time: " + istNow);
    }
    
    public static LocalDateTime convertUTCToIST(LocalDateTime utcDateTime) {
        ZonedDateTime utcZonedDateTime = utcDateTime.atZone(ZoneId.of("UTC"));
        ZonedDateTime istZonedDateTime = utcZonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
        return istZonedDateTime.toLocalDateTime();
    }
}
