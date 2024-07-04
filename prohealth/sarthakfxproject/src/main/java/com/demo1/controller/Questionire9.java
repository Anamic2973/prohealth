package com.demo1.controller;

import com.demo1.service.Navigation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Questionire9{
    
    private Navigation nav;
    private Group group;
    private RadioButton radioButton1,radioButton2;
    private TextField specifyTextField;

    public Questionire9(Navigation nav){
        this.nav = nav;
        initialize();
    }
    
    public void initialize() {

        ProgressBar progressBar = new ProgressBar(0.81);
        progressBar.setPrefWidth(800);
        progressBar.setPrefHeight(0);
        progressBar.getStyleClass().add("thin-progress-bar");
        progressBar.setPadding(new Insets(100));
        
        Image img = new Image("https://img.etimg.com/photo/91740413/91740413.jpg");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(600);
        imgView.setFitHeight(1000);

        Label q9Label = new Label("Do you follow a specific diet?\n(e.g., vegetarian, vegan, keto)");
        q9Label.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        q9Label.setPadding(new Insets(10, 10, 30, 120));
        q9Label.setOpacity(0.7);

        //radio buttons
        radioButton1 = new RadioButton("Yes");
        radioButton1.setFont(Font.font("Arial", 30));
        radioButton1.getStyleClass().add("custom-radio-button");
        
        specifyTextField = new TextField();
        specifyTextField.setPromptText("please specify");
        specifyTextField.getStyleClass().add("rounded-text-field");
        specifyTextField.setPadding(new Insets(10, 10, 10, 10000));
        specifyTextField.setFocusTraversable(false);
        specifyTextField.setPrefWidth(400); // Set preferred width
        specifyTextField.setPrefHeight(40);// Set preferred height

        radioButton2 = new RadioButton("No");   
        radioButton2.setFont(Font.font("Arial", 30));
        radioButton2.getStyleClass().add("custom-radio-button");
           
        // Create a ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        
        // label and radio buttons VBox
        VBox radioButtonVBox = new VBox(20, radioButton1, specifyTextField, radioButton2);
        radioButtonVBox.setPadding(new Insets(15, 100, 50, 115));

        Button nextButton = new Button("Next →");
        nextButton.getStyleClass().add("rounded-login-button");
        
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                nav.navigateToQue10();
            }
        });

        Button backButton = new Button("← Back");
        backButton.getStyleClass().add("rounded-login-button");
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event){
                    nav.navigateToQue8();
                }
        });

        HBox buttonHBox = new HBox(10,backButton, nextButton);
        buttonHBox.setMinWidth(100);
        buttonHBox.setPadding(new Insets(30, 100, 10, 530));

        VBox combinedVBox = new VBox(progressBar, q9Label, radioButtonVBox, buttonHBox);
        combinedVBox.setMaxWidth(800);

        HBox combiHBox = new HBox(imgView, combinedVBox);

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

    public RadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(RadioButton radioButton2) {
        this.radioButton2 = radioButton2;
    }

    public TextField getSpecifyTextField() {
        return specifyTextField;
    }

    public void setSpecifyTextField(TextField specifyTextField) {
        this.specifyTextField = specifyTextField;
    }
}
