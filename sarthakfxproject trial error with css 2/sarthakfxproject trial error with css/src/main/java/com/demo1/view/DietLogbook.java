package com.demo1.view;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.demo1.firebaseConfig.DataService;
import com.demo1.navigation.Navigation;
import com.demo1.nestedCollection.Diet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class DietLogbook {

    private Navigation nav;
    private Group group;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane2;
    private ScrollPane scrollPane3;
    int remainingCal;

    public DietLogbook(Navigation nav) {
        this.nav = nav;
        initialize();
    }

    public static int totalCalories = 0;
    private int breakfastCalories = 0;
    private int lunchCalories = 0;
    private int dinnerCalories = 0;

    private Map<String, Integer> breakfastCalorieMap = new HashMap<>();
    private Map<String, Integer> lunchCalorieMap = new HashMap<>();
    private Map<String, Integer> dinnerCalorieMap = new HashMap<>();

    public void initialize() {
        // list1

        // list1
        ListView<String> listView1 = new ListView<>();
        listView1.getStyleClass().add("list-view");

        // Create an ObservableList of items
        ObservableList<String> items1 = FXCollections.observableArrayList();

        listView1.setItems(items1);

        // list2

        ListView<String> listView2 = new ListView<>();
        listView2.getStyleClass().add("list-view");

        // Create an ObservableList of items
        ObservableList<String> items2 = FXCollections.observableArrayList();

        listView2.setItems(items2);

        // list3
        ListView<String> listView3 = new ListView<>();
        listView3.getStyleClass().add("list-view");

        // Create an ObservableList of items
        ObservableList<String> items3 = FXCollections.observableArrayList();

        listView3.setItems(items3);

        Line horizontalline1light = new Line();
        horizontalline1light.setStartX(100);
        horizontalline1light.setEndX(900);
        horizontalline1light.setOpacity(0.1);

        Line horizontalline2light = new Line();
        horizontalline2light.setStartX(100);
        horizontalline2light.setEndX(900);
        horizontalline2light.setOpacity(0.1);

        Line horizontalline3light = new Line();
        horizontalline3light.setStartX(100);
        horizontalline3light.setEndX(900);
        horizontalline3light.setOpacity(0.1);

        Image image = new Image("https://cdn-icons-png.flaticon.com/512/6658/6658285.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100); // Set image width
        imageView.setFitHeight(100); // Set image height
        imageView.setPreserveRatio(true);

        // Create Labels
        Label log = new Label("LOG");
        log.setFont(Font.font("Montserrat", 70)); // Set font weight to bold
        log.setPadding(new Insets(0, 0, 0, 0));
        HBox img = new HBox(log, imageView);
        img.setPadding(new Insets(300, 0, 0, 70));

        Label book = new Label("Book");
        book.setFont(Font.font("Sans serif", 100)); // Set font weight to bold
        book.setPadding(new Insets(0, 0, 0, 70));

        Label textinbox = new Label(
                "Manage Your Daily Food Diary,\nTrack Your Activities\nAnd Lose Weight Successfully");
        textinbox.setFont(Font.font("Sans serif", 15)); // Set font weight to bold
        textinbox.setPadding(new Insets(30, 0, 0, 70));

        // Left VBox
        VBox lbl = new VBox(img, book, textinbox);
        lbl.setPrefWidth(400);
        lbl.setPrefHeight(1000);
        lbl.getStyleClass().add("left-box");
        lbl.setStyle("-fx-background-color: #00ADB5");

        // Operations
        Label sub = new Label("-");
        sub.setPadding(new Insets(0, 20, 0, 20));
        sub.setFont(Font.font("Montserrat", 40));

        Label add = new Label("+");
        add.setPadding(new Insets(0, 20, 0, 20));
        add.setFont(Font.font("Montserrat", 40));

        Label equal = new Label("=");
        equal.setPadding(new Insets(0, 20, 0, 20));
        equal.setFont(Font.font("Montserrat", 40));

        // Calories goal
        Label goalcal = new Label("2080");
        goalcal.setFont(Font.font("Montserrat", 40));
        Label goal = new Label("Goal");
        goal.setFont(Font.font("Montserrat", 20));
        VBox vbgoal = new VBox(goalcal, goal);
        vbgoal.setPadding(new Insets(0, 0, 0, 80));

        // Food cal
        Label foodcal = new Label(Integer.toString(totalCalories));
        foodcal.setFont(Font.font("Montserrat", 40));
        Label food = new Label("Food");
        food.setFont(Font.font("Montserrat", 20));
        VBox vbfood = new VBox(foodcal, food);
        vbfood.setPadding(new Insets(0, 0, 0, 20));

        // Exercise cal
        // Label exercal = new Label("0");
        // exercal.setFont(Font.font("Montserrat", 20));
        // // Label exercise = new Label("Exercise");
        // exercise.setFont(Font.font("Montserrat", 20));
        // VBox exerfood = new VBox(exercal, exercise);
        // exerfood.setPadding(new Insets(0, 0, 0, 20));
        // int remainingCal = Integer.parseInt(goalcal.getText()) - totalCalories;

        // Remaining cal
        Label remaincal = new Label(Integer.toString(remainingCal));
        remaincal.setFont(Font.font("Montserrat", 40));
        Label remaining = new Label("Remaining");
        remaining.setFont(Font.font("Montserrat", 20));
        VBox remainfood = new VBox(remaincal, remaining);
        remainfood.setPadding(new Insets(0, 0, 0, 20));

        // Calorie calculation HBox
        HBox calBox = new HBox(vbgoal, sub, vbfood, equal, remainfood);
        calBox.setPadding(new Insets(0, 20, 20, 20));
        calBox.getStyleClass().add("cal-box");
        calBox.setSpacing(80);
        calBox.setAlignment(Pos.CENTER);

        VBox calVBox = new VBox(calBox);
        calVBox.setPadding(new Insets(0, 0, 20, 0));

        // Breakfast
        Label breakfast = new Label("  Breakfast");
        breakfast.setFont(Font.font("Montserrat", 25));
        breakfast.setStyle("-fx-font-weight: ExtraBold; -fx-text-fill: white");
        Label breakfastcal = new Label("");
        breakfastcal.setFont(Font.font("Montserrat", 20));
        breakfastcal.setPadding(new Insets(0, 30, 0, 0));
        TextField newbreakfastfield = new TextField();
        newbreakfastfield.setPromptText("Enter Breakfast Item");
        newbreakfastfield.getStyleClass().add("rounded-text-field");
        TextField breakfastcalorie = new TextField();
        breakfastcalorie.setPromptText("Enter calorie");
        breakfastcalorie.getStyleClass().add("rounded-text-field");
        Label addFoodB = new Label("Add");
        addFoodB.setFont(Font.font("Montserrat", 20));
        addFoodB.setStyle("-fx-text-fill: white");
        addFoodB.setPadding(new Insets(0, 0, 0, 30));
        Label space = new Label("                     ");
        space.setFont(Font.font("Montserrat", 20));
        Label removeFoodB = new Label("Remove ");
        removeFoodB.setFont(Font.font("Montserrat", 20));
        removeFoodB.setPadding(new Insets(0, 0, 0, 10));
        removeFoodB.setStyle("-fx-text-fill: white");
        // removeFoodB.setOnMouseClicked(e -> {

        // String selectedItem1 = listView1.getSelectionModel().getSelectedItem();
        // if (selectedItem1 != null) {
        // items1.remove(selectedItem1);
        // }
        // });

        HBox breakf = new HBox(breakfast, breakfastcal, newbreakfastfield, breakfastcalorie, space, addFoodB,
                removeFoodB);
        breakf.setPadding(new Insets(20, 0, 10, 0));
        breakf.setSpacing(10);
        // VBox list1calbVBox = new VBox(listView1cal);
        // list1calbVBox.setPadding(new Insets(0, 0, 0, 50));
        VBox list1 = new VBox(listView1);

        ScrollPane scrollPane1 = new ScrollPane(list1);
        scrollPane1.setFitToWidth(true);
        scrollPane1.getStyleClass().add("scroll-panebreakfast");

        VBox innerVBoxb1 = new VBox(scrollPane1);
        innerVBoxb1.setPrefHeight(300);
        innerVBoxb1.setPrefWidth(100);

        VBox breakfastBox = new VBox(breakf, innerVBoxb1);
        breakfastBox.setPrefWidth(300);
        breakfastBox.setPrefHeight(220);
        breakfastBox.setPadding(new Insets(30, 0, 20, 0));
        breakfastBox.getStyleClass().add("breakfast-box");
        VBox bVBox = new VBox(breakfastBox);
        bVBox.setPadding(new Insets(20, 0, 0, 0));

        // Lunch
        Label lunch = new Label("Lunch");
        lunch.setFont(Font.font("Montserrat", 25));
        lunch.setStyle("-fx-font-weight: ExtraBold; -fx-text-fill: white");
        Label lunchcal = new Label("");
        lunchcal.setFont(Font.font("Montserrat", 20));
        lunchcal.setPadding(new Insets(0, 30, 0, 0));
        TextField newlunchfield = new TextField();
        newlunchfield.setPromptText("Enter Lunch Item");
        newlunchfield.getStyleClass().add("rounded-text-field");
        newlunchfield.setPadding(new Insets(0, 20, 0, 20));
        TextField lcalorie = new TextField();
        lcalorie.setPromptText("Enter calorie");
        lcalorie.getStyleClass().add("rounded-text-field");
        Label addFoodL = new Label("Add");
        addFoodL.setStyle("-fx-text-fill: white");
        addFoodL.setFont(Font.font("Montserrat", 20));
        addFoodL.setPadding(new Insets(0, 0, 0, 30));
        Label removeFoodl = new Label("Remove ");
        removeFoodl.setFont(Font.font("Montserrat", 20));
        removeFoodl.setStyle("-fx-text-fill: white");
        removeFoodl.setPadding(new Insets(0, 0, 0, 10));
        Label space1 = new Label("                       ");
        space1.setFont(Font.font("Montserrat", 20));
        // removeFoodB.setOnMouseClicked(e -> {

        // String selectedItem2 = listView2.getSelectionModel().getSelectedItem();
        // if (selectedItem2 != null) {
        // items2.remove(selectedItem2);
        // }
        // });

        HBox lunchHBox = new HBox(lunch, lunchcal, newlunchfield, lcalorie, space1, addFoodL, removeFoodl);
        lunchHBox.setPadding(new Insets(20, 0, 10, 40));
        lunchHBox.setSpacing(10);

        VBox list2 = new VBox(listView2);

        ScrollPane scrollPane2 = new ScrollPane(list2);
        scrollPane2.setFitToWidth(true);
        scrollPane2.getStyleClass().add("scroll-panelunch");

        VBox innerVBoxb2 = new VBox(scrollPane2);
        innerVBoxb2.setPrefHeight(300);
        innerVBoxb2.setPrefWidth(100);

        VBox lunchvBox = new VBox(lunchHBox, innerVBoxb2);
        lunchvBox.setPrefWidth(200);
        lunchvBox.setPrefHeight(220);
        lunchvBox.setPadding(new Insets(20, 0, 20, 0));
        lunchvBox.getStyleClass().add("breakfast-box");
        VBox lVBox = new VBox(lunchvBox);
        lVBox.setPadding(new Insets(20, 0, 0, 0));

        // Dinner
        Label dinner = new Label("Dinner");
        dinner.setFont(Font.font("Montserrat", 25));
        dinner.setStyle("-fx-font-weight: ExtraBold; -fx-text-fill: white");
        Label dinnercal = new Label("");
        dinnercal.setFont(Font.font("Montserrat", 20));
        dinnercal.setPadding(new Insets(0, 30, 0, 0));
        TextField dinnerfield = new TextField();
        dinnerfield.setPromptText("Enter Dinner Item");
        dinnerfield.getStyleClass().add("rounded-text-field");
        dinnerfield.setPadding(new Insets(0, 20, 0, 20));
        TextField dinnercalorie = new TextField();
        dinnercalorie.setPromptText("Enter calorie");
        dinnercalorie.getStyleClass().add("rounded-text-field");
        Label addFoodD = new Label("Add");
        addFoodD.setStyle("-fx-text-fill: white");
        addFoodD.setFont(Font.font("Montserrat", 20));
        addFoodD.setPadding(new Insets(0, 0, 0, 30));
        Label removeFoodd = new Label("Remove ");
        removeFoodd.setStyle("-fx-text-fill: white");
        removeFoodd.setFont(Font.font("Montserrat", 20));
        removeFoodd.setPadding(new Insets(0, 0, 0, 10));
        Label space3 = new Label("                     ");
        space3.setFont(Font.font("Montserrat", 20));
        // removeFoodd.setOnMouseClicked(e -> {
        // String selectedItem3 = listView3.getSelectionModel().getSelectedItem();
        // if (selectedItem3 != null) {
        // items3.remove(selectedItem3);
        // }
        // });

        HBox dinnerBox = new HBox(dinner, dinnercal, dinnerfield, dinnercalorie, space3, addFoodD, removeFoodd);
        dinnerBox.setPadding(new Insets(20, 0, 10, 40));
        VBox list3 = new VBox(listView3);
        dinnerBox.setSpacing(10);

        ScrollPane scrollPane3 = new ScrollPane(list3);
        scrollPane3.setFitToWidth(true);
        scrollPane3.getStyleClass().add("scroll-panedinner ");

        VBox innerVBoxb3 = new VBox(scrollPane3);
        innerVBoxb3.setPrefHeight(300);
        innerVBoxb3.setPrefWidth(100);

        VBox dinnervBox = new VBox(dinnerBox, innerVBoxb3);
        dinnervBox.setPrefWidth(200);
        dinnervBox.setPrefHeight(220);
        dinnervBox.setPadding(new Insets(20, 0, 20, 0));
        dinnervBox.getStyleClass().add("breakfast-box");
        VBox dVBox = new VBox(dinnervBox);
        dVBox.setPadding(new Insets(20, 0, 10, 0));

        // Button at the end of lbr
        Button submitButton = new Button("Submit Log");
        submitButton.setFont(Font.font("Montserrat", 20));
        submitButton.setPadding(new Insets(10, 20, 10, 20));
        submitButton.getStyleClass().add("rounded-login-button");
        submitButton.setOnMouseClicked(e -> {
            // Here you can use totalCalories as needed
            System.out.println("Total Calories: " + totalCalories);
        });

        Button backButton = new Button("Back");
        backButton.setFont(Font.font("Montserrat", 20));
        backButton.setPadding(new Insets(10, 60, 10, 20));
        backButton.getStyleClass().add("rounded-login-button");

        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                nav.navigateToDashboard(Login.loggedinUserName);
            }

        });

        // Right VBox
        VBox lbr = new VBox(calBox, bVBox, lVBox, dVBox);
        lbr.setPrefWidth(1030);
        lbr.setPrefHeight(820);
        lbr.setPadding(new Insets(10, 70, 0, 70));
        lbr.getStyleClass().add("right-box");

        // HBox to align the button to the right within the VBox
        HBox buttonBox = new HBox(10, submitButton, backButton);
        buttonBox.setPadding(new Insets(0, 90, 0, 0));
        buttonBox.setPrefWidth(Double.MAX_VALUE);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);

        // Add buttonBox to the VBox
        lbr.getChildren().add(buttonBox);

        HBox logbook = new HBox(lbl, lbr);
        logbook.setPadding(new Insets(0, 0, 0, 0));
        logbook.setStyle("-fx-background-color: #222831");

        // addFoodB.setOnMouseClicked(e -> {
        // String newItem = newbreakfastfield.getText();
        // String newCaloriesStr = breakfastcalorie.getText();
        // if (!newItem.isEmpty() && !newCaloriesStr.isEmpty()) {
        // int newCalories = Integer.parseInt(newCaloriesStr);
        // items1.add(newItem);
        // breakfastCalorieMap.put(newItem, newCalories); // Track item's calories
        // totalCalories += newCalories;
        // foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
        // breakfastCalories += newCalories;
        // breakfastcal.setText("(" + breakfastCalories + ")");
        // }
        // });

        // removeFoodB.setOnMouseClicked(e -> {
        // int selectedIndex = listView1.getSelectionModel().getSelectedIndex();
        // if (selectedIndex != -1) {
        // String selectedItem = listView1.getSelectionModel().getSelectedItem();
        // int caloriesToRemove = breakfastCalorieMap.getOrDefault(selectedItem, 0);
        // items1.remove(selectedIndex);
        // breakfastCalorieMap.remove(selectedItem); // Remove item from map
        // totalCalories -= caloriesToRemove;
        // foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
        // breakfastCalories -= caloriesToRemove;
        // breakfastcal.setText("(" + breakfastCalories + ")");
        // }
        // });

        addFoodB.setOnMouseClicked(e -> {
            String newItem1 = newbreakfastfield.getText();
            String calorieStr = breakfastcalorie.getText();
            if (!newItem1.isEmpty() && !calorieStr.isEmpty()) {
                try {
                    int calorie = Integer.parseInt(calorieStr);
                    items1.add(newItem1 + " (" + calorie + ")");
                    breakfastCalories += calorie;
                    totalCalories += calorie;
                    breakfastCalorieMap.put(newItem1, calorie);
                    foodcal.setText(Integer.toString(totalCalories));
                    breakfastcal.setText("(" + breakfastCalories + ")");
                    remainingCal = Integer.parseInt(goalcal.getText()) - totalCalories;
                    remaincal.setText(Integer.toString(remainingCal));
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid calorie input for breakfast.");
                }
                newbreakfastfield.clear();
                breakfastcalorie.clear();
            }
        });

        removeFoodB.setOnMouseClicked(e -> {
            String selectedItem1 = listView1.getSelectionModel().getSelectedItem();
            if (selectedItem1 != null) {
                items1.remove(selectedItem1);
                String[] parts = selectedItem1.split(" \\(");
                String foodItem = parts[0];
                if (breakfastCalorieMap.containsKey(foodItem)) {
                    int calorie = breakfastCalorieMap.get(foodItem);
                    breakfastCalories -= calorie;
                    totalCalories -= calorie;
                    breakfastCalorieMap.remove(foodItem);
                    foodcal.setText(Integer.toString(totalCalories));
                    breakfastcal.setText("(" + breakfastCalories + ")");
                    remainingCal = Integer.parseInt(goalcal.getText()) - totalCalories;
                    remaincal.setText(Integer.toString(remainingCal));
                }
            }
        });

        addFoodL.setOnMouseClicked(e -> {
            String newItem2 = newlunchfield.getText();
            String calorieStr = lcalorie.getText();
            if (!newItem2.isEmpty() && !calorieStr.isEmpty()) {
                try {
                    int calorie = Integer.parseInt(calorieStr);
                    items2.add(newItem2 + " (" + calorie + ")");
                    lunchCalories += calorie;
                    totalCalories += calorie;
                    lunchCalorieMap.put(newItem2, calorie);
                    foodcal.setText(Integer.toString(totalCalories));
                    lunchcal.setText("(" + lunchCalories + ")");
                    remainingCal = Integer.parseInt(goalcal.getText()) - totalCalories;
                    remaincal.setText(Integer.toString(remainingCal));
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid calorie input for lunch.");
                }
                newlunchfield.clear();
                lcalorie.clear();
            }
        });

        removeFoodl.setOnMouseClicked(e -> {
            String selectedItem2 = listView2.getSelectionModel().getSelectedItem();
            if (selectedItem2 != null) {
                items2.remove(selectedItem2);
                String[] parts = selectedItem2.split(" \\(");
                String foodItem = parts[0];
                if (lunchCalorieMap.containsKey(foodItem)) {
                    int calorie = lunchCalorieMap.get(foodItem);
                    lunchCalories -= calorie;
                    totalCalories -= calorie;
                    lunchCalorieMap.remove(foodItem);
                    foodcal.setText(Integer.toString(totalCalories));
                    lunchcal.setText("(" + lunchCalories + ")");
                }
            }
        });

        addFoodD.setOnMouseClicked(e -> {
            String newItem3 = dinnerfield.getText();
            String calorieStr = dinnercalorie.getText();
            if (!newItem3.isEmpty() && !calorieStr.isEmpty()) {
                try {
                    int calorie = Integer.parseInt(calorieStr);
                    items3.add(newItem3 + " (" + calorie + ")");
                    dinnerCalories += calorie;
                    totalCalories += calorie;
                    dinnerCalorieMap.put(newItem3, calorie);
                    foodcal.setText(Integer.toString(totalCalories));
                    dinnercal.setText("(" + dinnerCalories + ")");
                    remainingCal = Integer.parseInt(goalcal.getText()) - totalCalories;
                    remaincal.setText(Integer.toString(remainingCal));
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid calorie input for dinner.");
                }
                dinnerfield.clear();
                dinnercalorie.clear();
            }
        });

        removeFoodd.setOnMouseClicked(e -> {
            String selectedItem3 = listView3.getSelectionModel().getSelectedItem();
            if (selectedItem3 != null) {
                items3.remove(selectedItem3);
                String[] parts = selectedItem3.split(" \\(");
                String foodItem = parts[0];
                if (dinnerCalorieMap.containsKey(foodItem)) {
                    int calorie = dinnerCalorieMap.get(foodItem);
                    dinnerCalories -= calorie;
                    totalCalories -= calorie;
                    dinnerCalorieMap.remove(foodItem);
                    foodcal.setText(Integer.toString(totalCalories));
                    dinnercal.setText("(" + dinnerCalories + ")");
                }
            }
        });

        // addFoodD.setOnMouseClicked(e -> {
        // String newItem = dinnerfield.getText();
        // String newCaloriesStr = dinnercalorie.getText();
        // if (!newItem.isEmpty() && !newCaloriesStr.isEmpty()) {
        // int newCalories = Integer.parseInt(newCaloriesStr);
        // items3.add(newItem);
        // dinnerCalorieMap.put(newItem, newCalories); // Track item's calories
        // totalCalories += newCalories;
        // foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
        // dinnerCalories += newCalories;
        // dinnercal.setText("(" + dinnerCalories + ")");
        // }
        // });

        // removeFoodd.setOnMouseClicked(e -> {
        // int selectedIndex = listView3.getSelectionModel().getSelectedIndex();
        // if (selectedIndex != -1) {
        // String selectedItem = listView3.getSelectionModel().getSelectedItem();
        // int caloriesToRemove = dinnerCalorieMap.getOrDefault(selectedItem, 0);
        // items3.remove(selectedIndex);
        // dinnerCalorieMap.remove(selectedItem); // Remove item from map
        // totalCalories -= caloriesToRemove;
        // foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
        // dinnerCalories -= caloriesToRemove;
        // dinnercal.setText("(" + dinnerCalories + ")");
        // }
        // });

        submitButton.setOnMouseClicked(e -> {
            // Here you can use totalCalories as needed
            System.out.println("Total Calories: " + totalCalories);

            // Print breakfast items and calories
            System.out.println("Breakfast items:");
            for (Map.Entry<String, Integer> entry : breakfastCalorieMap.entrySet()) {
                System.out.println("Item: " + entry.getKey() + ", Calories: " + entry.getValue());
            }

            // Print lunch items and calories
            System.out.println("Lunch items:");
            for (Map.Entry<String, Integer> entry : lunchCalorieMap.entrySet()) {
                System.out.println("Item: " + entry.getKey() + ", Calories: " + entry.getValue());
            }

            // Print dinner items and calories
            System.out.println("Dinner items:");
            for (Map.Entry<String, Integer> entry : dinnerCalorieMap.entrySet()) {
                System.out.println("Item: " + entry.getKey() + ", Calories: " + entry.getValue());
            }

            Diet diet = new Diet(breakfastCalorieMap, lunchCalorieMap, dinnerCalorieMap);
            // diet.setTimestamp("2021-08-01T08:00:00Z"); //hardcoded timestamp
            try {
                DataService.addDiet(Login.loggedinUserName, diet);
            } catch (ExecutionException e1) {

                e1.printStackTrace();
            } catch (InterruptedException e1) {

                e1.printStackTrace();
            }
            items1.clear();
            items2.clear();
            items3.clear();
            totalCalories = 0;
            remainingCal = Integer.parseInt(goalcal.getText()); // Reset remainingCal to goalcal value
            foodcal.setText(Integer.toString(totalCalories));
            remaincal.setText(Integer.toString(remainingCal));

        });

        group = new Group(logbook);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public ScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public void setScrollPane1(ScrollPane scrollPane1) {
        this.scrollPane1 = scrollPane1;
    }

    public ScrollPane getScrollPane2() {
        return scrollPane2;
    }

    public void setScrollPane2(ScrollPane scrollPane2) {
        this.scrollPane2 = scrollPane2;
    }

    public ScrollPane getScrollPane3() {
        return scrollPane3;
    }

    public void setScrollPane3(ScrollPane scrollPane3) {
        this.scrollPane3 = scrollPane3;
    }

}
