package com.example.exaspotify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



public class Main extends Application {

       public void start(Stage stage) throws IOException {
        FXMLLoader inicio = new FXMLLoader(Main.class.getResource("inicioSesion.fxml"));
        Scene scene = new Scene(inicio.load(), 550, 450);
        stage.setTitle("Inicio de sesión");
        stage.setScene(scene);
        stage.show();
         }
    public static void main(String[] args) {
        launch(args);
    }
}