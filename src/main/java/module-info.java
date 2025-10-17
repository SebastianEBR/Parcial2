module org.uniquindio.edu.co.pdc.parcialinmobiliaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.uniquindio.edu.co.pdc.parcialinmobiliaria;


    opens org.uniquindio.edu.co.pdc.parcialinmobiliaria to javafx.fxml;
    exports org.uniquindio.edu.co.pdc.parcialinmobiliaria;
}