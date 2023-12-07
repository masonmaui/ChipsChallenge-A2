module com.example.group16a2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.group16a2 to javafx.fxml;
    exports com.example.group16a2;
    exports com.example.group16a2.Tiles;
    opens com.example.group16a2.Tiles to javafx.fxml;
    exports com.example.group16a2.Items;
    opens com.example.group16a2.Items to javafx.fxml;
    exports com.example.group16a2.Actors;
    opens com.example.group16a2.Actors to javafx.fxml;
}