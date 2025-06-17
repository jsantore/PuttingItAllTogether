module bsu.comp152.puttingitalltogether {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;

    opens bsu.comp152.puttingitalltogether to javafx.fxml, com.fasterxml.jackson.databind;
    exports bsu.comp152.puttingitalltogether;
}