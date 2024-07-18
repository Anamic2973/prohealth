package com.demo1.view;

import java.util.HashMap;
import java.util.Map;
// import java.util.concurrent.ExecutionException;

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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Questionire2 {

    private Navigation nav;
    private Group group;
    Qusestionire que2 = new Qusestionire();
    private TextField q2TextField;

    public Questionire2(Navigation nav) {
        this.nav = nav;
        initialize();
    }

    public void initialize() {

        ProgressBar progressBar = new ProgressBar(0.18);
        progressBar.setPrefWidth(800);
        progressBar.setPrefHeight(0);
        progressBar.getStyleClass().add("thin-progress-bar");
        progressBar.setPadding(new Insets(100));

        Image img2 = new Image("https://img.etimg.com/photo/91740413/91740413.jpg");
        ImageView imgv2 = new ImageView(img2);
        imgv2.setFitWidth(600);
        imgv2.setFitHeight(1000);

        Label q2 = new Label("What Is Your Age?");
        q2.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        q2.setPadding(new Insets(100, 10, 50, 120));
        q2.setOpacity(0.7);
        q2.setStyle("-fx-text-fill: #EEEEEE");

        TextField q2TextField = new TextField(que2.getAge());
        q2TextField.getStyleClass().add("rounded-text-field");
        q2TextField.setPromptText("Enter Your Age Here");
        q2TextField.setPadding(new Insets(10, 10, 10, 10000));
        q2TextField.setFocusTraversable(false);
        q2TextField.setPrefWidth(400); // Set preferred width
        q2TextField.setPrefHeight(40);// Set preferred height

        VBox vBox = new VBox(q2TextField);
        vBox.setMinWidth(100);
        vBox.setPadding(new Insets(50, 100, 100, 100));

        Button nextButton = new Button("Next →");
        nextButton.getStyleClass().add("rounded-login-button");

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Capture user input
                    String age = q2TextField.getText();

                    // Create a map to hold question data
                    Map<String, Object> data2 = new HashMap<>();
                    data2.put("age", age);

                    // Add question data to Firestore
                    DataService.addquestiondata(Login.loggedinUserName, data2, "age");

                    System.out.println("age: " + age);
                    System.out.println("age entered successfully");

                    // Navigate to the next question
                    nav.navigateToQue3();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button backButton = new Button("← Back");
        backButton.getStyleClass().add("rounded-login-button");

        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                nav.navigateToQue1();
            }

        });

        HBox buttonHBox = new HBox(10, backButton, nextButton);
        buttonHBox.setMinWidth(100);
        buttonHBox.setPadding(new Insets(30, 100, 10, 530));

        VBox combinedVBox = new VBox(progressBar, q2, vBox, buttonHBox);
        combinedVBox.setMaxWidth(800);

        HBox combinedHBox = new HBox(imgv2, combinedVBox);
        combinedHBox.setStyle("-fx-background-color: #222831");
        combinedHBox.setMinWidth(1500);

        group = new Group(combinedHBox);

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public TextField getQ2TextField() {
        return q2TextField;
    }

    public void setQ2TextField(TextField q2TextField) {
        this.q2TextField = q2TextField;
    }

}
