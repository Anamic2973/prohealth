package com.demo1.view;

import com.demo1.navigation.Navigation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class About {

    private Navigation nav;
    private Group group;

    public About(Navigation nav) {
        this.nav = nav;
        initialize();
    }

    public void initialize() {
        HBox dashbox = new HBox();
        dashbox.setPadding(new Insets(10, 10, 10, 10));
        dashbox.setMinHeight(80);
        dashbox.setStyle("-fx-background-color: NULL; ");
        dashbox.setAlignment(Pos.CENTER_LEFT);

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
                "-fx-font-size: 40px; " + // Font size
                        "-fx-text-fill: BLACK; " + // Text color
                        "-fx-font-weight: bold; " + // Font weight
                        "-fx-font-family: 'poppins';" // Font family
        );

        Label about = new Label("About Us");
        about.setStyle(
                "-fx-font-size: 40px; " + // Font size
                        "-fx-text-fill: BLACK; " + // Text color
                        "-fx-font-weight: bold; " + // Font weight
                        "-fx-font-family: 'poppins';" // Font family
        );

        // Add click event handlers
        prof.setOnMouseClicked(event -> {
            System.out.println("Profile clicked");
            // Add your code here to handle the Profile click
            nav.navigateToProfile(Login.loggedinUserName);
        });

        about.setOnMouseClicked(event -> {
            System.out.println("About Us clicked");
            // Add your code here to handle the About Us click
        });

        // Change cursor to hand when hovering over labels
        prof.setStyle(prof.getStyle() + "-fx-cursor: hand;");
        about.setStyle(about.getStyle() + "-fx-cursor: hand;");

        // Create a line
        Line line = new Line(0, 0, 250, 0); // Line from (0, 0) to (400, 0)
        line.setStrokeWidth(2); // Line thickness
        line.setStyle("-fx-stroke: black;"); // Line color

        // Create left VBox with labels and line
        VBox leftPane = new VBox(prof, line, about);
        leftPane.setSpacing(30);
        leftPane.setMinWidth(350);
        leftPane.setAlignment(Pos.CENTER);
        leftPane.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45px 45px 0 0;");
        leftPane.setMinHeight(820);

        Label headlabel = new Label("About Us ");
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
        Image bgimage = new Image("/images/about.jpg");
        ImageView imageView = new ImageView(bgimage);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);

        VBox rightcontentbox = new VBox(imageView);
        rightcontentbox.setAlignment(Pos.CENTER);
        rightcontentbox.setSpacing(30);
        rightcontentbox.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 35");
        rightcontentbox.setPadding(new Insets(80, 20, 20, 80));
        rightcontentbox.setMinHeight(800);
        rightcontentbox.setMinWidth(350);

        // Add the rightContent to rightPane
        VBox rightPane = new VBox(rightcontentbox);
        rightPane.setAlignment(Pos.TOP_RIGHT); // Align to the top right
        rightPane.setMinWidth(1050); // Set minimum width
        rightPane.setMinHeight(800); // Set minimum height
        rightPane.setSpacing(20);

        // Create HBox to hold both VBoxes
        HBox mainPane = new HBox(leftPane, rightPane);
        mainPane.setSpacing(30);
        mainPane.setAlignment(Pos.CENTER_LEFT);

        // Create VBox to hold dashbox and mainPane
        VBox main = new VBox(dashbox, mainPane);
        main.setSpacing(10);
        main.setAlignment(Pos.CENTER_LEFT);
        main.setStyle("-fx-background-color: #222831");
        main.setPadding(new Insets(5, 10, 10, 20));

        // Create scene and set stage
        group = new Group(main);

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
