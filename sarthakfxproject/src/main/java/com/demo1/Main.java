package com.demo1;

import javafx.stage.Stage;

import com.demo1.service.Navigation;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Application.launch(Navigation.class, args);
    }

    public void start(Stage primaryStage) throws Exception {

    }

}