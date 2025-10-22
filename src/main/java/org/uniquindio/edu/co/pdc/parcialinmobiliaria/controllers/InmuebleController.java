package org.uniquindio.edu.co.pdc.parcialinmobiliaria.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.database.InmobiliariaDatabase;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.facade.InmobiliariaFacade;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.FactoryInmueble;
import org.uniquindio.edu.co.pdc.parcialinmobiliaria.model.Inmueble;

public class InmuebleController {

    @FXML private TextField txtCodigo;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtHabitaciones;
    @FXML private TextField txtPisos;
    @FXML private TextField txtPrecio;
    @FXML private ComboBox<String> cmbTipo; // <-- para seleccionar el tipo de inmueble
    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;

    @FXML private TableView<Inmueble> tablaInmuebles;
    @FXML private TableColumn<Inmueble, String> colCodigo;
    @FXML private TableColumn<Inmueble, String> colCiudad;
    @FXML private TableColumn<Inmueble, Integer> colHabitaciones;
    @FXML private TableColumn<Inmueble, Integer> colPisos;
    @FXML private TableColumn<Inmueble, Double> colPrecio;
    @FXML private TableColumn<Inmueble, String> colTipo;

    private final ObservableList<Inmueble> listaInmuebles = FXCollections.observableArrayList();
    private InmobiliariaFacade inmobiliariaFacade = new InmobiliariaFacade();

    @FXML
    public void initialize() {
        // Tipos de inmueble
        cmbTipo.setItems(FXCollections.observableArrayList("Casa", "Apartamento", "Finca", "Local"));

        // Configurar columnas
        colCodigo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCode()));
        colCiudad.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCiudad()));
        colHabitaciones.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getNumHabitaciones()));
        colPisos.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getNumPisos()));
        colPrecio.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPrecio()));

        // Columna tipo (simplemente el nombre de la clase)
        colTipo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                data.getValue().getClass().getSimpleName()
        ));


        Inmueble i1 = FactoryInmueble.createInmueble("Casa", "C001", "Bogotá", 3, 2, 250000.0);
        Inmueble i2 = FactoryInmueble.createInmueble("Apartamento", "A002", "Medellín", 2, 1, 180000.0);
        Inmueble i3 = FactoryInmueble.createInmueble("Finca", "F003", "Armenia", 4, 1, 400000.0);
        Inmueble i4 = FactoryInmueble.createInmueble("Local", "L004", "Cali", 0, 1, 600000.0);

        listaInmuebles.addAll(i1, i2, i3, i4);

        //esto solo se hace para pruebas
        InmobiliariaDatabase.getInstance().addInmueble(i1);
        InmobiliariaDatabase.getInstance().addInmueble(i4);
        InmobiliariaDatabase.getInstance().addInmueble(i2);
        InmobiliariaDatabase.getInstance().addInmueble(i3);

        tablaInmuebles.setItems(listaInmuebles);
    }

    @FXML
    private void agregarInmueble() {
        try {
            String tipo = cmbTipo.getValue();
            String codigo = txtCodigo.getText().trim();
            String ciudad = txtCiudad.getText().trim();
            int habitaciones = Integer.parseInt(txtHabitaciones.getText().trim());
            int pisos = Integer.parseInt(txtPisos.getText().trim());
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            if (tipo == null || tipo.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Selecciona el tipo de inmueble.").show();
                return;
            }

            // Usamos el facade
            Inmueble nuevo = inmobiliariaFacade.registrarInmueble(tipo, codigo, ciudad, habitaciones, pisos, precio);

            listaInmuebles.add(nuevo);
            limpiarCampos();

        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Por favor ingresa valores numéricos válidos.").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error al crear el inmueble: " + e.getMessage()).show();
        }
    }

    @FXML
    private void eliminarInmueble() {
        Inmueble seleccionado = tablaInmuebles.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            tablaInmuebles.getItems().remove(seleccionado);
            inmobiliariaFacade.eliminarInmueble(seleccionado);
        } else {
            // opcional: alerta si no hay nada seleccionado
            System.out.println("Seleccione un inmueble para eliminar.");
        }
    }

    private void limpiarCampos() {
        txtCodigo.clear();
        txtCiudad.clear();
        txtHabitaciones.clear();
        txtPisos.clear();
        txtPrecio.clear();
        cmbTipo.getSelectionModel().clearSelection();
    }
}