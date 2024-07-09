package com.demo1.view;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.demo1.firebaseConfig.DataService;
import com.demo1.navigation.Navigation;
import com.google.cloud.firestore.DocumentSnapshot;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class History {

    private final DataService dataService;

    private VBox foodLogVBox;
    private VBox workoutLogVBox;

    @SuppressWarnings("unused")
    private Navigation nav;
    private Group group;

    public History(Navigation nav) {
        this.dataService = new DataService();
        this.nav = nav;
        initialize();
    }

    public void initialize() {
        // Initialize the VBox containers
        foodLogVBox = createFoodLogVBox("Food Log History");
        foodLogVBox.setPrefWidth(700);
        foodLogVBox.setPrefHeight(1000);

        workoutLogVBox = createWorkoutLogVBox("Workout Log History");
        workoutLogVBox.setPrefWidth(700);
        workoutLogVBox.setPrefHeight(1000);

        // HBox to hold both VBoxes
        HBox mainHBox = new HBox(20); // Spacing between the VBoxes
        mainHBox.setPadding(new Insets(20));
        mainHBox.setAlignment(Pos.CENTER);
        mainHBox.getChildren().addAll(foodLogVBox, workoutLogVBox);

        // Create the "Back" button
        Button backButton = new Button("Back");
        backButton.setFont(Font.font("Arial", 18));
        backButton.setPadding(new Insets(10, 20, 10, 20)); // Padding inside the button
        // backButton.getStyleClass().add("back-button");

        // Event handler for the back button
        backButton.setOnAction(event -> {
            // Close the current stage (or navigate to another scene if needed)

        });

        group = new Group(mainHBox, backButton);

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    // Method to create VBox with log history title and line
    private VBox createFoodLogVBox(String title) {
        // Create label for the title
        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Arial", 24));

        // Create a horizontal line
        Line horizontalLine = new Line();
        horizontalLine.setStartX(0);
        horizontalLine.setEndX(300); // Length of the line
        horizontalLine.setStrokeWidth(2);
        horizontalLine.setStroke(Color.GRAY);

        // VBox to hold the label and line
        VBox logVBox = new VBox(10); // Spacing between elements
        logVBox.setPadding(new Insets(20)); // Padding around the VBox
        logVBox.setAlignment(Pos.TOP_CENTER);
        logVBox.getChildren().addAll(titleLabel, horizontalLine, loadFoodDetails());

        // Apply CSS class for rounded corners
        logVBox.getStyleClass().add("rounded-box");

        return logVBox;
    }

    private VBox createWorkoutLogVBox(String title) {
        // Create label for the title
        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Arial", 24));

        // Create a horizontal line
        Line horizontalLine = new Line();
        horizontalLine.setStartX(0);
        horizontalLine.setEndX(300); // Length of the line
        horizontalLine.setStrokeWidth(2);
        horizontalLine.setStroke(Color.GRAY);

        // VBox to hold the label and line
        VBox logVBox = new VBox(10); // Spacing between elements
        logVBox.setPadding(new Insets(20)); // Padding around the VBox
        logVBox.setAlignment(Pos.TOP_CENTER);
        logVBox.getChildren().addAll(titleLabel, horizontalLine, loadWorkoutDetails());

        // Apply CSS class for rounded corners
        logVBox.getStyleClass().add("rounded-box");

        return logVBox;
    }

    private VBox loadFoodDetails() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        try {
            vbox.getChildren().clear();
            String username = "sam"; // Replace this with actual logic to get the logged-in username
            List<DocumentSnapshot> dietDocuments = dataService.getUserDataInDescendingOrder(username, "diets",
                    "timestamp");
            for (DocumentSnapshot document : dietDocuments) {
                Map<String, Object> dietDetail = document.getData();
                String timestamp = document.getId();
                HBox dietCard = createDietCard(dietDetail, timestamp);
                vbox.getChildren().add(dietCard);
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return vbox;
    }

    private VBox loadWorkoutDetails() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        try {
            vbox.getChildren().clear();
            String username = "sam"; // Replace this with actual logic to get the logged-in username
            List<DocumentSnapshot> workoutDocuments = dataService.getUserDataInDescendingOrder(username, "workouts",
                    "timestamp");
            for (DocumentSnapshot document : workoutDocuments) {
                Map<String, Object> workoutDetail = document.getData();
                String timestamp = document.getId();
                HBox workoutCard = createWorkoutCard(workoutDetail, timestamp);
                vbox.getChildren().add(workoutCard);
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return vbox;
    }

    @SuppressWarnings("unchecked")
    private HBox createDietCard(Map<String, Object> dietDetail, String timestamp) {
        HBox card = new HBox();
        card.getStyleClass().add("card");
        card.setPadding(new Insets(10));
        card.setSpacing(10);

        VBox dietVBox = new VBox();
        dietVBox.setSpacing(5);

        if (dietDetail != null) {
            addDietDetail(dietVBox, "Breakfast: ", (Map<String, Object>) dietDetail.get("breakfast"));
            addDietDetail(dietVBox, "Lunch: ", (Map<String, Object>) dietDetail.get("lunch"));
            addDietDetail(dietVBox, "Dinner: ", (Map<String, Object>) dietDetail.get("dinner"));
        }

        // Format the timestamp
        Instant instant = Instant.parse(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        String formattedTimestamp = formatter.format(instant);

        // Create a VBox for the timestamp and align it to the bottom right
        VBox timestampVBox = new VBox();
        timestampVBox.setAlignment(Pos.BOTTOM_RIGHT);
        timestampVBox.setPadding(new Insets(10, 0, 0, 0));
        Label timestampLabel = new Label(formattedTimestamp);
        timestampLabel.getStyleClass().add("timestamp-label");
        timestampVBox.getChildren().add(timestampLabel);

        card.getChildren().addAll(dietVBox, timestampVBox);
        HBox.setHgrow(timestampVBox, Priority.ALWAYS); // Make timestampVBox grow to fill available space
        return card;
    }

    @SuppressWarnings("unchecked")
    private HBox createWorkoutCard(Map<String, Object> workoutDetail, String timestamp) {
        HBox card = new HBox();
        card.getStyleClass().add("card");
        card.setPadding(new Insets(10));
        card.setSpacing(10);

        VBox workoutVBox = new VBox();
        workoutVBox.setSpacing(5);

        if (workoutDetail != null) {
            addWorkoutDetail(workoutVBox, "Workout: ", (Map<String, Object>) workoutDetail.get("workoutData"));
        }

        // Format the timestamp
        Instant instant = Instant.parse(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
                .withZone(ZoneId.systemDefault());
        String formattedTimestamp = formatter.format(instant);

        // Create a VBox for the timestamp and align it to the bottom right
        VBox timestampVBox = new VBox();
        timestampVBox.setAlignment(Pos.BOTTOM_RIGHT);
        timestampVBox.setPadding(new Insets(10, 0, 0, 0));
        Label timestampLabel = new Label(formattedTimestamp);
        timestampLabel.getStyleClass().add("timestamp-label");
        timestampVBox.getChildren().add(timestampLabel);

        card.getChildren().addAll(workoutVBox, timestampVBox);
        HBox.setHgrow(timestampVBox, Priority.ALWAYS); // Make timestampVBox grow to fill available space
        return card;
    }

    private void addDietDetail(VBox vbox, String labelText, Map<String, Object> detail) {
        if (detail != null) {
            Label text = new Label(labelText);
            text.getStyleClass().add("card-label");
            // text.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");
            vbox.getChildren().add(text);
            for (Map.Entry<String, Object> entry : detail.entrySet()) {
                String food = entry.getKey();
                String cal = entry.getValue().toString();
                Label label = new Label(food + " : " + cal + " cal");
                label.getStyleClass().add("card-detail");
                // label.setStyle("-fx-padding: 0 0 0 20;");
                vbox.getChildren().add(label);
            }
        }
    }

    private void addWorkoutDetail(VBox vbox, String labelText, Map<String, Object> detail) {
        if (detail != null) {
            Label text = new Label(labelText);
            text.getStyleClass().add("card-label");
            // text.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");
            vbox.getChildren().add(text);
            for (Map.Entry<String, Object> entry : detail.entrySet()) {
                String exercise = entry.getKey();
                String reps = entry.getValue().toString();
                Label label = new Label(exercise + " : " + reps + " reps");
                label.getStyleClass().add("card-detail");
                // label.setStyle("-fx-padding: 0 0 0 20;");
                vbox.getChildren().add(label);
            }
        }
    }
}
