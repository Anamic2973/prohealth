package com.demo1.navigation;

import com.demo1.view.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Navigation extends Application {

    private Stage pr;
    private Scene loginScene, q1Scene, q2Scene, q3Scene, q4Scene, q5Scene, q6Scene, signupScene, workoutLogScene,
            dashboardScene, dietLogBookScene, historyScene, profileScene, Aboutscene, recipiescScene;

    // declare page instances, i.e. create obj of pages
    private Login login;
    private Questionire1 que1;
    private Questionire2 que2;
    private Questionire3 que3;
    private Questionire4 que4;
    private Questionire5 que5;
    private Questionire6 que6;
    private SignUp signup;
    private WorkoutLog workoutLog;
    private Dashboard dashboard;
    private DietLogbook dietLogbook;
    private History history;
    private Profile profile;
    private About About;
    private Recipies Recipes;
    public static String LogUsern;

    @Override
    public void start(Stage pr) throws Exception {
        this.pr = pr;

        // initilize pages instances
        login = new Login(this);
        que1 = new Questionire1(this);
        que2 = new Questionire2(this);
        que3 = new Questionire3(this);
        que4 = new Questionire4(this);
        que5 = new Questionire5(this);
        que6 = new Questionire6(this);
        signup = new SignUp(this);
        workoutLog = new WorkoutLog(this);

        dietLogbook = new DietLogbook(this);
        Recipes = new Recipies(this);

        About = new About(this);

        // scenes for each page
        // loginScene
        loginScene = new Scene(login.getGroup(), 1500, 1000);
        loginScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); // exception here

        // q1Scene
        q1Scene = new Scene(que1.getGroup(), 1500, 1000);
        q1Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // q2Scene
        q2Scene = new Scene(que2.getGroup(), 1500, 1000);
        q2Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // q3Scene
        q3Scene = new Scene(que3.getGroup(), 1500, 1000);
        q3Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // q4Scene
        q4Scene = new Scene(que4.getGroup(), 1500, 1000);
        q4Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // q5Scene
        q5Scene = new Scene(que5.getGroup(), 1500, 1000);
        q5Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // q6Scene
        q6Scene = new Scene(que6.getGroup(), 1500, 1000);
        q6Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // signupScene
        signupScene = new Scene(signup.getGroup(), 1500, 1000);
        signupScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // workoutLogScene
        workoutLogScene = new Scene(workoutLog.getGroup(), 1500, 1000);
        workoutLogScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // dietLogBookScene
        dietLogBookScene = new Scene(dietLogbook.getGroup(), 1500, 1000);
        dietLogBookScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // dashboardScene

        // profileScene
        // profileScene = new Scene(profile.getGroup(), 1500, 1000);
        // profileScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        Aboutscene = new Scene(About.getGroup(), 1500, 1000);
        Aboutscene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        recipiescScene = new Scene(Recipes.getGroup(), 1500, 1000);
        recipiescScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // setting the initial scene to login
        pr.setScene(loginScene);
        pr.setTitle("ProHealth");
        pr.getIcons().add(new Image("images/icon_c2w.png"));

        pr.show();
    }

    public void navitoabout() {
        pr.setScene(Aboutscene);

    }

    public void navigateToDashboard(String username) {

        dashboard = new Dashboard(this, username);
        Navigation.LogUsern = username;
        dashboardScene = new Scene(dashboard.getGroup(), 1500, 1000);
        dashboardScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        pr.setScene(dashboardScene);

    }

    public void navigatetoHistory(String username) {
        history = new History(this, username);
        // historyScene
        Navigation.LogUsern = username;
        // history.setUserName(username);
        historyScene = new Scene(history.getGroup(), 1500, 1000);
        historyScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        System.out.println("nav to hist " + LogUsern);
        pr.setScene(historyScene);
    }

    public void navigateToSignup() {
        pr.setScene(signupScene);
    }

    public void navigateTorecipie() {
        pr.setScene(recipiescScene);
    }

    // method to navigate que1 page
    public void navigateToQue1() {
        login.setEmailTextFieldValue(login.getEmailTextFieldValue());
        login.setpsTextFieldValue(login.getpsTextFieldValue());
        que1.setq1TextFieldValue(que1.getq1TextFieldValue());
        pr.setScene(q1Scene);
    }

    // method to navigate to q1 to q2
    public void navigateToQue2() {
        que1.setq1TextFieldValue(que1.getq1TextFieldValue());
        // que3.setRadioButton1(que3.getRadioButton1());
        // que3.setRadioButton2(que3.getRadioButton2());
        pr.setScene(q2Scene);
    }

    public void navigateToQue3() {
        que2.setQ2TextField(que2.getQ2TextField());
        que4.setHeightTextField(que4.getHeightTextField());

        pr.setScene(q3Scene);
    }

    public void navigateToQue4() {
        // que3.setRadioButton1(que3.getRadioButton1());
        // que3.setRadioButton2(que3.getRadioButton2());
        que5.setRadioButton1(que5.getRadioButton1());
        que5.setRadioButton2(que5.getRadioButton2());
        que5.setRadioButton3(que5.getRadioButton3());
        que5.setRadioButton4(que5.getRadioButton4());
        que5.setWeightTextField(que5.getWeightTextField());

        pr.setScene(q4Scene);
    }

    public void navigateToQue5() {
        que4.setHeightTextField(que4.getHeightTextField());
        que5.setWeightTextField(que5.getWeightTextField());
        que6.setGoalsfield(que6.getGoalsfield());
        pr.setScene(q5Scene);
    }

    public void navigateToQue6() {
        que5.setRadioButton1(que5.getRadioButton1());
        que5.setRadioButton2(que5.getRadioButton2());
        que5.setRadioButton3(que5.getRadioButton3());
        que5.setRadioButton4(que5.getRadioButton4());
        pr.setScene(q6Scene);
    }

    public void navigateToWorkoutLog() {
        workoutLog.setCb1(workoutLog.getCb1());
        workoutLog.setCb2(workoutLog.getCb2());
        workoutLog.setCb3(workoutLog.getCb3());
        workoutLog.setCb4(workoutLog.getCb4());
        workoutLog.setCb5(workoutLog.getCb5());
        workoutLog.setCb6(workoutLog.getCb6());
        workoutLog.setCb7(workoutLog.getCb7());
        workoutLog.setScrollPane2(workoutLog.getScrollPane2());
        pr.setScene(workoutLogScene);
    }

    public void navigateToDietLogBook() {
        dietLogbook.setScrollPane1(dietLogbook.getScrollPane1());
        dietLogbook.setScrollPane2(dietLogbook.getScrollPane2());
        dietLogbook.setScrollPane3(dietLogbook.getScrollPane3());
        pr.setScene(dietLogBookScene);
    }

    public void navigatetologin() {
        pr.setScene(loginScene);
    }

    public void navigateToProfile(String username) {
        profile = new Profile(this, username);
        Navigation.LogUsern = username;

        profileScene = new Scene(profile.getGroup(), 1500, 1000);
        profileScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        pr.setScene(profileScene);
    }
}
