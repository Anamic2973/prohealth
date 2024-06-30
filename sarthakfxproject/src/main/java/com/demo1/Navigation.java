package com.demo1;

import com.demo1.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigation extends Application{

    private Stage pr;
    private Scene loginScene,q1Scene,q2Scene,q3Scene,q4Scene,q5Scene,q6Scene,q7Scene,q8Scene,q9Scene,q10Scene,q11Scene;

    //declare page instances
    private Login login;
    private Questionire1 que1;
    private Questionire2 que2;
    private Questionire3 que3;
    private Questionire4 que4;
    private Questionire5 que5;
    private Questionire6 que6;
    private Questionire7 que7;
    private Questionire8 que8;
    private Questionire9 que9;
    private Questionire10 que10;
    private Questionire11 que11;

    @Override
    public void start(Stage pr) throws Exception {
        this.pr = pr;

        //initilize pages instances
        login = new Login(this);
        que1 = new Questionire1(this);
        que2 = new Questionire2(this);
        que3 = new Questionire3(this);
        que4 = new Questionire4(this);
        que5 = new Questionire5(this);
        que6 = new Questionire6(this);
        que7 = new Questionire7(this);
        que8 = new Questionire8(this);
        que9 = new Questionire9(this);
        que10 = new Questionire10(this);
        que11 = new Questionire11(this);

        //scenes for each page
        //loginScene
        loginScene = new Scene(login.getGroup(),2000,1000);
        loginScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); //exception here

        //q1Scene
        q1Scene = new Scene(que1.getGroup(),2000,1000); 
        q1Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q2Scene
        q2Scene = new Scene(que2.getGroup(),2000,1000); 
        q2Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q3Scene
        q3Scene = new Scene(que3.getGroup(),2000,1000); 
        q3Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q4Scene
        q4Scene = new Scene(que4.getGroup(),2000,1000); 
        q4Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q5Scene
        q5Scene = new Scene(que5.getGroup(),2000,1000); 
        q5Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q6Scene
        q6Scene = new Scene(que6.getGroup(),2000,1000); 
        q6Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q7Scene
        q7Scene = new Scene(que7.getGroup(),2000,1000); 
        q7Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q8Scene
        q8Scene = new Scene(que8.getGroup(),2000,1000); 
        q8Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q9Scene
        q9Scene = new Scene(que9.getGroup(),2000,1000); 
        q9Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q10Scene
        q10Scene = new Scene(que10.getGroup(),2000,1000); 
        q10Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //q11Scene
        q11Scene = new Scene(que11.getGroup(),2000,1000); 
        q11Scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());


        //setting the initial scene to login
        pr.setScene(loginScene);
        pr.setTitle("ProHealth");
        pr.show();
    }

    //method to navigate to home page from login(for time being navigating to que1 page)
    public void navigateToQue1(){
        login.setEmailTextFieldValue(login.getEmailTextFieldValue());
        login.setpsTextFieldValue(login.getpsTextFieldValue());
        que1.setq1TextFieldValue(que1.getq1TextFieldValue());
        pr.setScene(q1Scene);
    }

    //method to navigate to q1 to q2
    public void navigateToQue2(){
        que1.setq1TextFieldValue(que1.getq1TextFieldValue());
        que3.setRadioButton1(que3.getRadioButton1());
        que3.setRadioButton2(que3.getRadioButton2());
        pr.setScene(q2Scene);
    }

    public void navigateToQue3(){
        que2.setQ2TextField(que2.getQ2TextField());
        que4.setHeightTextField(que4.getHeightTextField());
        que4.setWeightTextField(que4.getWeightTextField());
        pr.setScene(q3Scene);
    }

    public void navigateToQue4(){
        que3.setRadioButton1(que3.getRadioButton1());
        que3.setRadioButton2(que3.getRadioButton2());
        que5.setRadioButton1(que5.getRadioButton1());
        que5.setRadioButton2(que5.getRadioButton2());
        que5.setRadioButton3(que5.getRadioButton3());
        que5.setRadioButton4(que5.getRadioButton4());
        pr.setScene(q4Scene);
    }

    public void navigateToQue5(){
        que4.setHeightTextField(que4.getHeightTextField());
        que4.setWeightTextField(que4.getWeightTextField());
        que6.setCheckBox(que6.getCheckBox());
        pr.setScene(q5Scene);
    }

    public void navigateToQue6(){
        que5.setRadioButton1(que5.getRadioButton1());
        que5.setRadioButton2(que5.getRadioButton2());
        que5.setRadioButton3(que5.getRadioButton3());
        que5.setRadioButton4(que5.getRadioButton4());
        que7.setRadioButton1(que7.getRadioButton1());
        que7.setRadioButton2(que7.getRadioButton2());
        que7.setRadioButton3(que7.getRadioButton3());
        pr.setScene(q6Scene);
    }

    public void navigateToQue7(){
        que6.setCheckBox(que6.getCheckBox());
        que8.setCheckBox(que8.getCheckBox());
        pr.setScene(q7Scene);
    }

    public void navigateToQue8(){
        que7.setRadioButton1(que7.getRadioButton1());
        que7.setRadioButton2(que7.getRadioButton2());
        que7.setRadioButton3(que7.getRadioButton3());
        que9.setRadioButton1(que9.getRadioButton1());
        que9.setRadioButton2(que9.getRadioButton2());
        pr.setScene(q8Scene);
    }

    public void navigateToQue9(){
        que8.setCheckBox(que8.getCheckBox());
        que10.setRadioButton1(que10.getRadioButton1());
        que10.setRadioButton2(que10.getRadioButton2());
        que10.setRadioButton3(que10.getRadioButton3());
        que10.setRadioButton4(que10.getRadioButton4());
        pr.setScene(q9Scene);
    }

    public void navigateToQue10(){
        que9.setRadioButton1(que9.getRadioButton1());
        que9.setRadioButton2(que9.getRadioButton2());
        que11.setRadioButton1(que11.getRadioButton1());
        que11.setRadioButton2(que11.getRadioButton2());
        pr.setScene(q10Scene);
    }

    public void navigateToQue11(){
        que10.setRadioButton1(que10.getRadioButton1());
        que10.setRadioButton2(que10.getRadioButton2());
        que10.setRadioButton3(que10.getRadioButton3());
        que10.setRadioButton4(que10.getRadioButton4());
        pr.setScene(q11Scene);
    }
}
