package com.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
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
import javafx.stage.Stage;

public class questionire1 extends Application {

    @Override
    public void start(Stage pr) throws Exception {
        // progressbar
        ProgressBar progressBar = new ProgressBar(0.5);
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
        TextField q1TextField = new TextField();
        q1TextField.getStyleClass().add("rounded-text-field");
        q1TextField.setPromptText("Enter Your Full Name Here");
        q1TextField.setPadding(new Insets(10, 10, 10, 10000));
        q1TextField.setFocusTraversable(false);
        q1TextField.setPrefWidth(400); // Set preferred width
        q1TextField.setPrefHeight(40);// Set preferred height
        // vbox for textfield
        VBox vdtext = new VBox(q1TextField);
        vdtext.setMinWidth(100);
        vdtext.setPadding(new Insets(50, 100, 100, 100));
        // next button
        Button nextbutton = new Button("Next →");
        nextbutton.getStyleClass().add("rounded-login-button");
        VBox logvb = new VBox(nextbutton);
        logvb.setMinWidth(100);
        logvb.setPadding(new Insets(30, 100, 10, 570));
        // vbox for whole right side
        VBox vb1 = new VBox(progressBar, q1, vdtext, logvb);
        vb1.setMaxWidth(800);

        HBox hb = new HBox(imgv, vb1);

        Group root1 = new Group(hb);
        Scene scene1 = new Scene(root1);
        // onclick function for next button
        nextbutton.setOnAction(event -> {
            // Switch to the second scene by creating a new instance of SecondScene
            questionire2 secondScene = new questionire2();
            try {
                secondScene.start(pr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        pr.setScene(scene1);
        scene1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        pr.setFullScreen(true);
        pr.setWidth(2000);
        pr.setHeight(1000);
        pr.show();
    }

}
