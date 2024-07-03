package demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class dashboard extends Application {
        private String title = "PROHEALTH"; // User's name variable
        private String userName = "HARSH";
        private int baseGoalValue = 100; // Base goal value variable
        private int foodValue = 300; // Food value variable
        private int exerciseValue = 200; // Exercise value variable

        private Label baseGoalLabel;
        private Label foodLabel;
        private Label exerciseLabel;

        private Pane createProgressRingPane(double percentage, double size) {
                StackPane progressRingPane = new StackPane();
                progressRingPane.setPrefSize(size, size);

                // Create progress arc with stroke pattern
                Arc progressArc = new Arc(size / 2, size / 2, size / 2 - 10, size / 2 - 10, 0, 180);
                progressArc.setType(ArcType.OPEN);
                progressArc.setStroke(Color.RED);
                progressArc.setStrokeWidth(20);
                progressArc.setFill(null);

                // Create a stroke dash array to represent the percentage and remaining part
                double circumference = Math.PI * (size - 20);
                double progressLength = percentage * circumference;
                double remainingLength = circumference - progressLength;

                // Set stroke dash array
                progressArc.getStrokeDashArray().addAll(progressLength, remainingLength);
                progressArc.setStroke(Color.RED);

                // Create a second arc to cover the remaining part in light gray
                Arc backgroundArc = new Arc(size / 2, size / 2, size / 2 - 10, size / 2 - 10, 0, 180);
                backgroundArc.setType(ArcType.OPEN);
                backgroundArc.setStroke(Color.LIGHTGRAY);
                backgroundArc.setStrokeWidth(20);
                backgroundArc.setFill(null);
                // percentage = baseGoalValue;

                // Create label for progress percentage
                Label progressLabel = new Label(String.format("%.0f%%", percentage * 100));
                progressLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: black;");
                StackPane.setAlignment(progressLabel, Pos.CENTER);

                // Add arcs and label to the stack pane
                progressRingPane.getChildren().addAll(backgroundArc, progressArc, progressLabel);

                return progressRingPane;
        }

        @Override
        public void start(Stage primaryStage) throws Exception {

                // creating drop shadow
                DropShadow shadow = new DropShadow();
                shadow.setColor(Color.GRAY);
                shadow.setRadius(15);
                shadow.setOffsetX(0);
                shadow.setOffsetY(0);
                // Create a dashboard box (dashbox)
                HBox dashbox = new HBox();
                dashbox.setPadding(new Insets(10, 10, 10, 10));
                dashbox.setMinHeight(80);
                dashbox.setStyle("-fx-background-color: NULL; ");
                dashbox.setAlignment(Pos.CENTER_LEFT);

                // Create a label for the user's name
                Label nameLabel = new Label(title);
                nameLabel.setStyle(
                                "-fx-font-size: 60px; " + // Font size
                                                "-fx-text-fill: BLACK; " + // Text color
                                                "-fx-font-weight: bold; " + // Font weight
                                                "-fx-font-family: 'poppins';" // Font family
                );
                Label name1 = new Label(userName);
                name1.setStyle(
                                "-fx-font-size: 60px; " + // Font size
                                                "-fx-text-fill: white; " + // Text color
                                                "-fx-font-weight: bold; " + // Font weight
                                                "-fx-font-family: 'poppins';" // Font family
                );

                // Create a circular button for the profile
                Button profileButton = new Button("P");
                profileButton.setStyle(
                                "-fx-background-color: null; -fx-border-radius: 50%; -fx-background-radius: 50%; -fx-min-width: 40px; -fx-min-height: 40px;");
                profileButton.setText("A");
                profileButton.setStyle(
                                "-fx-background-color: WHITE; " +
                                                "-fx-text-fill: RED; " +
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

                // Add the name label and profile button to the dashbox
                dashbox.getChildren().addAll(nameLabel, profileButton);
                HBox.setHgrow(nameLabel, Priority.ALWAYS);
                dashbox.setSpacing(10);

                // Adjust alignment for the profile button to be on the rightmost part
                dashbox.setSpacing(20);
                dashbox.setAlignment(Pos.CENTER_LEFT);
                HBox.setHgrow(nameLabel, Priority.ALWAYS);
                HBox.setHgrow(profileButton, Priority.ALWAYS);
                profileButton.setAlignment(Pos.CENTER_RIGHT);
                nameLabel.setMaxWidth(Double.MAX_VALUE);

                // width is 70 percent of screen
                double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
                double topBoxWidth = 0.6 * screenWidth;
                double rightBoxWidth = 0.2 * screenWidth;
                double midBoxWidth = 0.2 * screenWidth;

                // topbox horizontal
                HBox topHBox = new HBox();
                topHBox.setAlignment(Pos.CENTER);
                topHBox.setMinHeight(600); // Set the height as needed
                topHBox.setMinWidth(topBoxWidth);
                topHBox.setPadding(new Insets(10, 20, 10, 20));
                topHBox.setSpacing(10); // Set the spacing as needed
                topHBox.setStyle("-fx-background-color: white;-fx-background-radius: 45; -fx-border-radius: 45;");
                topHBox.setEffect(shadow);

                // Create a semi-circle progress ring on the left side
                double percentage = (double) baseGoalValue / 1000; // Assuming 1000 is the max goal value
                Pane progressRingPane = createProgressRingPane(percentage, 400); // Fill based on percentage
                progressRingPane.setMaxWidth(400);
                progressRingPane.setMaxHeight(400);

                // midbox
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
                midBox.setStyle("-fx-background-color: #ffedbf; -fx-background-radius: 45; -fx-border-radius: 45;");
                midBox.setPadding(new Insets(40, 40, 40, 40));
                midBox.setAlignment(Pos.CENTER);

                // Create a VBox for the values on the right side (60% width)
                VBox valuesVBox = new VBox();
                valuesVBox.setAlignment(Pos.CENTER_LEFT);
                valuesVBox.setSpacing(30);

                // create labels for dash data
                baseGoalLabel = new Label("     Base Goal: " + baseGoalValue);
                foodLabel = new Label("     Food: " + foodValue);
                exerciseLabel = new Label("     Exercise: " + exerciseValue);

                // Style the labels as needed
                baseGoalLabel.setStyle("-fx-font-size: 40px; -fx-text-fill: black;");
                foodLabel.setStyle("-fx-font-size: 40px; -fx-text-fill: black;");
                exerciseLabel.setStyle("-fx-font-size: 40px; -fx-text-fill: black;");

                // Add labels to the VBox
                valuesVBox.getChildren().addAll(baseGoalLabel, foodLabel, exerciseLabel);

                // Add progress ring and values VBox to topHBox
                topHBox.getChildren().addAll(progressRingPane, valuesVBox);
                HBox.setHgrow(progressRingPane, Priority.SOMETIMES);
                HBox.setHgrow(valuesVBox, Priority.ALWAYS);
                topHBox.setPadding(new Insets(50, 50, 50, 50));

                // toprightbox
                VBox rightBox = new VBox();
                rightBox.setMinWidth(rightBoxWidth);
                rightBox.setStyle("-fx-background-color: #ffbc46; -fx-background-radius: 45; -fx-border-radius: 45;");
                // Add image to the right box
                Image image = new Image("/images/log.png");
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(250);
                imageView.setPreserveRatio(true);

                // Add labels to the right box
                Label rightTextLabel1 = new Label("  LOG");
                rightTextLabel1.setStyle(
                                "-fx-font-size: 70px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");
                Label rightTextLabel2 = new Label("BOOK");
                rightTextLabel2.setStyle(
                                "-fx-font-size: 70px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");

                // Add image and labels to the right box
                rightBox.getChildren().addAll(imageView, rightTextLabel1, rightTextLabel2);
                rightBox.setSpacing(20); // Adjust spacing as needed
                rightBox.setPadding(new Insets(50, 50, 50, 50));

                // Create a GridPane for the square boxes
                GridPane gridPane = new GridPane();
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setHgap(20); // Horizontal gap between boxes

                // Create the first square box
                HBox box1 = new HBox();
                box1.setMinSize(70, 300); // Set the width and height of each box to be square
                GridPane.setHgrow(box1, Priority.ALWAYS); // Make boxes expand horizontally
                box1.setStyle("-fx-background-color: #ffbc46; -fx-background-radius: 45; -fx-border-radius: 45;");

                // Add image to the left side (30% width)
                Image image1 = new Image("/images/workout.png");
                ImageView imageView1 = new ImageView(image1);
                imageView1.setFitHeight(220);
                imageView1.setPreserveRatio(true);
                HBox imageContainer = new HBox(imageView1);
                imageContainer.setAlignment(Pos.CENTER);
                imageContainer.setPrefWidth(0.3 * box1.getMinWidth()); // 30% width
                HBox.setHgrow(imageContainer, Priority.NEVER);

                // Add text area to the right side (70% width)
                Label textLabel1 = new Label("  WORKOUTS");
                textLabel1.setStyle(
                                "-fx-font-size: 70px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");
                VBox textContainer1 = new VBox(textLabel1);
                textContainer1.setAlignment(Pos.CENTER_LEFT);
                textContainer1.setPadding(new Insets(10, 10, 10, 20));
                textContainer1.setPrefWidth(0.7 * box1.getMinWidth()); // 70% width
                HBox.setHgrow(textContainer1, Priority.ALWAYS);

                // Add image and text containers to box1
                box1.getChildren().addAll(imageContainer, textContainer1);
                box1.setPadding(new Insets(20, 20, 20, 20));

                // Create the second square box (empty for now)
                HBox box2 = new HBox();
                box2.setMinSize(70, 300); // Set the width and height of each box to be square
                GridPane.setHgrow(box2, Priority.ALWAYS); // Make boxes expand horizontally
                box2.setStyle("-fx-background-color: #ffbc46; -fx-background-radius: 45; -fx-border-radius: 45;");

                // Add image to the left side (30% width)
                Image image2 = new Image("/images/recipie.png");
                ImageView imageView2 = new ImageView(image2);
                imageView2.setFitHeight(220);
                imageView2.setPreserveRatio(true);
                HBox imageContainer2 = new HBox(imageView2);
                imageContainer2.setAlignment(Pos.CENTER);
                imageContainer2.setPrefWidth(0.3 * box2.getMinWidth()); // 30% width
                HBox.setHgrow(imageContainer2, Priority.NEVER);

                // Add text area to the right side (70% width)
                Label textLabel2 = new Label("   RECIPIES");
                textLabel2.setStyle(
                                "-fx-font-size: 70px; -fx-text-fill: black; -fx-font-family: 'Poppins'; -fx-font-weight: bold;");
                VBox textContainer2 = new VBox(textLabel2);
                textContainer2.setAlignment(Pos.CENTER_LEFT);
                textContainer2.setPadding(new Insets(10, 10, 10, 20));
                textContainer2.setPrefWidth(0.7 * box2.getMinWidth()); // 70% width
                HBox.setHgrow(textContainer2, Priority.ALWAYS);

                // Add image and text containers to box2
                box2.getChildren().addAll(imageContainer2, textContainer2);
                box2.setPadding(new Insets(20, 20, 20, 20));

                // Add the boxes to the GridPane
                gridPane.add(box1, 0, 0);
                gridPane.add(box2, 1, 0);

                // topHBox and right box holder
                HBox hboxTopAndRight = new HBox();
                hboxTopAndRight.getChildren().addAll(topHBox, midBox, rightBox);
                hboxTopAndRight.setSpacing(20);

                // Create the main layout with VBox
                VBox mainLayout = new VBox();
                mainLayout.getChildren().addAll(dashbox, hboxTopAndRight, gridPane);
                mainLayout.setSpacing(25);
                // mainLayout.setStyle("-fx-background-color: linear-gradient(to bottom,
                // #FFBC46,
                // white);");
                mainLayout.setStyle("-fx-background-color: null");
                mainLayout.getStylesheets().add(getClass().getResource("/demo/style.css").toExternalForm());
                mainLayout.setPadding(new Insets(20, 20, 20, 20));

                // Create the scene and set it to the stage
                Scene scene = new Scene(mainLayout, 600, 400); // Set the width and height of the scene
                primaryStage.setTitle("DASHBOARD");
                primaryStage.setScene(scene);
                primaryStage.show();
                primaryStage.setFullScreen(true);
        }

        // private method to update values later
        // private void updateValues(int baseGoal, int food, int exercise) {
        // this.baseGoalValue = baseGoal;
        // this.foodValue = food;
        // this.exerciseValue = exercise;

        // // Update labels
        // baseGoalLabel.setText("Base Goal: " + baseGoalValue);
        // foodLabel.setText("Food: " + foodValue);
        // exerciseLabel.setText("Exercise: " + exerciseValue);
        // }

}
