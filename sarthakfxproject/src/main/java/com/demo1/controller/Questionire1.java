package com.demo1.controller;

import com.demo1.service.Navigation;

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


public class Questionire1{

    private Navigation nav;
    private Group group;
    private TextField q1TextField;

    //Questionire1 constructor
    public Questionire1(Navigation nav){
        this.nav = nav;
        initialize();
    }

    public void initialize() {
        
        // progressbar
        ProgressBar progressBar = new ProgressBar(0.09);
        progressBar.setPrefWidth(800);
        progressBar.setPrefHeight(0);
        progressBar.getStyleClass().add("thin-progress-bar");
        progressBar.setPadding(new Insets(100));
        
        // image on leftside
        Image img = new Image("https://img.etimg.com/photo/91740413/91740413.jpg");
        ImageView imgv = new ImageView(img);
        imgv.setFitWidth(600);
        imgv.setFitHeight(1000);
        
        // question
        Label q1 = new Label("What Is Your Full Name ?");
        q1.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        q1.setPadding(new Insets(100, 10, 50, 120));
        q1.setOpacity(0.7);
        
        // textfield to enter name
        q1TextField = new TextField();
        q1TextField.setPromptText("Enter Your Full Name Here");
        q1TextField.getStyleClass().add("rounded-text-field");
        q1TextField.setPadding(new Insets(10, 10, 10, 10000));
        q1TextField.setFocusTraversable(false);
        q1TextField.setPrefWidth(400); // Set preferred width
        q1TextField.setPrefHeight(40);// Set preferred height
        
        // vbox for textfield
        VBox vdtext = new VBox(q1TextField);
        vdtext.setMinWidth(100);
        vdtext.setPadding(new Insets(50, 100, 100, 100));
        
        // next button
        Button nextButton = new Button("Next →");
        nextButton.getStyleClass().add("rounded-login-button");

        nextButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                
                nav.navigateToQue2();
            }
            
        });
        
        Button backButton = new Button("← Back");
        backButton.getStyleClass().add("rounded-login-button");

        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                nav.navigateToSignup();
            }
            
        });

        HBox buttonHBox = new HBox(10, nextButton);
        buttonHBox.setMinWidth(100);
        buttonHBox.setPadding(new Insets(30, 100, 10, 530));
        
        // vbox for whole right side
        VBox vb1 = new VBox(progressBar, q1, vdtext, buttonHBox);
        vb1.setMaxWidth(800);

        HBox hb = new HBox(imgv, vb1);

        group = new Group(hb);
    }

    //method to get group 
    public Group getGroup(){
        return group;
    }

    //get value from q1TextField
    public String getq1TextFieldValue(){
        return q1TextField.getText();
    }

    //set value of q1TextField
    public void setq1TextFieldValue(String value){
        q1TextField.setText(value);
    }

}
