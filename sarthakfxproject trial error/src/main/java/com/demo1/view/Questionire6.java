package com.demo1.view;

import com.demo1.navigation.Navigation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Questionire6{

    private Navigation nav;
    private Group group;
    private CheckBox checkBox;

    public Questionire6(Navigation nav){
        this.nav = nav;
        initialize();
    }

    public void initialize(){

        ProgressBar progressBar = new ProgressBar(0.54);
        progressBar.setPrefWidth(800);
        progressBar.setPrefHeight(0);
        progressBar.getStyleClass().add("thin-progress-bar");
        progressBar.setPadding(new Insets(100));
        
        Image img = new Image("https://img.etimg.com/photo/91740413/91740413.jpg");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(600);
        imgView.setFitHeight(1000);

        Label q6Label = new Label("What are your primary fitness \ngoals? (Select all that apply)");
        q6Label.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        q6Label.setPadding(new Insets(10, 10, 30, 120));
        q6Label.setOpacity(0.7);

        String[] checkBoxLabels = {"Gain muscle", "Improve cardiovascular health", "Increase flexibility","Enhance overall fitness"};

        VBox checkVBox = new VBox(20);
        checkVBox.setPadding(new Insets(30, 100, 40, 110));

        for (String checkBoxLabel : checkBoxLabels) {
            CheckBox checkBox = new CheckBox(checkBoxLabel);
            checkVBox.getChildren().add(checkBox);
            checkBox.setFont(Font.font("Arial", 27));
        }

        Button nextButton = new Button("Next →");
        nextButton.getStyleClass().add("rounded-login-button");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                nav.navigateToQue7();
            }
        });

        Button backButton = new Button("← Back");
        backButton.getStyleClass().add("rounded-login-button");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event){
                    nav.navigateToQue5();
                }
        });

        HBox buttonHBox = new HBox(10,backButton, nextButton);
        buttonHBox.setMinWidth(100);
        buttonHBox.setPadding(new Insets(30, 100, 10, 530));

        VBox combinedVBox = new VBox(progressBar, q6Label, checkVBox ,buttonHBox);
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

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
