module org.uniquindio.edu.co.pdc.parcialinmobiliaria {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.uniquindio.edu.co.pdc.parcialinmobiliaria to javafx.fxml;
    exports org.uniquindio.edu.co.pdc.parcialinmobiliaria;
    exports org.uniquindio.edu.co.pdc.parcialinmobiliaria.app;
    opens org.uniquindio.edu.co.pdc.parcialinmobiliaria.app to javafx.fxml;
}