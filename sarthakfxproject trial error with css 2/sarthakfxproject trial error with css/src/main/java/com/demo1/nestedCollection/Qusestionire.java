package com.demo1.nestedCollection;

// import java.time.ZonedDateTime;
// import java.time.format.DateTimeFormatter;
import java.util.Map;

import javafx.scene.control.Toggle;

public class Qusestionire {
    private String name;
    private String age;
    private String gender;
    private String height;
    private String weight;
    private String meals;
    private Toggle goals;
    private Map<String, String> Questioniredata;

    public Qusestionire() {

    }

    public Qusestionire(Map<String, String> questioniredata) {
        Questioniredata = questioniredata;
    }

    public Map<String, String> getQuestioniredata() {
        return Questioniredata;
    }

    public void setQuestioniredata(Map<String, String> questioniredata) {
        Questioniredata = questioniredata;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public Toggle getGoals() {
        return goals;
    }

    public void setGoals(Toggle goals) {
        this.goals = goals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
