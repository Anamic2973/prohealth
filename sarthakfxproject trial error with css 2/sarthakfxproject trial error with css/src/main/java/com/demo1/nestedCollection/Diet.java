package com.demo1.nestedCollection;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Diet {
    private String timestamp;
    private Map<String, Integer> breakfast;
    private Map<String, Integer> lunch;
    private Map<String, Integer> dinner;
    private Map<String, Integer> snacks;

    // Default constructor (required for Firestore deserialization)
    public Diet() {
    }

    // Parameterized constructor
    public Diet(Map<String, Integer> breakfast, Map<String, Integer> lunch, Map<String, Integer> dinner) {
        this.timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT); // Correct format

        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        //this.snacks = snacks;
    }

    // Getters and Setters
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Integer> getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Map<String, Integer> breakfast) {
        this.breakfast = breakfast;
    }

    public Map<String, Integer> getLunch() {
        return lunch;
    }

    public void setLunch(Map<String, Integer> lunch) {
        this.lunch = lunch;
    }

    public Map<String, Integer> getDinner() {
        return dinner;
    }

    public void setDinner(Map<String, Integer> dinner) {
        this.dinner = dinner;
    }

    public Map<String, Integer> getSnacks() {
        return snacks;
    }

    public void setSnacks(Map<String, Integer> snacks) {
        this.snacks = snacks;
    }
}
