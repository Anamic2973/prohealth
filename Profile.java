package demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Profile extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
                HBox dashbox = new HBox();
                dashbox.setPadding(new Insets(10, 10, 10, 10));
                dashbox.setMinHeight(80);
                dashbox.setStyle("-fx-background-color: NULL; ");
                dashbox.setAlignment(Pos.CENTER_LEFT);

                // Create a label for the user's name
                Label nameLabel = new Label("Prohealth");
                nameLabel.setStyle(
                                "-fx-font-size: 60px; " + // Font size
                                                "-fx-text-fill: BLACK; " + // Text color
                                                "-fx-font-weight: bold; " + // Font weight
                                                "-fx-font-family: 'poppins';" // Font family
                );
                dashbox.getChildren().add(nameLabel);

                // Create labels
                Label prof = new Label("Profile");
                prof.setStyle(
                                "-fx-font-size: 60px; " + // Font size
                                                "-fx-text-fill: BLACK; " + // Text color
                                                "-fx-font-weight: bold; " + // Font weight
                                                "-fx-font-family: 'poppins';" // Font family
                );

                Label about = new Label("About Us");
                about.setStyle(
                                "-fx-font-size: 60px; " + // Font size
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
                });

                // Change cursor to hand when hovering over labels
                prof.setStyle(prof.getStyle() + "-fx-cursor: hand;");
                about.setStyle(about.getStyle() + "-fx-cursor: hand;");

                // Create a line
                Line line = new Line(0, 0, 400, 0); // Line from (0, 0) to (400, 0)
                line.setStrokeWidth(2); // Line thickness
                line.setStyle("-fx-stroke: black;"); // Line color

                // Create left VBox with labels and line
                VBox leftPane = new VBox(prof, line, about);
                leftPane.setSpacing(30);
                leftPane.setMinWidth(600);
                leftPane.setAlignment(Pos.CENTER);
                leftPane.setStyle("-fx-background-color: white; -fx-background-radius: 45px 45px 0 0;");
                leftPane.setMinHeight(1000);

                Label headlabel = new Label("Profile ");
                headlabel.setStyle(
                                "-fx-font-size: 30px; " + // Font size
                                                "-fx-text-fill: BLACK; " + // Text color
                                                // Font weight
                                                "-fx-font-family: 'poppins';" // Font family
                );
                // Create an HBox to hold profileLabel and saveButton
                HBox rightContent1 = new HBox(headlabel);

                headlabel.setAlignment(Pos.CENTER_LEFT); // Align to the right
                // saveButton.setAlignment(Pos.CENTER_RIGHT);
                rightContent1.setAlignment(Pos.CENTER_LEFT);
                rightContent1.setSpacing(20); // Add spacing between items
                rightContent1.setPadding(new Insets(20, 20, 20, 40)); // Add padding around the HBox
                rightContent1.setStyle("-fx-background-color: lightgray;");
                rightContent1.setMaxWidth(Double.MAX_VALUE); // Allow the HBox to expand
                rightContent1.setStyle("-fx-background-color: white; -fx-background-radius: 35");

                // profile pic
                Image image = new Image("/images/user.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(200);
                imageView.setPreserveRatio(true);

                // VBox for frist name and variables
                VBox nameBox = new VBox();
                Label firstNameLabel = new Label("First Name");
                Label firstNameValue = new Label("Harsh"); // Replace with your variable
                firstNameLabel.setStyle(
                                " -fx-padding: 5;-fx-font-size: 30px;-fx-font-weight: bold;");
                firstNameValue.setStyle(
                                " -fx-background-radius: 10; -fx-padding: 5;-fx-font-size: 20px;");

                nameBox.getChildren().addAll(firstNameLabel, firstNameValue);
                // VBox for frist name and variables
                VBox lastNameBox = new VBox();
                Label lastNameLabel = new Label("Last Name");
                Label lastNameValue = new Label("Mali"); // Replace with your variable
                lastNameLabel.setStyle(
                                " -fx-padding: 5;-fx-font-size: 30px;-fx-font-weight: bold;");
                lastNameValue.setStyle(
                                " -fx-background-radius: 10; -fx-padding: 5;-fx-font-size: 20px;");

                lastNameBox.getChildren().addAll(lastNameLabel, lastNameValue);

                HBox hBox1 = new HBox(120); // spacing between elements
                hBox1.getChildren().addAll(nameBox, lastNameBox);

                // VBox for email and its variable
                VBox emailBox = new VBox();
                Label emailLabel = new Label("Email:");
                Label emailValue = new Label("example@example.com"); // Replace with your variable
                emailLabel.setStyle(
                                " -fx-padding: 5;-fx-font-size: 30px;-fx-font-weight: bold;");
                emailValue.setStyle(
                                " -fx-background-radius: 10; -fx-padding: 5;-fx-font-size: 20px;");

                emailBox.getChildren().addAll(emailLabel, emailValue);

                // VBox for phone and its variable
                VBox phoneBox = new VBox();
                Label phoneLabel = new Label("Phone:");
                Label phoneValue = new Label("123-456-7890"); // Replace with your variable
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
                Label countryLabel = new Label("Country:");
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
                hBox3.getChildren().addAll(countryBox, cityBox);
                // Create a green rectangular button labeled "Save"
                Button saveButton = new Button("Sign Out");
                saveButton.setStyle(
                                "-fx-background-color: green; " + // Background color
                                                "-fx-text-fill: white; " + // Text color
                                                "-fx-font-weight: bold; " + // Font weight
                                                "-fx-font-size: 16px; " + // Font size
                                                "-fx-padding: 10px 20px;" // Padding
                );

                // VBox containing both HBoxes
                VBox data = new VBox(20); // spacing between elements
                data.getChildren().addAll(hBox1, hBox2, hBox3, saveButton);

                // box below the save button box

                VBox rightcontentbox = new VBox(imageView, data);
                rightcontentbox.setAlignment(Pos.TOP_LEFT);
                rightcontentbox.setSpacing(130);
                rightcontentbox.setStyle("-fx-background-color: white; -fx-background-radius: 35");
                rightcontentbox.setPadding(new Insets(80, 20, 20, 80));
                rightcontentbox.setMinHeight(1000);

                // Add the rightContent to rightPane
                VBox rightPane = new VBox(rightContent1, rightcontentbox);
                rightPane.setAlignment(Pos.TOP_RIGHT); // Align to the top right
                rightPane.setMinWidth(1250); // Set minimum width
                rightPane.setMinHeight(1000); // Set minimum height
                rightPane.setSpacing(20);

                // Create HBox to hold both VBoxes
                HBox mainPane = new HBox(leftPane, rightPane);
                mainPane.setSpacing(30);
                mainPane.setAlignment(Pos.CENTER_LEFT);

                // Create VBox to hold dashbox and mainPane
                VBox main = new VBox(dashbox, mainPane);
                main.setSpacing(10);
                main.setAlignment(Pos.CENTER_LEFT);
                main.setStyle("-fx-background-color: lightgray");
                main.setPadding(new Insets(5, 10, 10, 20));

                // Create scene and set stage
                Scene scene = new Scene(main, 1200, 600);
                primaryStage.setScene(scene);
                primaryStage.setTitle("PROFILE PAGE");
                primaryStage.setFullScreen(true);
                primaryStage.setResizable(false);
                primaryStage.show();
        }

        public static void main(String[] args) {
                launch(args);
        }
}
