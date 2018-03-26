package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import dataclass.beauticians.BeauticianCatogory;
import dataclass.beauticians.Beauticians;
import dataclass.beauticians.Shift;
import model.BeautiModel;
import sample.PageHelper;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class BeauticianController implements Initializable {

    @FXML
    private TableView<Beauticians> beauticianTable;

    @FXML
    private TableColumn<Beauticians, String> name;

    @FXML
    private TableColumn<Beauticians, String> phone;

    @FXML
    private TableColumn<Beauticians, String> email;

    @FXML
    private TableColumn<Beauticians, Double> salary;

    @FXML
    private TableColumn<Beauticians, BeauticianCatogory> type;

    @FXML
    private TableColumn<Beauticians, Shift> shift;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            name.setCellValueFactory(new PropertyValueFactory<Beauticians, String>("name"));
            type.setCellValueFactory(new PropertyValueFactory<Beauticians, BeauticianCatogory>("category"));
            phone.setCellValueFactory(new PropertyValueFactory<Beauticians, String>("phone"));
            email.setCellValueFactory(new PropertyValueFactory<Beauticians, String>("email"));
            salary.setCellValueFactory(new PropertyValueFactory<Beauticians, Double>("salary"));
            shift.setCellValueFactory(new PropertyValueFactory<Beauticians, Shift>("shift"));

            beauticianTable.setItems(getBeauticianList());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gotoPackages(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    public void gotoBeauticians(ActionEvent actionEvent) {
    }

    public void gotoUsers(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/users.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    public void gotoAdmin(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/admin.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }


    private ObservableList<Beauticians> getBeauticianList() throws SQLException {

        List<Beauticians> beauticianList = BeautiModel.getBeauticians();

        ObservableList<Beauticians> list = FXCollections.observableArrayList();
        list.addAll(beauticianList);

        return list;
    }


}
