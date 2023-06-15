package com.example.schoolsystem;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentRegisterController implements Initializable {

    @FXML
    private TextField regNo;

    @FXML
    private TextField fName;

    @FXML
    private DatePicker dor;



    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private ComboBox<String> prog;

    @FXML
    private TextField cont;

    @FXML
    private Button saveBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        prog.setItems(FXCollections.observableArrayList("SIK","SIT","COM","ETS","BIT","ITE"));
    }

    public void ProgramAction(ActionEvent e) {
//        prog.getItems();
    }


    public void SaveBtn(ActionEvent e){


        String num = regNo.getText();
        String nem = fName.getText();
        String sex = null;
        if (male.isSelected())
            sex = "M";
        else if (female.isSelected())
            sex = "F";

        String det = dor.getValue().toString();

        String contact = cont.getText();


        String program = prog.getValue().toString();

        DatabaseConnection connectNow = new DatabaseConnection();


        String sql = "insert into students values(?,?,?,?,?,?)";

        try {
            Connection con = connectNow.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, num);
            statement.setString(2, nem);
            statement.setString(3, det);
            statement.setString(4, sex);
            statement.setString(5, program);
            statement.setString(6, contact);
            int x = statement.executeUpdate();
            if(x == 1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Student added successfully...");
                alert.setHeaderText(null);
                alert.setHeight(30);
                alert.setWidth(50);
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
