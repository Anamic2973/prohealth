package com.demo1.view;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.demo1.firebaseConfig.DataService;
import com.demo1.navigation.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Screen;

public class Dashboard {
        private final DataService dataService;
        private Navigation nav;
        private Group group;
        public String logUser = Login.loggedinUserName;

        private String title = "Prohealth";
        private String userName;
        // private String age;
        // private String height;
        // private String weight;
        // private String gender;
        // private String isgain;

        private int baseGoalValue = 2080; // Example default value, adjust as needed
        // private int foodValue = 300;

        private Label baseGoalLabel;
        private Label foodLabel;
        private Pane progressRingPane;

        public Dashboard(Navigation nav, String username) {
                this.logUser = username;
                this.dataService = new DataService();
                this.nav = nav;
                initialize();
        }

        private Pane createProgressRingPane(int currentCalories, int goalCalories, double size) {
                StackPane progressRingPane = new StackPane();
                progressRingPane.setPrefSize(size, size);

                double percentage = Math.min(1.0, (double) currentCalories / goalCalories);

                Arc backgroundArc = new Arc(size / 2, size / 2, size / 2 - 10, size / 2 - 10, 0, 360);
                backgroundArc.setType(ArcType.OPEN);
                backgroundArc.setStroke(Color.LIGHTGRAY);
                backgroundArc.setStrokeWidth(20);
                backgroundArc.setFill(null);

                Arc progressArc = new Arc(size / 2, size / 2, size / 2 - 10, size / 2 - 10, 0, 360);
                progressArc.setType(ArcType.OPEN);
                progressArc.setStroke(Color.web("#00ADB5"));
                progressArc.setStrokeWidth(20);
                progressArc.setFill(null);

                double circumference = Math.PI * (size - 20);
                double progressLength = percentage * circumference;
                double remainingLength = circumference - progressLength;

                progressArc.getStrokeDashArray().addAll(progressLength, remainingLength);

                Label progressLabel = new Label(String.format("%.0f%%", percentage * 100));
                progressLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #EEEEEE;");
                StackPane.setAlignment(progressLabel, Pos.CENTER);

                progressRingPane.getChildren().addAll(backgroundArc, progressArc, progressLabel);

                return progressRingPane;
        }

        public void initialize() {
                try {
                        Map<String, Object> userData = DataService.getDocumentData(Login.loggedinUserName, "name");
                        if (userData != null) {
                                userName = (String) userData.get("name");
                        }
                } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                }

                DropShadow shadow = new DropShadow();
                shadow.setColor(Color.web("#6af8ff"));
                shadow.setRadius(10);
                shadow.setOffsetX(0);
                shadow.setOffsetY(0);

                HBox dashbox = new HBox();
                dashbox.setPadding(new Insets(10, 10, 10, 10));
                dashbox.setMinHeight(80);
                dashbox.setStyle("-fx-background-color: #222831; ");
                dashbox.setAlignment(Pos.CENTER_LEFT);

                Label nameLabel = new Label(title);
                nameLabel.setStyle(
                                "-fx-font-size: 60px; -fx-text-fill: #EEEEEE; -fx-font-weight: ExtraBold; -fx-font-family: 'Kanit';");

                Button profileButton = new Button("A");
                profileButton.setStyle(
                                "-fx-background-color: #393E46; " +
                                                "-fx-text-fill: #EEEEEE; " +
                                                "-fx-font-size: 24px; " +
                                                "-fx-background-radius: 50%; " +
                                                "-fx-min-width: 50px; " +
                                                "-fx-min-height: 50px; " +
                                                "-fx-max-width: 50px; " +
                                                "-fx-max-height: 50px; " +
                                                "-fx-border-color: NULL; " +
                                                "-fx-border-width: 3px; " +
                                                "-fx-border-radius: 50%;");
                profileButton.setEffect(shadow);
                profileButton.setOnAction(event -> nav.navigateToProfile(Login.loggedinUserName));

