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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
// import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Questionire5 {
    Qusestionire que5 = new Qusestionire();
    private TextField weightTextField;
    private Navigation nav;
    private Group group;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    public Questionire5(Navigation nav) {
        this.nav = nav;
        initialize();
    }

    public void initialize() {

        ProgressBar progressBar = new ProgressBar(0.45);
        progressBar.setPrefWidth(800);
        progressBar.setPrefHeight(0);
        progressBar.getStyleClass().add("thin-progress-bar");
        progressBar.setPadding(new Insets(100));

        Image img = new Image("https://img.etimg.com/photo/91740413/91740413.jpg");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(600);
        imgView.setFitHeight(1000);

        Label q5Label = new Label("What is your weight?");
        q5Label.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        q5Label.setPadding(new Insets(10, 10, 30, 120));
        q5Label.setOpacity(0.7);
        q5Label.setStyle("-fx-text-fill: #EEEEEE");

        weightTextField = new TextField(que5.getWeight());
        weightTextField.getStyleClass().add("rounded-text-field");
        weightTextField.setPromptText("Weight (in kg)");
        weightTextField.setPadding(new Insets(10, 10, 10, 10000));
        weightTextField.setFocusTraversable(false);
        weightTextField.setPrefWidth(400); // Set preferred width
        weightTextField.setPrefHeight(40);// Set preferred height

        VBox weightVBox = new VBox(weightTextField);
        weightVBox.setMinWidth(100);
        weightVBox.setPadding(new Insets(0, 100, 100, 100));
        // label and radio buttons VBox

        Button nextButton = new Button("Next →");
        nextButton.getStyleClass().add("rounded-login-button");

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    // Capture user input
                    String weight = weightTextField.getText();

                    // Create a map to hold question data
                    Map<String, Object> data3 = new HashMap<>();
                    data3.put("Weight", weight);

                    // Add question data to Firestore
                    DataService.addquestiondata(Login.loggedinUserName, data3, "Weight");

                    System.out.println("Weight " + weight);
                    System.out.println("age entered successfully");

                    // Navigate to the next question
                    nav.navigateToQue6();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button backButton = new Button("← Back");
        backButton.getStyleClass().add("rounded-login-button");

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                nav.navigateToQue4();
            }
        });

        HBox buttonHBox = new HBox(10, backButton, nextButton);
        buttonHBox.setMinWidth(100);
        buttonHBox.setPadding(new Insets(30, 100, 10, 530));

        VBox combinedVBox = new VBox(progressBar, q5Label, weightVBox, buttonHBox);
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

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton radioButton1) {
        this.radioButton1 = radioButton1;
    }

    public TextField getWeightTextField() {
        return weightTextField;
    }

    public void setWeightTextField(TextField weightTextField) {
        this.weightTextField = weightTextField;
    }

    public RadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(RadioButton radioButton2) {
        this.radioButton2 = radioButton2;
    }

    public RadioButton getRadioButton3() {
        return radioButton3;
    }

    public void setRadioButton3(RadioButton radioButton3) {
        this.radioButton3 = radioButton3;
    }

    public RadioButton getRadioButton4() {
        return radioButton4;
    }

    public void setRadioButton4(RadioButton radioButton4) {
        this.radioButton4 = radioButton4;
    }

}
