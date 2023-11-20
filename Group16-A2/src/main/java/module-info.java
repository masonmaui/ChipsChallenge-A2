module com.example.group16a2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.group16a2 to javafx.fxml;
    exports com.example.group16a2;
}