                dashbox.getChildren().addAll(nameLabel, profileButton);
                HBox.setHgrow(nameLabel, Priority.ALWAYS);
                dashbox.setSpacing(20);
                dashbox.setAlignment(Pos.CENTER_LEFT);
                profileButton.setAlignment(Pos.CENTER_RIGHT);
                nameLabel.setMaxWidth(1300);

                double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
                double topBoxWidth = 0.5 * screenWidth;
                double rightBoxWidth = 0.1 * screenWidth;
                double midBoxWidth = 0.2 * screenWidth;

                HBox topHBox = new HBox();
                topHBox.setAlignment(Pos.CENTER);
                topHBox.setMaxHeight(500);
                topHBox.setMinWidth(topBoxWidth);
                topHBox.setPadding(new Insets(10, 20, 10, 20));
                topHBox.setSpacing(10);
                topHBox.setStyle("-fx-background-color: #393E46;-fx-background-radius: 45; -fx-border-radius: 45;");
                topHBox.setEffect(shadow);

                progressRingPane = createProgressRingPane(DietLogbook.totalCalories, baseGoalValue, 400);
                progressRingPane.setMaxWidth(400);
                progressRingPane.setMaxHeight(400);

                VBox valuesVBox = new VBox();
                valuesVBox.setAlignment(Pos.CENTER_LEFT);
                valuesVBox.setSpacing(0);

                Label basegoaldef = new Label("    Base Goal");
                Label fooddef = new Label("    Food");
                Label space = new Label("       ");
                baseGoalLabel = new Label("     " + baseGoalValue);
                foodLabel = new Label("      " + DietLogbook.totalCalories);

                basegoaldef.setStyle("-fx-font-size: 25px; -fx-text-fill: #EEEEEE;-fx-font-weight: ExtraBold; ");
                fooddef.setStyle("-fx-font-size: 25px; -fx-text-fill: #EEEEEE;-fx-font-weight: ExtraBold; ");
                baseGoalLabel.setStyle("-fx-font-size: 40px; -fx-text-fill: #dacd00;");
                foodLabel.setStyle("-fx-font-size: 40px; -fx-text-fill: #27da00;");

                valuesVBox.getChildren().addAll(basegoaldef, baseGoalLabel, space, fooddef, foodLabel);

                topHBox.getChildren().addAll(progressRingPane, valuesVBox);
                HBox.setHgrow(progressRingPane, Priority.SOMETIMES);
                HBox.setHgrow(valuesVBox, Priority.ALWAYS);
                topHBox.setPadding(new Insets(50, 50, 50, 50));

                // ... (rest of the code remains largely the same)
                Label midlabel1 = new Label("HELLO !");
                midlabel1.setStyle(
                                "-fx-font-size: 50px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");
                Label midlabel2 = new Label("WELCOME");
                midlabel2.setStyle(
                                "-fx-font-size: 50px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");
                Label midlabel3 = new Label(userName);
                midlabel3.setStyle(
                                "-fx-font-size: 50px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");

                VBox midBox = new VBox(midlabel1, midlabel2, midlabel3);
                midBox.setMinWidth(midBoxWidth);
                midBox.setMaxHeight(500);
                midBox.setStyle("-fx-background-color: #6af8ff; -fx-background-radius: 45; -fx-border-radius: 45;");
                midBox.setPadding(new Insets(40, 40, 40, 40));
                midBox.setAlignment(Pos.CENTER_LEFT);

                // toprightbox
                StackPane rightBoxHolder = new StackPane(); // StackPane to hold rightBox for clickability
                rightBoxHolder.setOnMouseClicked(event -> {
                        nav.navigateToDietLogBook();
                        System.out.println("Right box clicked!"); // Example action
                        // Add your logic here for when rightBox is clicked
                });
                VBox rightBox = new VBox();
                rightBox.setMinWidth(rightBoxWidth);
                rightBox.setMaxHeight(500); //
                rightBox.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45; -fx-border-radius: 45;");

