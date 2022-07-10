package com.draznin.ocp.chapter1.enumdefinition;

import java.util.EnumMap;
import java.util.EnumSet;

public class Test {

    public static void main(String[] args) {
        WeekDay[] weekDays = WeekDay.values();
        for (WeekDay day: weekDays) {
            System.out.println(day.name() + " is odd: " + day.isOddDay() + " work day: " + day.isWorkDay() + " ordinal in enum "
            + day.ordinal());
        }
        WeekDay weekDay = WeekDay.valueOf("WEDNESDAY");

        switch (weekDay) {
            case MONDAY:
                System.out.println("It's MONDAY");
                break;
            case TUESDAY:
                System.out.println("It's TUESDAY");
                break;
            case WEDNESDAY:
                System.out.println("It's WEDNESDAY");
                break;
            case THURSDAY:
                System.out.println("It's THURSDAY");
                break;
            case FRIDAY:
                System.out.println("It's FRIDAY");
                break;
            case SATURDAY:
                System.out.println("It's SATURDAY");
                break;
            case SUNDAY:
                System.out.println("It's friday");
                break;
            default:
                throw new IllegalArgumentException("Not a day!!!");
        }

        weekDay.printPlan();

        // There is enum collections with better performance with wok with enum.
        EnumMap<WeekDay, String> dayStringEnumMap = new EnumMap<>(WeekDay.class);
        EnumSet<WeekDay> days = EnumSet.of(WeekDay.MONDAY, WeekDay.WEDNESDAY);
    }
}
