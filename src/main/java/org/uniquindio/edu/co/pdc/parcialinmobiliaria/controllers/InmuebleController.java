package org.uniquindio.edu.co.pdc.parcialinmobiliaria.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.FactoryInmueble;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.Inmueble;

public class InmuebleController {

    @FXML private TextField txtTipo;
    @FXML private TextField txtCodigo;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtHabitaciones;
    @FXML private TextField txtPisos;
    @FXML private TextField txtPrecio;
    @FXML private Button btnAgregar;

    @FXML private TableView<Inmueble> tablaInmuebles;
    @FXML private TableColumn<Inmueble, String> colCodigo;
    @FXML private TableColumn<Inmueble, String> colCiudad;
    @FXML private TableColumn<Inmueble, Integer> colHabitaciones;
    @FXML private TableColumn<Inmueble, Integer> colPisos;
    @FXML private TableColumn<Inmueble, Double> colPrecio;

    private final ObservableList<Inmueble> listaInmuebles = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Configurar columnas
        colCodigo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCode()));
        colCiudad.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCiudad()));
        colHabitaciones.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getNumHabitaciones()));
        colPisos.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getNumPisos()));
        colPrecio.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPrecio()));

        tablaInmuebles.setItems(listaInmuebles);
    }

    @FXML
    private void agregarInmueble() {
        try {
            String type = txtTipo.getText();
            String code = txtCodigo.getText();
            String ciudad = txtCiudad.getText();
            int numHabitaciones = Integer.parseInt(txtHabitaciones.getText());
            int numPisos = Integer.parseInt(txtPisos.getText());
            double precio = Double.parseDouble(txtPrecio.getText());

            Inmueble nuevo = new FactoryInmueble.createInmueble(type, code, ciudad, numHabitaciones, numPisos, precio) {
            }
                    .setCode(code)
                    .setCiudad(ciudad)
                    .setNumHabitaciones(numHabitaciones)
                    .setNumPisos(numPisos)
                    .setPrecio(precio)
                    .build();

            listaInmuebles.add(nuevo);
            limpiarCampos();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Verifica los datos ingresados").show();
        }
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtCiudad.clear();
        txtHabitaciones.clear();
        txtPisos.clear();
        txtPrecio.clear();
    }
}