module bsu.comp152.puttingitalltogether {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires com.fasterxml.jackson.annotation;

    opens bsu.comp152.puttingitalltogether to javafx.fxml;
    exports bsu.comp152.puttingitalltogether;
}