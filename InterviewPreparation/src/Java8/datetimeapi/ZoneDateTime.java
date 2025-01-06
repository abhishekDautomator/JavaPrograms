package Java8.datetimeapi;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTime {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

        ZoneId zoneAmerica = ZoneId.of("America/New_York");
        System.out.println("Current time in "+zoneAmerica+" zone is "+ ZonedDateTime.now(zoneAmerica));
    }
}
