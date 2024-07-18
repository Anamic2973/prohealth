package com.demo1.view;

import com.demo1.navigation.Navigation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
// import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Recipies {
    private Navigation nav;
    private Group group;

    public Recipies(Navigation nav) {
        this.nav = nav;
        intialize();
    }

    public void intialize() {

        HBox dashbox = new HBox();
        dashbox.setPadding(new Insets(10, 10, 10, 10));
        dashbox.setMinHeight(50);
        dashbox.setStyle("-fx-background-color: NULL; ");
        dashbox.setAlignment(Pos.CENTER_LEFT);

        // Create a label for the user's name
        Label nameLabel = new Label("  Prohealth");
        nameLabel.setStyle(
                "-fx-font-size: 40px; " + // Font size
                        "-fx-text-fill: white; " + // Text color
                        "-fx-font-weight: bold; " + // Font weight
                        "-fx-font-family: 'poppins';" // Font family
        );

        Button backButton = new Button("Home");
        backButton.setFont(Font.font("Arial", 18));
        backButton.setPadding(new Insets(10, 20, 10, 20)); // Padding inside the button
        backButton.getStyleClass().add("rounded-loginn-button");

        // Event handler for the back button
        backButton.setOnAction(event -> {
            // Close the current stage (or navigate to another scene if needed)
            nav.navigateToDashboard(Login.loggedinUserName);

        });
        dashbox.getChildren().addAll(nameLabel, backButton);
        dashbox.setSpacing(1000);

        // Left side VBox
        VBox leftColumn = new VBox(35);
        leftColumn.setPadding(new Insets(20));
        leftColumn.setAlignment(Pos.CENTER);
        leftColumn.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45");
        leftColumn.setMinWidth(280);
        leftColumn.setMinHeight(700);

        // Title
        Label title = new Label("   FOOD\nMACROS");
        title.setStyle("-fx-font-size: 35px; -fx-font-weight: bold;");
        title.setAlignment(Pos.CENTER);

        // Image placeholder
        ImageView imageView = new ImageView(new Image(getClass().getResource("/images/recipie.png").toExternalForm())); // Replace
                                                                                                                        // with
                                                                                                                        // actual
                                                                                                                        // image
        imageView.setFitWidth(180);
        imageView.setFitHeight(180);

        // line
        Line line = new Line(0, 0, 200, 0); // Line from (0, 0) to (400, 0)
        line.setStrokeWidth(2); // Line thickness
        line.setStyle("-fx-stroke: black;"); // Line color
        // Description
        Label description = new Label("   Eat Good,\nStay Healthy");

        description.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        leftColumn.getChildren().addAll(title, line, imageView, description);

        // Row title
        Label rowTitle1 = new Label("Home-Food");
        rowTitle1.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");

        // Create boxes with images and labels
        VBox Abox1 = createBox("/images/chapati.jpg", "Cals: 70-100\nper unit");
        VBox Abox2 = createBox("/images/dal.jpg", "Cals: 200\nper 100gm");
        VBox Abox3 = createBox("/images/papad.jpeg", "Cals: 120\nper 100gm");
        VBox Abox4 = createBox("/images/rice.jpg", "Cals: 130\nper 100gm");
        VBox Abox5 = createBox("/images/sabji.jpeg", "Cals: 300\nper 100gm");
        VBox Abox6 = createBox("/images/chutney.jpeg", "Cals: 50\nper 100gm");
        VBox Abox7 = createBox("/images/raita.jpeg", "Cals: 70-100\nper 100gm");

        HBox row1 = new HBox(Abox1, Abox2, Abox3, Abox4, Abox5, Abox6, Abox7);
        HBox.setHgrow(Abox1, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Abox2, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Abox3, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Abox4, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Abox5, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Abox6, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Abox7, Priority.ALWAYS); // Set Hgrow for individual boxes
        row1.setMinHeight(180);
        row1.setMinWidth(800);
        row1.setSpacing(25);

        VBox first = new VBox(rowTitle1, row1);
        first.setPadding(new Insets(10, 30, 30, 30));
        first.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45");
        first.setSpacing(10);

        // Row title
        Label rowTitle2 = new Label("High-Protein Veg (per 100gm)");
        rowTitle2.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create boxes with images and labels
        VBox Bbox1 = createBox("/images/v1.jpeg", "Cals: 230\nProt: 18");
        VBox Bbox2 = createBox("/images/v2.jpeg", "Cals: 165\nProt: 8");
        VBox Bbox3 = createBox("/images/v3.jpeg", "Cals: 160\nProt: 16");
        VBox Bbox4 = createBox("/images/v4.jpeg", "Cals: 222\nProt: 8");
        VBox Bbox5 = createBox("/images/v5.jpeg", "Cals: 215\nProt: 16");
        VBox Bbox6 = createBox("/images/v6.jpeg", "Cals: 269\nProt: 14.5");
        VBox Bbox7 = createBox("/images/v7.jpeg", "Cals: 291\nProt: 29");

        HBox row2 = new HBox(Bbox1, Bbox2, Bbox3, Bbox4, Bbox5, Bbox6, Bbox7);
        HBox.setHgrow(Bbox1, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Bbox2, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Bbox3, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Bbox4, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Bbox5, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Bbox6, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Bbox7, Priority.ALWAYS); // Set Hgrow for individual boxes
        row2.setMinHeight(180);
        row2.setSpacing(25);

        VBox second = new VBox(rowTitle2, row2);
        second.setPadding(new Insets(10, 30, 30, 30));
        second.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45");
        second.setSpacing(10);

        // Row title
        Label rowTitle3 = new Label("High-protein Non-Veg(per 100gm)");
        rowTitle3.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create boxes with images and labels
        VBox Cbox1 = createBox("/images/n1.jpeg", "Cals: 165\nProt: 31");
        VBox Cbox2 = createBox("/images/n2.jpeg", "Cals: 190\nProt: 22");
        VBox Cbox3 = createBox("/images/n3.jpeg", "Cals: 78\nProt: 6");
        VBox Cbox4 = createBox("/images/n4.jpeg", "Cals: 84\nProt: 17");
        VBox Cbox5 = createBox("/images/n5.jpeg", "Cals: 184\nProt: 25");
        VBox Cbox6 = createBox("/images/n6.jpeg", "Cals: 165\nProt: 28");
        VBox Cbox7 = createBox("/images/n7.jpeg", "Cals: 69\nProt: 20");

        HBox row3 = new HBox(Cbox1, Cbox2, Cbox3, Cbox4, Cbox5, Cbox6, Cbox7);
        HBox.setHgrow(Cbox1, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Cbox2, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Cbox3, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Cbox4, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Cbox5, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Cbox6, Priority.ALWAYS); // Set Hgrow for individual boxes
        HBox.setHgrow(Cbox7, Priority.ALWAYS); // Set Hgrow for individual boxes
        row3.setMinHeight(180);
        row3.setSpacing(25);

        VBox third = new VBox(rowTitle3, row3);
        third.setPadding(new Insets(10, 30, 30, 30));
        third.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45");
        third.setSpacing(10);

        VBox rightColumn = new VBox(first, second, third);
        rightColumn.setMaxHeight(800);
        rightColumn.setMaxWidth(800);
        rightColumn.setSpacing(10);

        // Main HBox
        HBox belowHead = new HBox(10, leftColumn, rightColumn);
        HBox.setHgrow(rightColumn, Priority.ALWAYS);
        belowHead.setPadding(new Insets(0, 20, 20, 20));
        belowHead.setSpacing(20);

        VBox mainBox = new VBox(dashbox, belowHead);
        mainBox.setStyle("-fx-background-color: #222831");
        mainBox.setMinWidth(2200);

        group = new Group(mainBox);

        // Load custom stylesheet

    }

    private VBox createBox(String imagePath, String calories) {
        ImageView imageView = new ImageView(new Image(getClass().getResource(imagePath).toExternalForm()));
        imageView.setFitWidth(110);
        imageView.setFitHeight(110);

        // Create a rectangle with rounded corners
        Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip.setArcWidth(35);
        clip.setArcHeight(35);

        // Set the clip for the ImageView
        imageView.setClip(clip);

        Label textLabel = new Label(calories);
        textLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold");

        VBox box = new VBox(imageView, textLabel);
        box.setPrefHeight(160);
        box.setPrefWidth(140);
        box.setStyle("-fx-background-color: white; -fx-background-radius: 25");
        box.setAlignment(Pos.TOP_LEFT);
        box.setPadding(new Insets(5, 5, 5, 5));

        return box;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
