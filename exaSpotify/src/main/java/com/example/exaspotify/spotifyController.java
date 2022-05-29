package com.example.exaspotify;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.sql.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
public class spotifyController  {
    @FXML
    private Button salir;
    @FXML
    private Label userName;
    @FXML
    private HBox recientes;
    @FXML
    private HBox favoritas;
    @FXML
    private Button btnLogin;
    @FXML
    public TextField uInicio ;
    @FXML
    private PasswordField pInicio;
    @FXML
    private Button registrate;


    List<Cancion> recientesC;
    List<Cancion> favoritasC;
    //String usu = String.valueOf(uInicio.selectedTextProperty());
    public void isesion (ActionEvent event){
        Connexion conectar = new Connexion();
        Connection ahora = conectar.getConnection();
        String query = "SELECT username,password from usuario WHERE username= '"+uInicio.getText()+"' AND password ='"+pInicio.getText()+"'";
        try {
            Statement statement = ahora.createStatement();
            try (ResultSet queryOut = statement.executeQuery(query)){
                if (queryOut.next()) {
                    abrePrincipal();
                    Stage myStage = (Stage) this.btnLogin.getScene().getWindow();
                    myStage.close();
                }  else {
                    JFrame error = new JFrame();
                    JOptionPane.showMessageDialog(error,"Nombre de usuario o contraseña incorrecta");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void registrate (ActionEvent event) throws IOException {
        abreRegistro();
        Stage myStage = (Stage) this.registrate.getScene().getWindow();
        myStage.close();
    }


    public void abrePrincipal() throws IOException{
        FXMLLoader principal = new FXMLLoader(getClass().getResource("spotify.fxml"));
        Stage stage = new Stage();
        Parent root = principal.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Spotify");
        stage.show();
    }
    public void abreInicio () throws IOException{
        FXMLLoader inicio = new FXMLLoader(getClass().getResource("inicioSesion.fxml"));
        Parent root = inicio.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Inicio de sesion");
        stage.show();

    }
    public void abreRegistro() throws IOException{
        FXMLLoader registro = new FXMLLoader(getClass().getResource("registro.fxml"));
        Parent root = registro.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Bienvenido al mundo de la música");
        stage.show();
    }
    public void cancionesFavoritas () {
        try {
            favoritasC = new ArrayList<>(getFavoritasC());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            for (Cancion cancion : favoritasC) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation((getClass().getResource("cancion.fxml")));
                VBox vBox = fxmlLoader.load();
                cancionController prueba = fxmlLoader.getController();
                prueba.setData(cancion);
                favoritas.getChildren().add(vBox);
               // System.out.println(uInicio.get);
            }
        }catch (IOException e) {
            e.printStackTrace();

        }

    }

    public   List<Cancion> getFavoritasC () throws SQLException {
        List <Cancion> ls = new ArrayList<>();
        Connexion conectar = new Connexion();
        Connection ahora = conectar.getConnection();
        String queryCancion ="SELECT t1.titulo FROM cancion t1 inner JOIN album t2 ON t1.album_id = t2.id inner JOIN artista t3 ON t2.artista_id = t3.id inner join guarda_cancion t4 on t4.cancion_id =  t1.id inner join usuario t5 on  t4.usuario_id = t5.id and t5.username = 'antonio'";
        String queryArtista = "SELECT t3.nombre FROM cancion t1 inner JOIN album t2 ON t1.album_id = t2.id inner JOIN artista t3 ON t2.artista_id = t3.id inner join guarda_cancion t4 on t4.cancion_id =  t1.id inner join usuario t5 on  t4.usuario_id = t5.id and t5.username = 'antonio'";

        Statement statementCancion =ahora.createStatement();
        Statement statementArtista =ahora.createStatement();

        ResultSet titulo = statementCancion.executeQuery(queryCancion);
        ResultSet artista = statementArtista.executeQuery(queryArtista);

        while (titulo.next() && artista.next()){
            Cancion cancion = new Cancion();
            cancion.setTitulo(titulo.getString(1));
            cancion.setCantante(artista.getString(1));
            ls.add(cancion);
        }
        return ls;
    }

    public  void iniciando () throws IOException {
        abreInicio();
        Stage myStage = (Stage) this.salir.getScene().getWindow();
        myStage.close();
    }


}

