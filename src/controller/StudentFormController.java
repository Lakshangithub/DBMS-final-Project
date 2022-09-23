package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.Student;
import util.CrudUtil;

import java.sql.SQLException;

public class StudentFormController {

    public TextField txtId;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtNIC;
    public Button btnAdd;
    public Button btnAdd1;
    public Button btnAdd11;
    public TableView tblview;
    public TableColumn colid;
    public TableColumn colname;
    public TableColumn coladdress;
    public TableColumn colemail;
    public TableColumn colmobile;
    public TableColumn colmobile1;

    public void addOnAction(ActionEvent actionEvent) {
        Student s = new Student(
                txtId.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText()
                ,txtNIC.getText()
        );

        try {
            if (CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?)",s.getId(),s.getName(),s.getEmail(),s.getContact(),s.getAddress(),s.getNic())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }

    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }
}
