module com.nhc.customcharacter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.nhc.customcharacter to javafx.fxml;
    exports com.nhc.customcharacter;
    exports com.nhc.pojo;
}
