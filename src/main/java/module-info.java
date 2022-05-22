module com.qterminals.qtplanner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.qterminals.qtplanner to javafx.fxml;
    exports com.qterminals.qtplanner;
}