package com.draznin.ocp.chapter5;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.time.temporal.ChronoUnit.*;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.plus(10, MINUTES));

        LocalDate localDate = LocalDate.of(1988, Month.SEPTEMBER, 4);
        System.out.println(localDate.plus(34, YEARS).getDayOfWeek());

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Jerusalem"));
        System.out.println(zonedDateTime);

        Period period = Period.of(10, 10, 10);
        System.out.println(localDate.plus(period));

        Duration duration = Duration.of(10, HOURS);
        System.out.println(localTime.minus(duration));

        Instant instant = zonedDateTime.toInstant();
        System.out.println(zonedDateTime);
        System.out.println(instant);

        Locale locale = Locale.getDefault();
        System.out.println(locale);
        locale = new Locale("iw");
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());

        ResourceBundle resourceBundle = ResourceBundle.getBundle("Things", locale);
        System.out.println(resourceBundle.getString("hello"));

        ResourceBundle resourceBundle1 = ResourceBundle.getBundle("com.draznin.ocp.chapter5.CustomBundle", new Locale("de"));
        System.out.println(resourceBundle1.getString("hello"));




    }
}
