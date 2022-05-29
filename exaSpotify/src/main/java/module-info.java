module com.example.exaspotify {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires javafx.graphics;
    requires mysql.connector.java;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires annotations;

    opens com.example.exaspotify to javafx.fxml;
    exports com.example.exaspotify;
}