                // Add image to the right box
                Image image = new Image("/images/log.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(150); //
                imageView.setPreserveRatio(true);

                // Add labels to the right box
                Label rightTextLabel1 = new Label("LOG \nBOOK"); //
                rightTextLabel1.setStyle(
                                "-fx-font-size: 70px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");
                // Label rightTextLabel2 = new Label("BOOK");
                // rightTextLabel2.setStyle(
                // "-fx-font-size: 70px; -fx-text-fill: black; -fx-font-family: 'Poppins';
                // -fx-font-weight: bold;");

                // Add image and labels to the right box
                rightBox.getChildren().addAll(imageView, rightTextLabel1);
                rightBox.setSpacing(20); // Adjust spacing as needed
                rightBox.setPadding(new Insets(50, 50, 50, 50));

                rightBoxHolder.getChildren().add(rightBox);

                // Create a GridPane for the square boxes
                GridPane gridPane = new GridPane();
                gridPane.setAlignment(Pos.CENTER_LEFT); //
                gridPane.setHgap(20); // Horizontal gap between boxes

                // Create the first square box
                HBox box1 = new HBox();
                box1.setMinSize(70, 200); // Set the width and height of each box to be square //
                GridPane.setHgrow(box1, Priority.ALWAYS); // Make boxes expand horizontally
                box1.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45; -fx-border-radius: 45;");

                // Add image to the left side (30% width)
                Image image1 = new Image("images/dumbell.png"); //
                ImageView imageView1 = new ImageView(image1);
                imageView1.setFitHeight(100);
                imageView1.setPreserveRatio(true);
                HBox imageContainer = new HBox(imageView1);
                imageContainer.setAlignment(Pos.CENTER);
                imageContainer.setPrefWidth(0.3 * box1.getMinWidth()); // 30% width
                HBox.setHgrow(imageContainer, Priority.NEVER);

                // Add text area to the right side (70% width)
                Label textLabel1 = new Label("WORKOUTS");
                textLabel1.setStyle(
                                "-fx-font-size: 40px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");
                VBox textContainer1 = new VBox(textLabel1);
                textContainer1.setAlignment(Pos.CENTER_LEFT);
                textContainer1.setPrefWidth(0.7 * box1.getMinWidth()); // 70% width
                HBox.setHgrow(textContainer1, Priority.ALWAYS);

                // Add image and text containers to box1
                box1.getChildren().addAll(imageContainer, textContainer1);
                box1.setPadding(new Insets(20, 20, 20, 80)); //

                StackPane box1Holder = new StackPane();
                box1Holder.getChildren().add(box1);
                box1Holder.setMaxHeight(150);
                box1Holder.setMinWidth(0.315 * screenWidth); //
                box1Holder.setOnMouseClicked(event -> {
                        nav.navigateToWorkoutLog();
                        System.out.println("Box 1 (Workouts) clicked!"); // Example action
                        // Add your logic here for when box1 is clicked
                });

                // Create the second square box (empty for now)
                HBox box2 = new HBox();
                box2.setMinSize(70, 200); // Set the width and height of each box to be square
                GridPane.setHgrow(box2, Priority.ALWAYS); // Make boxes expand horizontally
                box2.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45; -fx-border-radius: 45;");

                // Add image to the left side (30% width)
                Image image2 = new Image("/images/recipie.png");
                ImageView imageView2 = new ImageView(image2);
                imageView2.setFitHeight(100);
                imageView2.setPreserveRatio(true);
                HBox imageContainer2 = new HBox(imageView2);
                imageContainer2.setAlignment(Pos.CENTER);
                imageContainer2.setPrefWidth(0.3 * box2.getMinWidth()); // 30% width
                HBox.setHgrow(imageContainer2, Priority.NEVER);

                // Add text area to the right side (70% width)
                Label textLabel2 = new Label("MACROS");
                textLabel2.setStyle(
                                "-fx-font-size: 40px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");
                VBox textContainer2 = new VBox(textLabel2);
                textContainer2.setAlignment(Pos.CENTER_LEFT);
                textContainer2.setPadding(new Insets(10, 10, 10, 20));
                textContainer2.setPrefWidth(0.7 * box2.getMinWidth()); // 70% width
                HBox.setHgrow(textContainer2, Priority.ALWAYS);

                // Add image and text containers to box2
                box2.getChildren().addAll(imageContainer2, textContainer2);
                box2.setPadding(new Insets(20, 20, 20, 100));

                // Create a clickable StackPane wrapper for box2
                StackPane box2Holder = new StackPane();
                box2Holder.getChildren().add(box2);
                box2Holder.setMinWidth(0.315 * screenWidth);
                box2Holder.setOnMouseClicked(event -> {
                        System.out.println("Box 2 (Recipes) clicked!");
                        nav.navigateTorecipie(); // Example action
                        // Add your logic here for when box2 is clicked
                });

                // Create the first square box
                HBox box3 = new HBox();
                box3.setMinSize(70, 200); // Set the width and height of each box to be square //
                GridPane.setHgrow(box3, Priority.ALWAYS); // Make boxes expand horizontally
                box3.setStyle("-fx-background-color: #00ADB5; -fx-background-radius: 45; -fx-border-radius: 45;");

                // Add image to the left side (30% width)
                Image image3 = new Image("images/history.png"); //
                ImageView imageView3 = new ImageView(image3);
                imageView3.setFitHeight(100);
                imageView3.setPreserveRatio(true);
                HBox imageContainer3 = new HBox(imageView3);
                imageContainer3.setAlignment(Pos.CENTER);
                imageContainer3.setPrefWidth(0.3 * box1.getMinWidth()); // 30% width
                HBox.setHgrow(imageContainer3, Priority.NEVER);

                // Add text area to the right side (70% width)
                Label textLabel3 = new Label("  History");
                textLabel3.setStyle(
                                "-fx-font-size: 40px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");
                VBox textContainer3 = new VBox(textLabel3);
                textContainer3.setAlignment(Pos.CENTER_LEFT);
                textContainer3.setPrefWidth(0.7 * box1.getMinWidth()); // 70% width
                HBox.setHgrow(textContainer3, Priority.ALWAYS);

                // Add image and text containers to box1
                box3.getChildren().addAll(imageContainer3, textContainer3);
                box3.setPadding(new Insets(20, 20, 20, 100)); //

                StackPane box3Holder = new StackPane();
                box3Holder.getChildren().add(box3);
                box3Holder.setMaxHeight(150);
                box3Holder.setMinWidth(0.315 * screenWidth);
                box3Holder.setOnMouseClicked(event -> {
                        nav.navigatetoHistory(Login.loggedinUserName);
                        System.out.println("Box 3 () clicked!"); // Example action
                        // Add your logic here for when box1 is clicked
                });

                // Add the boxes to the GridPane
                gridPane.add(box1Holder, 0, 0);
                gridPane.add(box2Holder, 1, 0);
                gridPane.add(box3Holder, 2, 0);

                // topHBox and right box holder
                HBox hboxTopAndRight = new HBox();
                hboxTopAndRight.getChildren().addAll(topHBox, midBox, rightBoxHolder); // Use rightBoxHolder instead of
                                                                                       // rightBox
                hboxTopAndRight.setSpacing(20);

                VBox mainLayout = new VBox();
                mainLayout.getChildren().addAll(dashbox, hboxTopAndRight, gridPane);
                mainLayout.setSpacing(20);
                mainLayout.setStyle("-fx-background-color: #222831");
                mainLayout.setPadding(new Insets(20, 20, 20, 20));

                group = new Group(mainLayout);
        }

        public void updateCaloriesDisplay() {
                foodLabel.setText("      " + DietLogbook.totalCalories);
                updateProgressRing();
        }

        public void updateProgressRing() {
                double percentage = Math.min(1.0, (double) DietLogbook.totalCalories / baseGoalValue);
                Arc progressArc = (Arc) progressRingPane.getChildren().get(1);
                Label progressLabel = (Label) progressRingPane.getChildren().get(2);

                double circumference = Math.PI * 380; // 400 - 20
                double progressLength = percentage * circumference;
                double remainingLength = circumference - progressLength;

                progressArc.getStrokeDashArray().setAll(progressLength, remainingLength);
                progressLabel.setText(String.format("%.0f%%", percentage * 100));
        }

        public Group getGroup() {
                return group;
        }

        public void setGroup(Group group) {
                this.group = group;
        }
}