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
import dataclass.packages.StylePackage;
import model.PackageModel;
import sample.PageHelper;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private TableView<StylePackage> packagetable;

    @FXML
    private TableColumn<StylePackage, Integer> id;

    @FXML
    private TableColumn<StylePackage, String> name;

    @FXML
    private TableColumn<StylePackage, Double> cost;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            id.setCellValueFactory(new PropertyValueFactory<StylePackage, Integer>("id"));
            name.setCellValueFactory(new PropertyValueFactory<StylePackage, String>("name"));
            cost.setCellValueFactory(new PropertyValueFactory<StylePackage, Double>("cost"));

            packagetable.setItems(getPackageList());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void gotoPackages(ActionEvent actionEvent) {

    }

    public void gotoBeauticians(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/beauticians.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    public void gotoUsers(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/users.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    public void gotoAdmin(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/admin.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    private ObservableList<StylePackage> getPackageList() throws SQLException {

        List<StylePackage> packageList = PackageModel.getPackages();

        ObservableList<StylePackage> list = FXCollections.observableArrayList();
        list.addAll(packageList);

        return list;
    }

}
