package com.example.exaspotify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;


public class registroController extends spotifyController {

    @FXML
    private TextField usu;
    @FXML
    private TextField mail;
    @FXML
    private PasswordField pwd;
    @FXML
    private DatePicker fecha;
    @FXML
    private Button desesion;
    @FXML
    private Button registro;

    public void registro (ActionEvent event){
        Connexion conectar = new Connexion();
        Connection ahora = conectar.getConnection();
        String query = "INSERT INTO usuario ( username,password,email,fecha_nacimiento) values ('"+usu.getText()+"','"+pwd.getText()+"','"+mail.getText()+"','"+fecha.getValue()+"')";
        try {
            if (usu.getText().equals("")){
                JFrame error = new JFrame();
                JOptionPane.showMessageDialog(error,"Nombre de usuario vacio");
            } else if (pwd.getText().equals("")) {
                JFrame error = new JFrame();
                JOptionPane.showMessageDialog(error,"Contraseña vacia");
            } else if (mail.getText().equals("")) {
                JFrame error = new JFrame();
                JOptionPane.showMessageDialog(error,"Correo vacio");
            } else if (fecha.getValue().equals("")){
                JFrame error = new JFrame();
                JOptionPane.showMessageDialog(error,"La fecha de nacimineto esta vacia");
            } else {
                Statement statement = ahora.createStatement();
                statement.execute(query);
                JFrame bienvenida = new JFrame();
                JOptionPane.showMessageDialog(bienvenida,"Gracias por registarte con nosotros.Por favor inicie sesion");
                abreInicio();
                Stage myStage = (Stage) this.registro.getScene().getWindow();
                myStage.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void iniciarSesion (ActionEvent event) throws IOException {
        abreInicio();
        Stage myStage = (Stage) this.desesion.getScene().getWindow();
        myStage.close();
    }
}
