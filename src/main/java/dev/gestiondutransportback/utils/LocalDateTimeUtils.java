package dev.gestiondutransportback.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeUtils {
	
	private LocalDateTimeUtils() {
	}
    
    public static LocalDateTime getDateUTC(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.toLocalTime());

        ZonedDateTime ldtZoned = ldt.atZone(ZoneId.systemDefault());

        ZonedDateTime utcZoned = ldtZoned.withZoneSameInstant(ZoneId.of("UTC"));
        return utcZoned.toLocalDateTime();
    }

    public static LocalDateTime fromUTCtoZone(LocalDateTime timeUtc, String zoneDest){
       ZoneId fuseauUtc = ZoneId.of("Z");
       ZoneId fuseauDest = ZoneId.of(zoneDest);
       ZonedDateTime utcZonedTime = ZonedDateTime.of(timeUtc, fuseauUtc);
       ZonedDateTime fuseauDestZonedTime = utcZonedTime.withZoneSameInstant(fuseauDest);
       return fuseauDestZonedTime.toLocalDateTime();
    }
}