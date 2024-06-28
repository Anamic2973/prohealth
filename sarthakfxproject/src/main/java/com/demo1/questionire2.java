package com.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
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

public class questionire2 extends Application {

    @Override
    public void start(Stage pr) throws Exception {

        ProgressBar progressBar2 = new ProgressBar(0.5);
        progressBar2.setPrefWidth(800);
        progressBar2.setPrefHeight(0);
        progressBar2.getStyleClass().add("thin-progress-bar");
        progressBar2.setPadding(new Insets(100));
        // progressBar.setStyle("-fx-accent: lightgreen; " + "-fx-background-color:
        // transparent;" +
        // "-fx-background-insets: 0;" +
        // "-fx-border-radius: 0; " +
        // "-fx-background-radius: 20;" + "-fx-min-height: 100px;");

        Image img2 = new Image("https://img.etimg.com/photo/91740413/91740413.jpg");
        ImageView imgv2 = new ImageView(img2);
        imgv2.setFitWidth(600);
        imgv2.setFitHeight(1000);

        Label q2 = new Label("What Is Your Age?");
        q2.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        q2.setPadding(new Insets(100, 10, 50, 120));
        q2.setOpacity(0.7);

        TextField q1TextField2 = new TextField();
        q1TextField2.getStyleClass().add("rounded-text-field");
        q1TextField2.setPromptText("Enter Your Age Here");
        q1TextField2.setPadding(new Insets(10, 10, 10, 10000));
        q1TextField2.setFocusTraversable(false);
        q1TextField2.setPrefWidth(400); // Set preferred width
        q1TextField2.setPrefHeight(40);// Set preferred height
        VBox vdtext2 = new VBox(q1TextField2);
        vdtext2.setMinWidth(100);
        vdtext2.setPadding(new Insets(50, 100, 100, 100));

        Button Nextbutton = new Button("Next →");
        Nextbutton.getStyleClass().add("rounded-login-button");
        Button backbutton = new Button("← Back");
        backbutton.getStyleClass().add("rounded-login-button");

        HBox button2 = new HBox(backbutton, Nextbutton);
        button2.setMinWidth(100);
        button2.setPadding(new Insets(30, 60, 10, 570));

        VBox vb2 = new VBox(progressBar2, q2, vdtext2, button2);
        vb2.setMaxWidth(800);

        HBox hb2 = new HBox(imgv2, vb2);

        Group root2 = new Group(hb2);
        Scene scene2 = new Scene(root2);

        backbutton.setOnAction(event -> {
            // Switch back to the main scene by creating a new instance of MainScene
            questionire1 mainScene = new questionire1();
            try {
                mainScene.start(pr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // scene1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        pr.setScene(scene2);
        pr.setFullScreen(true);
        pr.setWidth(2000);
        pr.setHeight(1000);
        pr.show();

    }

}
