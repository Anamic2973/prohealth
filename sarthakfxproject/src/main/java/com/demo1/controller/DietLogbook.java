package com.demo1.controller;

import com.demo1.service.Navigation;

import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class DietLogbook{
    
    private Navigation nav;
    private Group group;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane2;
    private ScrollPane scrollPane3;

    public DietLogbook(Navigation nav){
        this.nav = nav;
        initialize();
    }

    private int totalCalories = 0;
    private int breakfastCalories = 0;
    private int lunchCalories = 0;
    private int dinnerCalories = 0;

    private Map<String, Integer> breakfastCalorieMap = new HashMap<>();
    private Map<String, Integer> lunchCalorieMap = new HashMap<>();
    private Map<String, Integer> dinnerCalorieMap = new HashMap<>();

    public void initialize() {
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
        ObservableList<String> items2 = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5");

        listView2.setItems(items2);

        // list3
        ListView<String> listView3 = new ListView<>();
        listView3.getStyleClass().add("list-view");

        // Create an ObservableList of items
        ObservableList<String> items3 = FXCollections.observableArrayList(
                "10", "30", "40", "50", "60");

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

        // Operations
        Label sub = new Label("-");
        sub.setPadding(new Insets(0, 20, 0, 20));
        sub.setFont(Font.font("Montserrat", 20));

        Label add = new Label("+");
        add.setPadding(new Insets(0, 20, 0, 20));
        add.setFont(Font.font("Montserrat", 20));

        Label equal = new Label("=");
        equal.setPadding(new Insets(0, 20, 0, 20));
        equal.setFont(Font.font("Montserrat", 20));

        // Calories goal
        Label goalcal = new Label("2080");
        goalcal.setFont(Font.font("Montserrat", 20));
        Label goal = new Label("Goal");
        goal.setFont(Font.font("Montserrat", 20));
        VBox vbgoal = new VBox(goalcal, goal);
        vbgoal.setPadding(new Insets(0, 0, 0, 80));

        // Food cal
        Label foodcal = new Label(Integer.toString(totalCalories));
        foodcal.setFont(Font.font("Montserrat", 20));
        Label food = new Label("Food");
        food.setFont(Font.font("Montserrat", 20));
        VBox vbfood = new VBox(foodcal, food);
        vbfood.setPadding(new Insets(0, 0, 0, 20));

        // Exercise cal
        Label exercal = new Label("0");
        exercal.setFont(Font.font("Montserrat", 20));
        Label exercise = new Label("Exercise");
        exercise.setFont(Font.font("Montserrat", 20));
        VBox exerfood = new VBox(exercal, exercise);
        exerfood.setPadding(new Insets(0, 0, 0, 20));

        // Remaining cal
        Label remaincal = new Label("80");
        remaincal.setFont(Font.font("Montserrat", 20));
        Label remaining = new Label("Remaining");
        remaining.setFont(Font.font("Montserrat", 20));
        VBox remainfood = new VBox(remaincal, remaining);
        remainfood.setPadding(new Insets(0, 0, 0, 20));

        // Calorie calculation HBox
        HBox calBox = new HBox(vbgoal, sub, vbfood, add, exerfood, equal, remainfood);
        calBox.setPadding(new Insets(70, 60, 20, 10));
        calBox.getStyleClass().add("cal-box");

        VBox calVBox = new VBox(calBox);
        calVBox.setPadding(new Insets(0, 0, 20, 0));

        // Breakfast
        Label breakfast = new Label("Breakfast");
        breakfast.setFont(Font.font("Montserrat", 20));
        
        Label breakfastcal = new Label("(144)");
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
        addFoodB.setPadding(new Insets(0, 0, 0, 30));
        // addFoodB.setOnMouseClicked(e -> {
        // String newItem1 = newbreakfastfield.getText();
        // if (!newItem1.isEmpty()) {
        // items1.add(newItem1);
        // newbreakfastfield.clear();
        // }
        // });
        
        Label removeFoodB = new Label("Remove ");
        removeFoodB.setFont(Font.font("Montserrat", 20));
        removeFoodB.setPadding(new Insets(0, 0, 0, 10));
        // removeFoodB.setOnMouseClicked(e -> {

        // String selectedItem1 = listView1.getSelectionModel().getSelectedItem();
        // if (selectedItem1 != null) {
        // items1.remove(selectedItem1);
        // }
        // });

        HBox breakf = new HBox(breakfast, breakfastcal, newbreakfastfield, breakfastcalorie, addFoodB, removeFoodB);
        breakf.setPadding(new Insets(20, 0, 10, 0));
        // VBox list1calbVBox = new VBox(listView1cal);
        // list1calbVBox.setPadding(new Insets(0, 0, 0, 50));
        VBox list1 = new VBox(listView1);

        ScrollPane scrollPane1 = new ScrollPane(list1);
        scrollPane1.setFitToWidth(true);
        scrollPane1.getStyleClass().add("scroll-panebreakfast");

        VBox innerVBoxb1 = new VBox(scrollPane1);
        innerVBoxb1.setPrefHeight(300);
        innerVBoxb1.setPrefWidth(100);

        VBox breakfastBox = new VBox(breakf, horizontalline1light, innerVBoxb1);
        breakfastBox.setPrefWidth(300);
        breakfastBox.setPrefHeight(220);
        breakfastBox.setPadding(new Insets(30, 0, 20, 0));
        breakfastBox.getStyleClass().add("breakfast-box");
        
        VBox bVBox = new VBox(breakfastBox);
        bVBox.setPadding(new Insets(20, 0, 0, 0));

        // Lunch
        Label lunch = new Label("Lunch");
        lunch.setFont(Font.font("Montserrat", 20));
        
        Label lunchcal = new Label("(144)");
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
        addFoodL.setFont(Font.font("Montserrat", 20));
        addFoodL.setPadding(new Insets(0, 0, 0, 30));
        // addFoodB.setOnMouseClicked(e -> {
        // String newItem2 = newlunchfield.getText();
        // if (!newItem2.isEmpty()) {
        // items2.add(newItem2);
        // newlunchfield.clear();
        // }
        // });

        Label removeFoodl = new Label("Remove ");
        removeFoodl.setFont(Font.font("Montserrat", 20));
        removeFoodl.setPadding(new Insets(0, 0, 0, 10));
        // removeFoodB.setOnMouseClicked(e -> {

        // String selectedItem2 = listView2.getSelectionModel().getSelectedItem();
        // if (selectedItem2 != null) {
        // items2.remove(selectedItem2);
        // }
        // });

        HBox lunchHBox = new HBox(lunch, lunchcal, newlunchfield, lcalorie, addFoodL, removeFoodl);
        lunchHBox.setPadding(new Insets(20, 0, 10, 40));

        VBox list2 = new VBox(listView2);

        ScrollPane scrollPane2 = new ScrollPane(list2);
        scrollPane2.setFitToWidth(true);
        scrollPane2.getStyleClass().add("scroll-panelunch");

        VBox innerVBoxb2 = new VBox(scrollPane2);
        innerVBoxb2.setPrefHeight(300);
        innerVBoxb2.setPrefWidth(100);

        VBox lunchvBox = new VBox(lunchHBox, horizontalline2light, innerVBoxb2);
        lunchvBox.setPrefWidth(200);
        lunchvBox.setPrefHeight(220);
        lunchvBox.setPadding(new Insets(20, 0, 20, 0));
        lunchvBox.getStyleClass().add("breakfast-box");
        
        VBox lVBox = new VBox(lunchvBox);
        lVBox.setPadding(new Insets(20, 0, 0, 0));

        // Dinner
        Label dinner = new Label("Dinner");
        dinner.setFont(Font.font("Montserrat", 20));
        
        Label dinnercal = new Label("(144)");
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
        addFoodD.setFont(Font.font("Montserrat", 20));
        addFoodD.setPadding(new Insets(0, 0, 0, 30));
        // addFoodD.setOnMouseClicked(e -> {
        // String newItem3 = dinnerfield.getText();
        // if (!newItem3.isEmpty()) {
        // items3.add(newItem3);
        // dinnerfield.clear();
        // }
        // });
        
        Label removeFoodd = new Label("Remove ");
        removeFoodd.setFont(Font.font("Montserrat", 20));
        removeFoodd.setPadding(new Insets(0, 0, 0, 10));
        // removeFoodd.setOnMouseClicked(e -> {
        // String selectedItem3 = listView3.getSelectionModel().getSelectedItem();
        // if (selectedItem3 != null) {
        // items3.remove(selectedItem3);
        // }
        // });

        HBox dinnerBox = new HBox(dinner, dinnercal, dinnerfield, dinnercalorie, addFoodD, removeFoodd);
        dinnerBox.setPadding(new Insets(20, 0, 10, 40));
        
        VBox list3 = new VBox(listView3);

        ScrollPane scrollPane3 = new ScrollPane(list3);
        scrollPane3.setFitToWidth(true);
        scrollPane3.getStyleClass().add("scroll-panedinner ");

        VBox innerVBoxb3 = new VBox(scrollPane3);
        innerVBoxb3.setPrefHeight(300);
        innerVBoxb3.setPrefWidth(100);

        VBox dinnervBox = new VBox(dinnerBox, horizontalline3light, innerVBoxb3);
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

        Button backButton = new Button("Back");
        backButton.setFont(Font.font("Montserrat", 20));
        backButton.setPadding(new Insets(10, 60, 10, 20));
        backButton.getStyleClass().add("rounded-login-button");

        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                nav.navigateToDashboard();
            }
            
        });


        // Right VBox
        VBox lbr = new VBox(calBox, bVBox, lVBox,
                dVBox);
        lbr.setPrefWidth(1030);
        lbr.setPrefHeight(820);
        lbr.setPadding(new Insets(20, 50, 0, 150));
        lbr.getStyleClass().add("right-box");

        // HBox to align the button to the right within the VBox
        HBox buttonBox = new HBox(submitButton, backButton);
        buttonBox.setPadding(new Insets(20, 0, 0, 0));
        buttonBox.setPrefWidth(Double.MAX_VALUE);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);

        // Add buttonBox to the VBox
        lbr.getChildren().add(buttonBox);

        HBox logbook = new HBox(lbl, lbr);
        logbook.setPadding(new Insets(0, 0, 0, 0));
        addFoodB.setOnMouseClicked(e -> {
            String newItem = newbreakfastfield.getText();
            String newCaloriesStr = breakfastcalorie.getText();
            if (!newItem.isEmpty() && !newCaloriesStr.isEmpty()) {
                int newCalories = Integer.parseInt(newCaloriesStr);
                items1.add(newItem);
                breakfastCalorieMap.put(newItem, newCalories); // Track item's calories
                totalCalories += newCalories;
                foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
                breakfastCalories += newCalories;
                breakfastcal.setText("(" + breakfastCalories + ")");
            }
        });

        removeFoodB.setOnMouseClicked(e -> {
            int selectedIndex = listView1.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedItem = listView1.getSelectionModel().getSelectedItem();
                int caloriesToRemove = breakfastCalorieMap.getOrDefault(selectedItem, 0);
                items1.remove(selectedIndex);
                breakfastCalorieMap.remove(selectedItem); // Remove item from map
                totalCalories -= caloriesToRemove;
                foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
                breakfastCalories -= caloriesToRemove;
                breakfastcal.setText("(" + breakfastCalories + ")");
            }
        });

        addFoodL.setOnMouseClicked(e -> {
            String newItem = newlunchfield.getText();
            String newCaloriesStr = lunchcal.getText();
            if (!newItem.isEmpty() && !newCaloriesStr.isEmpty()) {
                int newCalories = Integer.parseInt(newCaloriesStr);
                items2.add(newItem);
                lunchCalorieMap.put(newItem, newCalories); // Track item's calories
                totalCalories += newCalories;
                foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
                lunchCalories += newCalories;
                lunchcal.setText("(" + lunchCalories + ")");
            }
        });

        removeFoodl.setOnMouseClicked(e -> {
            int selectedIndex = listView2.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedItem = listView2.getSelectionModel().getSelectedItem();
                int caloriesToRemove = lunchCalorieMap.getOrDefault(selectedItem, 0);
                items2.remove(selectedIndex);
                lunchCalorieMap.remove(selectedItem); // Remove item from map
                totalCalories -= caloriesToRemove;
                foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
                lunchCalories -= caloriesToRemove;
                lunchcal.setText("(" + lunchCalories + ")");
            }
        });

        addFoodD.setOnMouseClicked(e -> {
            String newItem = dinnerfield.getText();
            String newCaloriesStr = dinnercalorie.getText();
            if (!newItem.isEmpty() && !newCaloriesStr.isEmpty()) {
                int newCalories = Integer.parseInt(newCaloriesStr);
                items3.add(newItem);
                dinnerCalorieMap.put(newItem, newCalories); // Track item's calories
                totalCalories += newCalories;
                foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
                dinnerCalories += newCalories;
                dinnercal.setText("(" + dinnerCalories + ")");
            }
        });

        removeFoodd.setOnMouseClicked(e -> {
            int selectedIndex = listView3.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedItem = listView3.getSelectionModel().getSelectedItem();
                int caloriesToRemove = dinnerCalorieMap.getOrDefault(selectedItem, 0);
                items3.remove(selectedIndex);
                dinnerCalorieMap.remove(selectedItem); // Remove item from map
                totalCalories -= caloriesToRemove;
                foodcal.setText(Integer.toString(totalCalories)); // Update foodcal label
                dinnerCalories -= caloriesToRemove;
                dinnercal.setText("(" + dinnerCalories + ")");
            }
        });

        submitButton.setOnMouseClicked(e -> {
            // Here you can use totalCalories as needed
            System.out.println("Total Calories: " + totalCalories);
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
