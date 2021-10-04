module org.EternityChat {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.EternityChat to javafx.fxml;
    exports org.EternityChat;
}
