package com.demo1.controller;

import com.demo1.service.Navigation;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Gain_lose {

    private Navigation nav;
    private HBox splitHBox;

    public Gain_lose(Navigation nav){
        this.nav = nav;
        initialize();
    }

    public void initialize() {

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
            nav.navigateToQue1();
        });
        rightPane.setOnMouseClicked(event -> {
            nav.navigateToQue1();
        });

        Label copyright = new Label("CHOOSE");
        copyright.setPadding(new Insets(0, 0, 100, 0));

        // Create an HBox to hold the two panes
        splitHBox = new HBox(leftPane, rightPane);
        HBox.setHgrow(leftPane, javafx.scene.layout.Priority.ALWAYS);
        HBox.setHgrow(rightPane, javafx.scene.layout.Priority.ALWAYS);
    }

    public HBox getSplitHBox() {
        return splitHBox;
    }

    public void setSplitHBox(HBox splitHBox) {
        this.splitHBox = splitHBox;
    }

}
