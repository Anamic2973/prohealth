package com.demo1.controller;

import java.util.concurrent.ExecutionException;

import com.demo1.firebaseConfig.DataService;
import com.demo1.service.Navigation;
import com.google.cloud.firestore.DocumentSnapshot;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
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

public class Login {

    private Navigation nav;
    private Group group;
    private TextField emailTextField;
    private PasswordField psTextField;

    private DataService dataService;
    public static String key;
    public static String docUserName;

    // Login Constructor
    public Login(Navigation nav) {
        this.nav = nav;
        dataService = new DataService(); // Initialize DataService instance
        initialize();
    }

    // initialize layout and components
    private void initialize() {
        // Load the video
        String videoPath = getClass()
                .getResource("/images/videoplayback.mp4")
                .toExternalForm();
        Media videoMedia = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(videoMedia);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setAutoPlay(true);

        // Set video properties
        mediaView.setFitWidth(720);
        mediaView.setFitHeight(1280);
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
        emailTextField = new TextField();
        emailTextField.setPromptText("Enter Email");
        emailTextField.getStyleClass().add("rounded-text-field");

        VBox vbEmail = new VBox(email, emailTextField);
        vbEmail.setPadding(new Insets(100, 0, 10, 0));

        // Password Label and TextField
        Label password = new Label("Enter Password");
        password.setFont(Font.font("Poppins", 19));
        password.setOpacity(0.5);
        password.setPadding(new Insets(5));
        psTextField = new PasswordField();
        psTextField.setPromptText("Enter Password");
        psTextField.getStyleClass().add("rounded-text-field");

        VBox vbPassword = new VBox(password, psTextField);
        vbPassword.setPadding(new Insets(10, 0, 50, 0));

        // Login Button
        Button loginButton = new Button("Login");
        loginButton.getStyleClass().add("rounded-loginn-button");
        loginButton.setPadding(new Insets(10, 50, 10, 50));

        // navigate to home page (for time being navigating to que1)
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleLogin(emailTextField.getText(), psTextField.getText()); // Handle login
                emailTextField.clear(); // Clear username field
                psTextField.clear(); // Clear password field
            }
        });

        // Signup Button
        Button signupButton = new Button("SignUp");
        signupButton.getStyleClass().add("rounded-loginn-button");
        signupButton.setPadding(new Insets(10, 50, 10, 50));

        // navigate to home page (for time being navigating to que1)
        signupButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nav.navigateToSignup();
            }
        });

        // vBox for signup and login button
        VBox buttonVBox = new VBox(10, loginButton, signupButton);

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
        VBox vb = new VBox(login, line, vbEmail, vbPassword, buttonVBox, logos, copyright);
        vb.setPadding(new Insets(150, 300, 150, 0));

        // Combine the MediaView and VBox in an HBox
        HBox flc = new HBox(mediaView, vb);
        flc.setMinHeight(1000);
        flc.setMinWidth(1000);

        group = new Group(flc);
    }

    // Method to handle login action
    private void handleLogin(String username, String password) {
        try {
            // Authenticate user
            if (dataService.authenticateUser(username, password)) {
                key = username; // Store the user entered username in the static key

                // fetching actual username from doc to print success msg
                DocumentSnapshot dataObject = dataService.getData("users", key); // Get user data from Firestore
                docUserName = dataObject.getString("username"); // Fetch the username from the dataObject

                nav.navigateToDashboard();
            } else {
                System.out.println("Invalid credentials");
                key = null;
            }
        } catch (ExecutionException | InterruptedException ex) {
            // ex.printStackTrace();
            System.out.println("enter valid data");
        }
    }

    // method to get group
    public Group getGroup() {
        return group;
    }

    // get value from emailTextField
    public String getEmailTextFieldValue() {
        return emailTextField.getText();
    }

    // set value of emailTextField
    public void setEmailTextFieldValue(String value) {
        emailTextField.setText(value);
    }

    // get value from psTextField
    public String getpsTextFieldValue() {
        return psTextField.getText();
    }

    // set value of psTextField
    public void setpsTextFieldValue(String value) {
        psTextField.setText(value);
    }

}
