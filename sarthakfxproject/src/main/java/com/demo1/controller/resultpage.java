package com.demo1.controller;

import com.demo1.service.Navigation;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class resultpage {

    private Navigation nav;
    private Group group;
    private String calorieMode;

    public resultpage(Navigation nav, String fullName, int age, String gender, int height, int weight,
            int mealsPerDay, String calorieMode) {
        this.nav = nav;
        this.calorieMode = calorieMode;
        initialize(fullName, age, gender, height, weight, mealsPerDay);
    }

    public void initialize(String fullName, int age, String gender, int height, int weight, int mealsPerDay) {
        // Calculate BMR
        int bmr = calculateBMR(age, gender, height, weight);

        // Calculate TDEE (assuming lightly active for example)
        double tdee = bmr * 1.375; // Lightly active

        // Calculate macros
        String macros = calculateMacros((int) tdee);

        // Calculate calorie adjustment based on the selected mode
        int userWeight = weight; // Replace with actual user weight
        int calorieAdjustment = calculateCalorieAdjustment(userWeight);

        // Create labels to display results
        Label titleLabel = new Label("Your Results:");
        Label bmrLabel = new Label("Basal Metabolic Rate (BMR): " + bmr + " calories/day");
        Label tdeeLabel = new Label("Total Daily Energy Expenditure (TDEE): " + (int) tdee + " calories/day");
        Label macrosLabel = new Label("Recommended Macros: " + macros);
        Label adjustmentLabel = new Label("Calorie Adjustment: " + calorieAdjustment + " calories/day");

        // Create VBox to hold labels
        VBox vbox = new VBox(20, titleLabel, bmrLabel, tdeeLabel, macrosLabel, adjustmentLabel);
        vbox.setPadding(new Insets(50));

        // Add to group
        group = new Group(vbox);
    }

    public Group getGroup() {
        return group;
    }

    private int calculateBMR(int age, String gender, int height, int weight) {
        int bmr;
        if (gender.equalsIgnoreCase("male")) {
            bmr = (int) (10 * weight + 6.25 * height - 5 * age + 5);
        } else { // Assuming gender is female
            bmr = (int) (10 * weight + 6.25 * height - 5 * age - 161);
        }
        return bmr;
    }

    private String calculateMacros(int calories) {
        int protein = (int) (calories * 0.25 / 4); // 25% of calories from protein (4 calories per gram)
        int fat = (int) (calories * 0.25 / 9); // 25% of calories from fat (9 calories per gram)
        int carbs = (int) ((calories - (protein * 4) - (fat * 9)) / 4); // Remainder from carbs (4 calories per gram)

        return "Protein: " + protein + "g, Fat: " + fat + "g, Carbohydrates: " + carbs + "g";
    }

    private int calculateCalorieAdjustment(int userWeight) {
        if (calorieMode == null) {
            throw new IllegalStateException("Calorie mode not set.");
        }

        // Assuming a basic formula for illustration purposes
        int adjustment;
        if (calorieMode.equals("surplus")) {
            adjustment = userWeight * 15; // Example calculation for surplus
        } else if (calorieMode.equals("deficit")) {
            adjustment = userWeight * 12; // Example calculation for deficit
        } else {
            throw new IllegalArgumentException("Invalid calorie mode.");
        }

        return adjustment;
    }
}
