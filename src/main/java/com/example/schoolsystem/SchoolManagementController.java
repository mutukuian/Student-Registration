package com.example.schoolsystem;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;

import java.io.IOException;

import java.sql.*;


public class SchoolManagementController  {

    @FXML
    private Button cancelBtn;




    @FXML
    private TextField usernameTF;

    @FXML
    private PasswordField passwordTF;



    public void cancelBtnAction(ActionEvent e) throws IOException {

        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("LogRegister.fxml"));
        Scene rootScene = new Scene(root);

        stage =(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();
    }



    public void  validateLogin(ActionEvent e) throws SQLException, IOException {


        DatabaseConnection connectNow = new DatabaseConnection();

        String verifyLogin = "SELECT password FROM Users WHERE userName = ?" ;



        try {
            Connection con = connectNow.getConnection();
            PreparedStatement statement = con.prepareStatement(verifyLogin);
            statement.setString(1,usernameTF.getText());
            ResultSet queryResult = statement.executeQuery();


            while(queryResult.next())
                if (queryResult.getString(1).equals(passwordTF.getText())) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setContentText("Login successfully...");
                    alert.setHeaderText(null);
                    alert.setHeight(30);
                    alert.setWidth(50);
                    alert.showAndWait();

                    onSuccess(e);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Failed!!!");
                    alert.setContentText("Login Failed...");
                    alert.setHeaderText(null);
                    alert.setHeight(30);
                    alert.setWidth(50);
                    alert.showAndWait();


                }

            } catch (SQLException ex) {
            ex.printStackTrace();

        }





    }
    public void onSuccess(ActionEvent e) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("studentRegister.fxml"));
        Scene rootScene = new Scene(root);
        stage =(Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(rootScene);
        stage.show();
    }
}