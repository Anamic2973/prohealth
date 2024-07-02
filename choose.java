package demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class choose extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create text for the left and right parts
        Label leftText = new Label("GAIN");
        leftText.setFont(new Font(100));
        leftText.setTextFill(Color.WHITE);

        Label leftlowText = new Label("weight");
        leftText.setTextFill(Color.WHITESMOKE);

        Label rightText = new Label("LOSE");
        rightText.setFont(new Font(100));
        rightText.setTextFill(Color.WHITE);

        Label rightlowText = new Label("weight");
        leftText.setTextFill(Color.WHITESMOKE);

        rightlowText.setPadding(new Insets(100, 0, 0, 0));
        leftlowText.setPadding(new Insets(100, 0, 0, 0));

        // Create two StackPanes for the left and right sides
        StackPane leftPane = new StackPane();
        StackPane rightPane = new StackPane();

        // Add text to the StackPanes
        leftPane.getChildren().add(leftlowText);
        rightPane.getChildren().add(rightlowText);
        leftPane.getChildren().add(leftText);
        rightPane.getChildren().add(rightText);

        // Set unique background colors for each pane
        leftPane.setStyle("-fx-background-image: url('/images/left.jpg');"); // Gain color or left
        rightPane.setStyle("-fx-background-image: url('/images/right.jpg');"); // Lose color or right

        // Make the areas clickable
        leftPane.setOnMouseClicked(event -> {
            navigateLeft(primaryStage);
        });
        rightPane.setOnMouseClicked(event -> {
            navigateRight(primaryStage);
        });

        Label copyright = new Label("CHOOSE");
        copyright.setPadding(new Insets(0, 0, 100, 0));

        // Create an HBox to hold the two panes
        HBox split = new HBox(leftPane, rightPane);
        HBox.setHgrow(leftPane, javafx.scene.layout.Priority.ALWAYS);
        HBox.setHgrow(rightPane, javafx.scene.layout.Priority.ALWAYS);

        // Create the Scene with the HBox as the root node
        Scene scene = new Scene(split, 800, 800);

        // Set up the Stage
        primaryStage.setTitle("CHOOSE");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setFullScreen(true);

    }

    private void navigateRight(Stage pr) {
        try {
            // Instantiate the Login class
            login loginApp = new login();
            loginApp.start(pr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void navigateLeft(Stage pr) {
        try {
            // Instantiate the Login class
            login loginApp = new login();
            loginApp.start(pr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
