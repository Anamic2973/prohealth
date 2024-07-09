package com.demo1.view;

import com.demo1.firebaseConfig.DataService;
import com.demo1.navigation.Navigation;
import com.demo1.nestedCollection.Workout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class WorkoutLog {

    private Navigation nav;
    private Group group;
    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private CheckBox cb6;
    private CheckBox cb7;
    private ScrollPane scrollPane2;
    private Map<String, String> workoutMap; // Map to store exercises and reps

    public WorkoutLog(Navigation nav){
        this.nav = nav;
        this.workoutMap = new HashMap<>(); // Initialize the map
        initialize();
    }
    
    public void initialize() {

        ListView<String> listView = new ListView<>();
        listView.getStyleClass().add("list-viewcustomw" + "list-cellcustomw");

        // Create an ObservableList of items
        ObservableList<String> items = FXCollections.observableArrayList();

        listView.setItems(items);

        // right
        // bumbel img
        ImageView imageView = new ImageView("/images/dumbell.png");
        imageView.setFitWidth(200); // Set image width
        imageView.setFitHeight(200); // Set image height
        imageView.setPreserveRatio(true);

        // workout text
        Label wlog = new Label("Workout\nLogbook");
        wlog.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 70px;");
        wlog.setPadding(new Insets(0, 0, 0, 0));
        HBox img = new HBox(wlog, imageView);
        img.setStyle("-fx-background-color: #fffacd;");

        VBox forhbox = new VBox(img);
        forhbox.setPadding(new Insets(0, 0, 0, 0));
        forhbox.getStyleClass().add("forhbox");

        // horzontal lines
        Line horizontalline1light = new Line();
        horizontalline1light.setStartX(100);
        horizontalline1light.setEndX(500);
        horizontalline1light.setOpacity(0.1);

        // defaultworkout text
        Label DFBW = new Label("Default FullBodyWorkout");
        DFBW.setFont(Font.font("Montserrat", 30));

        CheckBox cb1 = new CheckBox(" Jumping Jacks - 30 seconds");
        cb1.getStyleClass().add("custom-checkbox");
        cb1.setStyle("-fx-font-size: 15px;");

        CheckBox cb2 = new CheckBox("Push-Ups - ×30 reps");
        cb2.getStyleClass().add("custom-checkbox");
        cb2.setStyle("-fx-font-size: 15px;");

        CheckBox cb3 = new CheckBox("Bodyweight Squats - ×30 reps");
        cb3.getStyleClass().add("custom-checkbox");
        cb3.setStyle("-fx-font-size: 15px;");

        CheckBox cb4 = new CheckBox("Lunges - ×30 reps");
        cb4.getStyleClass().add("custom-checkbox");
        cb4.setStyle("-fx-font-size: 15px;");

        CheckBox cb5 = new CheckBox("Crunches - ×30 reps");
        cb5.getStyleClass().add("custom-checkbox");
        cb5.setStyle("-fx-font-size: 15px;");

        CheckBox cb6 = new CheckBox("Standing Forward Bend - 30 seconds");
        cb6.getStyleClass().add("custom-checkbox");
        cb6.setStyle("-fx-font-size: 15px;");

        CheckBox cb7 = new CheckBox("Child's Pose - 30 seconds");
        cb7.getStyleClass().add("custom-checkbox");
        cb7.setStyle("-fx-font-size: 15px;");

        HBox d1 = new HBox(cb1);
        d1.setPrefHeight(50);
        d1.setPrefWidth(200);
        d1.getStyleClass().add("defaultworkoutVBox");
        d1.setStyle("-fx-background-color: #ffdead;");

        HBox d2 = new HBox(cb2);
        d2.setPrefHeight(50);
        d2.setPrefWidth(200);
        d2.getStyleClass().add("defaultworkoutVBox");
        d2.setStyle("-fx-background-color: #ffdead;");

        HBox d3 = new HBox(cb3);
        d3.setPrefHeight(50);
        d3.setPrefWidth(200);
        d3.getStyleClass().add("defaultworkoutVBox");
        d3.setStyle("-fx-background-color: #ffdead;");

        HBox d4 = new HBox(cb4);
        d4.setPrefHeight(50);
        d4.setPrefWidth(200);
        d4.getStyleClass().add("defaultworkoutVBox");
        d4.setStyle("-fx-background-color: #ffdead;");

        HBox d5 = new HBox(cb5);
        d5.setPrefHeight(50);
        d5.setPrefWidth(200);
        d5.getStyleClass().add("defaultworkoutVBox");
        d5.setStyle("-fx-background-color: #ffdead;");

        HBox d6 = new HBox(cb6);
        d6.setPrefHeight(50);
        d6.setPrefWidth(200);
        d6.getStyleClass().add("defaultworkoutVBox");
        d6.setStyle("-fx-background-color: #ffdead;");

        HBox d7 = new HBox(cb7);
        d7.setPrefHeight(50);
        d7.setPrefWidth(200);
        d7.getStyleClass().add("defaultworkoutVBox");
        d7.setStyle("-fx-background-color: #ffdead;");

        Button submitButton = new Button("Submit Log");
        submitButton.setFont(Font.font("Montserrat", 20));
        submitButton.setPadding(new Insets(10, 20, 10, 20));
        submitButton.getStyleClass().add("rounded-defaultworkout-button");
        HBox subhBox = new HBox(submitButton);
        subhBox.setPadding(new Insets(0, 0, 0, 250));

        // main defaultworkoutvbox
        VBox defaultworkoutVBox = new VBox(DFBW, horizontalline1light, d1, d2, d3, d4, d5, d6, d7,
                subhBox);
        defaultworkoutVBox.setPrefHeight(630);
        defaultworkoutVBox.setPrefWidth(300);
        defaultworkoutVBox.setStyle("-fx-background-color: #fffacd;");
        defaultworkoutVBox.getStyleClass().add("defaultworkoutVBox");
        defaultworkoutVBox.setPadding(new Insets(0, 0, 0, 20));
        defaultworkoutVBox.setSpacing(10);

        // rightvbox
        VBox righvBox = new VBox(defaultworkoutVBox);      //BEFORE :  Forhbox,defaultworkoutVBox
        righvBox.setPrefHeight(1000);
        righvBox.setPrefWidth(550);
        righvBox.setStyle("-fx-background-color: #ffdead;" + "-fx-background-radius: 20px;");
        righvBox.setPadding(new Insets(10, 30, 0, 10));
        righvBox.setSpacing(10);

        // left
        Label customwLabel = new Label("Custom Workout");
        customwLabel.setFont(Font.font("Montserrat", 30));

        Line horizontalline2light = new Line();
        horizontalline2light.setStartX(100);
        horizontalline2light.setEndX(900);
        horizontalline2light.setOpacity(0.1);

        TextField workField = new TextField();
        workField.setPromptText("Enter Workout");
        workField.getStyleClass().add("rounded-text-field");

        TextField setsField = new TextField();
        setsField.setPromptText("Enter sets");
        setsField.getStyleClass().add("rounded-text-field");

        TextField repField = new TextField();
        repField.setPromptText("Enter Reps");
        repField.getStyleClass().add("rounded-text-field");

        Button Addbutton = new Button("Add");
        Addbutton.setFont(Font.font("Montserrat", 20));
        Addbutton.setPadding(new Insets(10, 0, 10, 0));
        Addbutton.getStyleClass().add("rounded-customworkout-button");

        Button removebutton = new Button("Remove");
        removebutton.setFont(Font.font("Montserrat", 20));
        removebutton.setPadding(new Insets(10, 0, 10, 0));
        removebutton.getStyleClass().add("rounded-customworkout-button");
        // HBox Abo = new HBox(Addbutton);
        // subhBox.setPadding(new Insets(0, 0, 0, 250));

        HBox customwHBox = new HBox(workField, setsField, repField, Addbutton, removebutton);
        customwHBox.setSpacing(5);

        VBox list = new VBox(listView);
        listView.setPrefHeight(700);
        listView.setPrefWidth(380);

        ScrollPane scrollPane2 = new ScrollPane(list);
        scrollPane2.setPrefHeight(700);
        scrollPane2.setPrefWidth(380);
        scrollPane2.setFitToWidth(true);
        scrollPane2.getStyleClass().add("scroll-panecustomw");

        VBox scrollVBox = new VBox(scrollPane2);
        scrollVBox.setPrefHeight(720);
        scrollVBox.setPrefWidth(400);
        scrollVBox.setStyle(" -fx-background-color:#072138;" + "-fx-background-radius: 20px;");

        VBox customworkoutVBox = new VBox(customwLabel, customwHBox, horizontalline2light, scrollVBox);
        customworkoutVBox.setPrefHeight(760);
        customworkoutVBox.setPrefWidth(500);
        customworkoutVBox.setStyle(" -fx-background-color:#b5d7f5;" + "-fx-background-radius: 20px;");
        customworkoutVBox.setPadding(new Insets(20, 20, 20, 20));
        customworkoutVBox.setSpacing(10);

        Button submit = new Button("Submit");
        submit.setFont(Font.font("Montserrat", 20));
        submit.setPadding(new Insets(10, 0, 10, 0));
        submit.getStyleClass().add("rounded-customworkout-button");

        Button back = new Button("Back");
        back.setFont(Font.font("Montserrat", 20));
        back.setPadding(new Insets(10, 0, 10, 0));
        back.getStyleClass().add("rounded-customworkout-button");

        back.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                nav.navigateToDashboard();
            }
            
        });

        HBox bottom = new HBox(back, submit);
        bottom.setSpacing(500);
        // leftvbox
        VBox leftVBox = new VBox(customworkoutVBox, bottom);
        leftVBox.setPrefHeight(100);
        leftVBox.setPrefWidth(900);
        leftVBox.setStyle("-fx-background-color:White;");
        leftVBox.setPadding(new Insets(20, 20, 20, 20));
        leftVBox.setSpacing(20);

        // mainhbox
        HBox mainhBox = new HBox(leftVBox, righvBox);
        mainhBox.setPrefHeight(1000);
        mainhBox.setPrefWidth(1500);
        // mainhBox.setStyle("-fx-background-color: #fffacd;");

        Addbutton.setOnAction(event -> {
            String workout = workField.getText();
            String sets = setsField.getText();
            String reps = repField.getText();

            if (!workout.isEmpty() && !sets.isEmpty() && !reps.isEmpty()) {
                String formattedWorkout = workout + " (" + sets + " x " + reps + ")";
                items.add(formattedWorkout);
                workoutMap.put(workout, sets + " x " + reps); // Store in the map
                System.out.println(items);

                // Clear input fields after adding
                workField.clear();
                setsField.clear();
                repField.clear();
            }
        });

        removebutton.setOnAction(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                items.remove(selectedItem);
                // Remove from map
                String workout = selectedItem.split(" \\(")[0];
                workoutMap.remove(workout);
            }
        });

        submitButton.setOnAction(event -> {
            // Print map content
            System.out.println("Workout Log:");
            for (Map.Entry<String, String> entry : workoutMap.entrySet()) {
                System.out.println("Exercise: " + entry.getKey() + ", Reps: " + entry.getValue());
            }
            Workout workoutData = new Workout(workoutMap);
            workoutData.setTimestamp("2021-08-01T08:00:00Z");   //hardcoded timestamp
            try {
                DataService.addWorkout("sam", workoutData);     //hardcoreded username
            } catch (ExecutionException e) {
                
                e.printStackTrace();
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }  
            
        });

        group = new Group(mainhBox);

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public CheckBox getCb1() {
        return cb1;
    }

    public void setCb1(CheckBox cb1) {
        this.cb1 = cb1;
    }

    public CheckBox getCb2() {
        return cb2;
    }

    public void setCb2(CheckBox cb2) {
        this.cb2 = cb2;
    }

    public CheckBox getCb3() {
        return cb3;
    }

    public void setCb3(CheckBox cb3) {
        this.cb3 = cb3;
    }

    public CheckBox getCb4() {
        return cb4;
    }

    public void setCb4(CheckBox cb4) {
        this.cb4 = cb4;
    }

    public CheckBox getCb5() {
        return cb5;
    }

    public void setCb5(CheckBox cb5) {
        this.cb5 = cb5;
    }

    public CheckBox getCb6() {
        return cb6;
    }

    public void setCb6(CheckBox cb6) {
        this.cb6 = cb6;
    }

    public CheckBox getCb7() {
        return cb7;
    }

    public void setCb7(CheckBox cb7) {
        this.cb7 = cb7;
    }

    public ScrollPane getScrollPane2() {
        return scrollPane2;
    }

    public void setScrollPane2(ScrollPane scrollPane2) {
        this.scrollPane2 = scrollPane2;
    }

}
