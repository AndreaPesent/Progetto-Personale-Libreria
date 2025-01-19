module com.example.progettopersonalelibreria {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.progettopersonalelibreria to javafx.fxml;
    exports com.example.progettopersonalelibreria;
}