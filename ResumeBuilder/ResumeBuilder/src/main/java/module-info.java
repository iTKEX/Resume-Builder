module advancedprogramming.resumebuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires pdfbox;
    requires java.sql;
    
    opens advancedprogramming.resumebuilder to javafx.fxml;
    exports advancedprogramming.resumebuilder;
}
