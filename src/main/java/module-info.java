module org.EternityChat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires javafx.graphics;

    opens org.EternityChat to javafx.fxml, java.xml.bind, javafx.base;
    opens org.EternityChat.Model to javafx.xml, java.xml.bind;
    opens org.EternityChat.Util to com.sun.xml.bind;
    exports org.EternityChat;
}
