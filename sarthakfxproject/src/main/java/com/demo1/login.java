package com.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class login extends Application {
    public void start(Stage pr) {
        // Load the video
        String videoPath = getClass().getResource("/images/videoplayback.mp4").toExternalForm(); // Adjust the path to
                                                                                                 // your video file
        Media videoMedia = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(videoMedia);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setAutoPlay(true);

        // Set video properties
        mediaView.setFitWidth(1000);
        mediaView.setFitHeight(1000);
        mediaView.setPreserveRatio(true);

        // Play the video in a loop
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        // Login Label
        Label login = new Label("L O G I N");
        login.setFont(Font.font("Verdana", 45));

        // Divider Line
        Line line = new Line();
        line.setStartX(500);
        line.setEndX(900);

        // Copyright Label
        Label copyright = new Label("©Prohealth");
        copyright.setPadding(new Insets(190, 0, 0, 0));

        // Email Label and TextField
        Label email = new Label("Enter Email");
        email.setFont(Font.font("Poppins", 19));
        email.setOpacity(0.5);
        email.setPadding(new Insets(5));
        TextField emailTextField = new TextField();
        emailTextField.getStyleClass().add("rounded-text-field");

        VBox vbEmail = new VBox(email, emailTextField);
        vbEmail.setPadding(new Insets(100, 0, 10, 0));

        // Password Label and TextField
        Label password = new Label("Enter Password");
        password.setFont(Font.font("Poppins", 19));
        password.setOpacity(0.5);
        password.setPadding(new Insets(5));
        PasswordField psTextField = new PasswordField();
        psTextField.getStyleClass().add("rounded-text-field");

        VBox vbPassword = new VBox(password, psTextField);
        vbPassword.setPadding(new Insets(10, 0, 50, 0));

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.getStyleClass().add("rounded-loginn-button");
        loginButton.setPadding(new Insets(10, 50, 10, 50));

        // Social Media Logos
        Image social1 = new Image("/images/facebook.png");
        ImageView s1 = new ImageView(social1);
        s1.setFitHeight(25);
        s1.setFitWidth(25);
        s1.setPreserveRatio(true);

        Image social2 = new Image("/images/instagram.png");
        ImageView s2 = new ImageView(social2);
        s2.setFitHeight(25);
        s2.setFitWidth(25);
        s2.setPreserveRatio(true);

        Image social3 = new Image("/images/twitter.png");
        ImageView s3 = new ImageView(social3);
        s3.setFitHeight(25);
        s3.setFitWidth(25);
        s3.setPreserveRatio(true);

        // Add logos with spacing in an HBox
        HBox logos = new HBox(20); // 20 pixels of spacing between logos
        logos.getChildren().addAll(s1, s2, s3);
        logos.setPadding(new Insets(50, 0, 0, 0)); // Vertical gap above the icons

        // VBox layout for login components
        VBox vb = new VBox(login, line, vbEmail, vbPassword, loginButton, logos, copyright);
        vb.setPadding(new Insets(150, 150, 150, 150));

        // Combine the MediaView and VBox in an HBox
        HBox flc = new HBox(mediaView, vb);
        flc.setMinHeight(1000);
        flc.setMinWidth(1000);

        // Group and Scene setup
        Group group = new Group(flc);
        Scene scene = new Scene(group);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        loginButton.setOnAction(event -> {
            // Switch to the second scene by creating a new instance of SecondScene
            questionire1 secondScene = new questionire1();
            try {
                secondScene.start(pr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Stage setup
        pr.setTitle("ProHealth");
        pr.setScene(scene);
        pr.setResizable(false);
        pr.setWidth(2000);
        pr.setHeight(1000);
        pr.setFullScreen(true);

        pr.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
