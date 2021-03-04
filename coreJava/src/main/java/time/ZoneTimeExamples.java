package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

public class ZoneTimeExamples {
    public static void main(String[] args) {
        compareLocalDate();
        compareZoneDateTime();
        getAllZoneIdsAndItsOffSet();
        compareZoneDateTimeCurrent();
    }

    private static void compareLocalDate() {
        LocalDate firstDate = LocalDate.of(2021, 3, 4);
        LocalDate secondDate = LocalDate.of(2021, 2, 28);

        System.out.println("*****");
        System.out.println(firstDate + " is after " + secondDate + ": " + firstDate.isAfter(secondDate));
        System.out.println(firstDate + " is compared to " + secondDate + ": " + firstDate.compareTo(secondDate));
        System.out.println(secondDate + " is compared to " + firstDate + ": " + secondDate.compareTo(firstDate));
    }

    private static void compareZoneDateTime() {
        ZonedDateTime timeInNewYork =
                ZonedDateTime.of(2021, 3, 4, 8, 10, 0, 0, ZoneId.of("America/New_York"));
        ZonedDateTime timeInBerlin =
                ZonedDateTime.of(2021, 3, 4, 14, 20, 0, 0, ZoneId.of("Europe/Berlin"));

        System.out.println("***** compare time *****");
        System.out.println(timeInNewYork + " is after " + timeInBerlin + ": " + timeInNewYork.isAfter(timeInBerlin));
        System.out.println(timeInNewYork + " is before " + timeInBerlin + ": " + timeInNewYork.isBefore(timeInBerlin));
        System.out.println(timeInNewYork + " is equal " + timeInBerlin + ": " + timeInNewYork.isEqual(timeInBerlin));
        System.out.println(timeInNewYork + " is compared to " + timeInBerlin + ": " + timeInNewYork.compareTo(timeInBerlin));
        System.out.println(timeInBerlin + " is compared to " + timeInNewYork + ": " + timeInBerlin.compareTo(timeInNewYork));

        System.out.println("***** compare time truncated to DAYS *****");
        System.out.println(timeInNewYork + " truncated to DAYS: " + timeInNewYork.truncatedTo(DAYS));
        System.out.println(timeInBerlin + " truncated to DAYS: " + timeInBerlin.truncatedTo(DAYS));
        System.out.println(timeInNewYork + " DAYS is after " + timeInBerlin + ": " + timeInNewYork.truncatedTo(DAYS).isAfter(timeInBerlin));
        System.out.println(timeInNewYork + " DAYS is before " + timeInBerlin + ": " + timeInNewYork.truncatedTo(DAYS).isBefore(timeInBerlin));
        System.out.println(timeInNewYork + " DAYS is equal " + timeInBerlin + ": " + timeInNewYork.truncatedTo(DAYS).isEqual(timeInBerlin.truncatedTo(DAYS)));

        System.out.println("***** compare time truncated to HOURS *****");
        System.out.println(timeInNewYork + " truncated to HOURS: " + timeInNewYork.truncatedTo(HOURS));
        System.out.println(timeInBerlin + " truncated to HOURS: " + timeInBerlin.truncatedTo(HOURS));
        System.out.println(timeInNewYork + " HOURS is after " + timeInBerlin + ": " + timeInNewYork.truncatedTo(HOURS).isAfter(timeInBerlin));
        System.out.println(timeInNewYork + " HOURS is before " + timeInBerlin + ": " + timeInNewYork.truncatedTo(HOURS).isBefore(timeInBerlin));
        System.out.println(timeInNewYork + " HOURS is equal " + timeInBerlin + ": " + timeInNewYork.truncatedTo(HOURS).isEqual(timeInBerlin.truncatedTo(HOURS)));
    }

    private static void compareZoneDateTimeCurrent() {
        ZonedDateTime timeInCST = ZonedDateTime.now(ZoneId.of("America/Chicago")); // -6:00
        ZonedDateTime timeInPST = ZonedDateTime.now(ZoneId.of("America/Los_Angeles")); // -8:00
        ZonedDateTime timeInEST = ZonedDateTime.now(ZoneId.of("America/Toronto")); // -5:00
        ZonedDateTime timeInHST = ZonedDateTime.now(ZoneId.of("America/Atka")); // -10:00
        ZonedDateTime timeInMST = ZonedDateTime.now(ZoneId.of("America/Hermosillo")); // -7:00

        System.out.println("timeInCST: " + timeInCST);
        System.out.println("timeInPST: " + timeInPST);
        System.out.println("timeInEST: " + timeInEST);
        System.out.println("timeInHST: " + timeInHST);
        System.out.println("timeInMST: " + timeInMST);

        ZonedDateTime newTimeInCST = timeInCST.withHour(14).withMinute(0).truncatedTo(MINUTES);
        System.out.println("newTimeInCST: " + newTimeInCST);
        System.out.println(timeInCST + " is before " + newTimeInCST + ": " + timeInCST.isBefore(newTimeInCST));
    }

    private static void getAllZoneIdsAndItsOffSet() {
        LocalDateTime localDateTime = LocalDateTime.now();

        for (String zoneId : ZoneId.getAvailableZoneIds()) {

            ZoneId id = ZoneId.of(zoneId);
            ZonedDateTime zonedDateTime = localDateTime.atZone(id);

            // ZonedDateTime -> ZoneOffset
            ZoneOffset zoneOffset = zonedDateTime.getOffset();

            //replace Z to +00:00
            String offset = zoneOffset.getId().replaceAll("Z", "+00:00");

//            result.put(id.toString(), offset);
            System.out.println(zoneId + " offset: " + zoneOffset);
        }
    }
}
