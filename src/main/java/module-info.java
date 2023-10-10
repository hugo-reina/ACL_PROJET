module com.example.acl_projet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.acl_projet to javafx.fxml;
    exports com.example.acl_projet;
}