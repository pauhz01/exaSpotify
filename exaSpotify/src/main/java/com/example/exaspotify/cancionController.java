package com.example.exaspotify;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class cancionController{

    @FXML
    private Label cantante;



    @FXML
    private Label titulo;

    public void setData(Cancion cancion){
        titulo.setText(cancion.getTitulo());
        cantante.setText(cancion.getCantante());
        }

    }

