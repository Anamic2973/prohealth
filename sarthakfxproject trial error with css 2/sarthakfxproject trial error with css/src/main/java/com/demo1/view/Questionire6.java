package com.demo1.view;

import java.util.HashMap;
import java.util.Map;

import com.demo1.firebaseConfig.DataService;
import com.demo1.navigation.Navigation;
import com.demo1.nestedCollection.Qusestionire;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
// import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
// import javafx.scene.control.Toggle;
// import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Questionire6 {

    private Navigation nav;
    private Group group;
    private TextField goalsfield;

    Qusestionire que6 = new Qusestionire();

    public Questionire6(Navigation nav) {
        this.nav = nav;
        initialize();
    }

    public void initialize() {

        ProgressBar progressBar = new ProgressBar(0.27);
        progressBar.setPrefWidth(800);
        progressBar.setPrefHeight(0);
        progressBar.getStyleClass().add("thin-progress-bar");
        progressBar.setPadding(new Insets(100));

        Image img = new Image("https://img.etimg.com/photo/91740413/91740413.jpg");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(600);
        imgView.setFitHeight(1000);

        Label q3Label = new Label("What is your goal?");
        q3Label.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        q3Label.setPadding(new Insets(50, 10, 30, 120));
        q3Label.setOpacity(0.7);
        q3Label.setStyle("-fx-text-fill: #EEEEEE");

        // radio buttons
        goalsfield = new TextField(que6.getWeight());
        goalsfield.getStyleClass().add("rounded-text-field");
        goalsfield.setPromptText("Weight Gain/Loss");
        goalsfield.setPadding(new Insets(10, 10, 10, 10000));
        goalsfield.setFocusTraversable(false);
        goalsfield.setPrefWidth(400); // Set preferred width
        goalsfield.setPrefHeight(40);// Set preferred height

        VBox weightVBox = new VBox(goalsfield);
        weightVBox.setMinWidth(100);
        weightVBox.setPadding(new Insets(0, 100, 100, 100));

        // Add label and radio buttons to the VBox

        Button nextButton = new Button("Next →");
        nextButton.getStyleClass().add("rounded-login-button");

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Capture user input
                    String goal = goalsfield.getText();

                    // Create a map to hold question data
                    Map<String, Object> data3 = new HashMap<>();
                    data3.put("Goal", goal);

                    // Add question data to Firestore
                    DataService.addquestiondata(Login.loggedinUserName, data3, "Goal");

                    System.out.println("Goal " + goal);
                    System.out.println("age entered successfully");

                    // Navigate to the next question
                    nav.navigateToDashboard(Login.loggedinUserName);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        Button backButton = new Button("← Back");
        backButton.getStyleClass().add("rounded-login-button");

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                nav.navigateToQue5();
            }
        });

        HBox buttonHBox = new HBox(10, backButton, nextButton);
        buttonHBox.setMinWidth(100);
        buttonHBox.setPadding(new Insets(30, 100, 10, 530));

        VBox combinedVBox = new VBox(progressBar, q3Label, weightVBox, buttonHBox);
        combinedVBox.setMaxWidth(800);

        HBox combiHBox = new HBox(imgView, combinedVBox);
        combiHBox.setStyle("-fx-background-color: #222831");
        combiHBox.setMinWidth(1500);

        group = new Group(combiHBox);

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public TextField getGoalsfield() {
        return goalsfield;
    }

    public void setGoalsfield(TextField goalsfield) {
        this.goalsfield = goalsfield;
    }

}
