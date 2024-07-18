package com.demo1;

import com.demo1.navigation.Navigation;

import javafx.stage.Stage;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Application.launch(Navigation.class, args);
    }

    public void start(Stage primaryStage) throws Exception {

    }

}

/*
 * import java.io.IOException;
 * import java.util.HashMap;
 * import java.util.Map;
 * import java.util.concurrent.ExecutionException;
 * 
 * import com.demo1.firebaseConfig.DataService;
 * import com.demo1.nestedCollection.Diet;
 * import com.demo1.nestedCollection.FirestoreCRUD;
 * import com.demo1.nestedCollection.FirestoreService;
 * import com.demo1.nestedCollection.User;
 * import com.demo1.nestedCollection.Workout;
 * 
 * public class Main {
 * public static void main(String[] args) {
 * 
 * System.out.println("Start Main");
 * 
 * try {
 * FirestoreService.initialize();
 * 
 * User user = new User();
 * user.setUsername("christain_harper");
 * user.setRole("admin");
 * 
 * FirestoreCRUD.createUser(user);
 * 
 * // Add workout
 * Workout workout = new Workout();
 * workout.setTimestamp("2021-07-01T10:00:00Z");
 * workout.setExercise("Running");
 * workout.setCalories(300);
 * DataService.addWorkout(user.getUsername(), workout);
 * 
 * // Add diet
 * Diet diet = new Diet();
 * diet.setTimestamp("2021-07-01T08:00:00Z");
 * Map<String, Integer> breakfast = new HashMap<>();
 * breakfast.put("Eggs", 150);
 * diet.setBreakfast(breakfast);
 * DataService.addDiet(user.getUsername(), diet);
 * 
 * } catch (IOException | ExecutionException | InterruptedException e) {
 * e.printStackTrace();
 * }
 * 
 * System.out.println("End Main");
 * }
 * }
 */
