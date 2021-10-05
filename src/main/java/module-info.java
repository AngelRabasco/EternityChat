module org.EternityChat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires com.sun.xml.bind;

    opens org.EternityChat to javafx.fxml;
    exports org.EternityChat;
}
