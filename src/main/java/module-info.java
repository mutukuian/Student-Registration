module com.example.schoolsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.schoolsystem to javafx.fxml;
    exports com.example.schoolsystem;
}