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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Questionire4 {

    private Navigation nav;
    private Group group;
    private TextField heightTextField;

    Qusestionire que4 = new Qusestionire();
    Qusestionire que5 = new Qusestionire();

    public Questionire4(Navigation nav) {
        this.nav = nav;
        initialize();
    }

    public void initialize() {

        ProgressBar progressBar = new ProgressBar(0.36);
        progressBar.setPrefWidth(800);
        progressBar.setPrefHeight(0);
        progressBar.getStyleClass().add("thin-progress-bar");
        progressBar.setPadding(new Insets(100, 100, 70, 100));

        Image img = new Image("https://img.etimg.com/photo/91740413/91740413.jpg");
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(600);
        imageView.setFitHeight(1000);

        // height label and textfield
        Label q4Label1 = new Label("Height (in cm)");
        q4Label1.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        q4Label1.setPadding(new Insets(40, 10, 20, 120));
        q4Label1.setOpacity(0.7);
        q4Label1.setStyle("-fx-text-fill: #EEEEEE");

        heightTextField = new TextField(que4.getHeight());
        heightTextField.getStyleClass().add("rounded-text-field");
        heightTextField.setPromptText("Height (in cm)");
        heightTextField.setPadding(new Insets(10, 10, 10, 10000));
        heightTextField.setFocusTraversable(false);
        heightTextField.setPrefWidth(400); // Set preferred width
        heightTextField.setPrefHeight(40);// Set preferred height

        VBox heightVBox = new VBox(heightTextField);
        heightVBox.setMinWidth(100);
        heightVBox.setPadding(new Insets(0, 100, 100, 100));

        Button nextButton = new Button("Next →");
        nextButton.getStyleClass().add("rounded-login-button");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Capture user input
                    String height = heightTextField.getText();

                    // Create a map to hold question data
                    Map<String, Object> data3 = new HashMap<>();
                    data3.put("Height", height);

                    // Add question data to Firestore
                    DataService.addquestiondata(Login.loggedinUserName, data3, "Height");

                    System.out.println("height " + height);
                    System.out.println("age entered successfully");

                    // Navigate to the next question
                    nav.navigateToQue5();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button backButton = new Button("← Back");
        backButton.getStyleClass().add("rounded-login-button");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                nav.navigateToQue3();
            }
        });

        HBox buttonHBox = new HBox(10, backButton, nextButton);
        buttonHBox.setMinWidth(100);
        buttonHBox.setPadding(new Insets(30, 100, 10, 530));

        VBox combimedVBox1 = new VBox(10, q4Label1, heightVBox);

        VBox combimedVBox2 = new VBox(progressBar, combimedVBox1, buttonHBox);
        combimedVBox2.setMaxWidth(800);

        HBox combinedHBox = new HBox(imageView, combimedVBox2);
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

    public TextField getHeightTextField() {
        return heightTextField;
    }

    public void setHeightTextField(TextField heightTextField) {
        this.heightTextField = heightTextField;
    }

}
