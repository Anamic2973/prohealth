package com.demo1.view;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.demo1.firebaseConfig.DataService;
import com.demo1.navigation.Navigation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class Profile {

        private Navigation nav;
        private Group group;
        public String logUser = Login.loggedinUserName;
        private final DataService dataService;

        // Constructor
        public Profile(Navigation nav, String username) {
                this.nav = nav;
                this.logUser = username;
                this.dataService = new DataService();
                initialize();
        }

        private String name;
        private String Age;
        private String height;
        private String Weight;

        public void initialize() {

                try {
                        // Fetch user data from Firestore
                        Map<String, Object> namedata = DataService.getDocumentData(Login.loggedinUserName, "name"); // Replace
                        Map<String, Object> ageData = DataService.getDocumentData(Login.loggedinUserName, "age"); // Replace
                        Map<String, Object> heightData = DataService.getDocumentData(Login.loggedinUserName, "Height"); // Replace
                        Map<String, Object> weightData = DataService.getDocumentData(Login.loggedinUserName, "Weight"); // Replace

                        Age = (String) ageData.get("age");
                        height = (String) heightData.get("Height");
                        Weight = (String) weightData.get("Weight");
                        if (namedata != null) {
                                // Assuming 'username' is the key for username in Firestore document
                                name = (String) namedata.get("name"); // Update the username variable
                        }
                } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                }

                HBox dashbox = new HBox();
                dashbox.setPadding(new Insets(10, 10, 10, 10));
                dashbox.setMinHeight(80);
                dashbox.setStyle("-fx-background-color: NULL; ");
                dashbox.setAlignment(Pos.CENTER_LEFT);
                dashbox.setMaxWidth(1300);

                // Create a label for the user's name
                Label nameLabel = new Label("Prohealth");
                nameLabel.setStyle(
                                "-fx-font-size: 40px; " + // Font size
                                                "-fx-text-fill: #EEEEEE; " + // Text color
                                                "-fx-font-weight: bold; " + // Font weight
                                                "-fx-font-family: 'poppins';" // Font family
                );
                dashbox.getChildren().add(nameLabel);

                // Create labels
                Label prof = new Label("Profile");
                prof.setStyle(
                                "-fx-font-size: 30px; " + // Font size
                                                "-fx-text-fill: BLACK; " + // Text color
                                                "-fx-font-weight: bold; " + // Font weight
                                                "-fx-font-family: 'poppins';" // Font family
                );

                Label about = new Label("About Us");
                about.setStyle(
                                "-fx-font-size: 30px; " + // Font size
                                                "-fx-text-fill: BLACK; " + // Text color
                                                "-fx-font-weight: bold; " + // Font weight
                                                "-fx-font-family: 'poppins';" // Font family
                );

                // Add click event handlers
                prof.setOnMouseClicked(event -> {
                        System.out.println("Profile clicked");
                        // Add your code here to handle the Profile click
                });

                about.setOnMouseClicked(event -> {
                        System.out.println("About Us clicked");
                        // Add your code here to handle the About Us click
                        nav.navitoabout();
                });

                // Change cursor to hand when hovering over labels
                prof.setStyle(prof.getStyle() + "-fx-cursor: hand;");
                about.setStyle(about.getStyle() + "-fx-cursor: hand;");

                // Create a line
                Line line = new Line(0, 0, 200, 0); // Line from (0, 0) to (400, 0)
                line.setStrokeWidth(2); // Line thickness
                line.setStyle("-fx-stroke: black;"); // Line color

                // Create left VBox with labels and line
                VBox leftPane = new VBox(prof, line, about);
                leftPane.setSpacing(30);
                leftPane.setMinWidth(350);
                leftPane.setAlignment(Pos.CENTER);
                leftPane.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45px 45px 0 0;");
                leftPane.setMaxHeight(820);

                // Create a green rectangular button labeled "Save"

                // profile pic
                Image image = new Image("/images/user.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(150);
                imageView.setPreserveRatio(true);

                // VBox for frist name and variables
                VBox nameBox = new VBox();
                Label firstNameLabel = new Label("Name");
                Label firstNameValue = new Label(name); // Replace with your variable
                firstNameLabel.setStyle(
                                " -fx-padding: 5;-fx-font-size: 30px;-fx-font-weight: bold;");
                firstNameValue.setStyle(
                                " -fx-background-radius: 10; -fx-padding: 5;-fx-font-size: 20px;");

                nameBox.getChildren().addAll(firstNameLabel, firstNameValue);
                // VBox for frist name and variables
                VBox lastNameBox = new VBox();
                Label lastNameLabel = new Label("Age");
                Label lastNameValue = new Label(Age); // Replace with your variable
                lastNameLabel.setStyle(
                                " -fx-padding: 5;-fx-font-size: 30px;-fx-font-weight: bold;");
                lastNameValue.setStyle(
                                " -fx-background-radius: 10; -fx-padding: 5;-fx-font-size: 20px;");

                lastNameBox.getChildren().addAll(lastNameLabel, lastNameValue);

                HBox hBox1 = new HBox(130); // spacing between elements
                hBox1.getChildren().addAll(nameBox, lastNameBox);

                // VBox for email and its variable
                VBox emailBox = new VBox();
                Label emailLabel = new Label("Height");
                Label emailValue = new Label(height); // Replace with your variable
                emailLabel.setStyle(
                                " -fx-padding: 5;-fx-font-size: 30px;-fx-font-weight: bold;");
                emailValue.setStyle(
                                " -fx-background-radius: 10; -fx-padding: 5;-fx-font-size: 20px;");

                emailBox.getChildren().addAll(emailLabel, emailValue);

                // VBox for phone and its variable
                VBox phoneBox = new VBox();
                Label phoneLabel = new Label("Weight");
                Label phoneValue = new Label(Weight); // Replace with your variable
                phoneBox.getChildren().addAll(phoneLabel, phoneValue);
                phoneLabel.setStyle(
                                " -fx-padding: 5;-fx-font-size: 30px;-fx-font-weight: bold;");
                phoneValue.setStyle(
                                " -fx-background-radius: 10; -fx-padding: 5;-fx-font-size: 20px;");

                // HBox containing emailBox and phoneBox
                HBox hBox2 = new HBox(60); // spacing between elements
                hBox2.getChildren().addAll(emailBox, phoneBox);

                // VBox for country and its variable
                VBox countryBox = new VBox();
                Label countryLabel = new Label("Age");
                Label countryValue = new Label("ExampleCountry"); // Replace with your variable
                countryBox.getChildren().addAll(countryLabel, countryValue);
                countryLabel.setStyle(
                                " -fx-padding: 5;-fx-font-size: 30px;-fx-font-weight: bold;");
                countryValue.setStyle(
                                "-fx-background-radius: 10; -fx-padding: 5;-fx-font-size: 20px;");

                // VBox for city and its variable
                VBox cityBox = new VBox();
                Label cityLabel = new Label("City:");
                Label cityValue = new Label("ExampleCity"); // Replace with your variable
                cityBox.getChildren().addAll(cityLabel, cityValue);
                cityLabel.setStyle(
                                " -fx-padding: 5;-fx-font-size: 30px;-fx-font-weight: bold;");
                cityValue.setStyle(
                                "-fx-background-radius: 10; -fx-padding: 5;-fx-font-size: 20px;");

                // HBox containing countryBox and cityBox
                HBox hBox3 = new HBox(130); // spacing between elements
                hBox3.getChildren().addAll(countryBox);

                // VBox containing both HBoxes
                VBox data = new VBox(20); // spacing between elements
                data.getChildren().addAll(hBox1, hBox2);

                Button homeButton = new Button("HOME");
                homeButton.getStyleClass().add("rounded-loginn-button");
                homeButton.setOnAction(e -> {
                        nav.navigateToDashboard(Login.loggedinUserName);
                });
                Button signout = new Button("Signout");
                signout.getStyleClass().add("rounded-loginn-button");
                signout.setOnAction(e -> {
                        nav.navigatetologin();
                });

                HBox button = new HBox(homeButton, signout);
                button.setSpacing(10);

                // box below the save button box

                VBox rightcontentbox = new VBox(imageView, data, button);
                rightcontentbox.setAlignment(Pos.TOP_LEFT);
                rightcontentbox.setSpacing(30);
                rightcontentbox.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 35");
                rightcontentbox.setPadding(new Insets(80, 20, 20, 80));
                rightcontentbox.setMinHeight(800);

                // Add the rightContent to rightPane
                VBox rightPane = new VBox(rightcontentbox);
                rightPane.setAlignment(Pos.TOP_RIGHT); // Align to the top right
                rightPane.setMinWidth(1250); // Set minimum width
                rightPane.setMinHeight(850); // Set minimum height
                rightPane.setSpacing(20);

                // Create HBox to hold both VBoxes
                HBox mainPane = new HBox(leftPane, rightPane);
                mainPane.setSpacing(30);
                mainPane.setAlignment(Pos.CENTER_LEFT);

                // Create VBox to hold dashbox and mainPane
                VBox main = new VBox(dashbox, mainPane);
                main.setAlignment(Pos.TOP_LEFT);
                main.setStyle("-fx-background-color: #222831");
                main.setPadding(new Insets(5, 10, 10, 20));

                group = new Group(main);

                // Create scene and set stage
                // Scene scene = new Scene(main, 1200, 600);
                // primaryStage.setScene(scene);
                // primaryStage.setTitle("PROFILE PAGE");
                // primaryStage.setFullScreen(true);
                // primaryStage.setResizable(false);
                // primaryStage.show();
        }

        public Group getGroup() {
                return group;
        }

        public void setGroup(Group group) {
                this.group = group;
        }
}
