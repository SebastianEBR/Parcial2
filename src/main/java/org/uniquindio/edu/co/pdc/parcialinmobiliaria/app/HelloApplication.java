package org.uniquindio.edu.co.pdc.parcialinmobiliaria.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/org/uniquindio/edu/co/pdc/parcialinmobiliaria/vista/InmuebleView.fxml"
        ));

        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("Gestión de Inmuebles");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
