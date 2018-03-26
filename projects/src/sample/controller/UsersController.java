package sample.controller;

import dataclass.packages.StylePackage;
import dataclass.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.PackageModel;
import model.UserModel;
import sample.PageHelper;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class UsersController {


    public void gotoPackages(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    public void gotoBeauticians(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/beauticians.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    public void gotoUsers(ActionEvent actionEvent) throws IOException {

    }

    public void gotoAdmin(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/admin.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }


    // Search For User Existence
    @FXML
    private TextField userIdforSearch;

    @FXML
    private Label userFound;

    @FXML
    private Label userlastVisited;

    @FXML
    private Label userInterest;

    private static final int DISCOUNT = 5;
    private static boolean isRegistered;
    public void searchForUser(ActionEvent actionEvent) throws SQLException {
        int id = Integer.parseInt(userIdforSearch.getText());
        User user = UserModel.getUser(id);

        if (user == null) {
            userFound.setText("User Not Found");
            userFound.setVisible(true);
            isRegistered = false;
        } else {
            Date date = new Date(user.getVisitedDate());
            userFound.setVisible(true);
            userlastVisited.setText(date.toString());
            userlastVisited.setVisible(true);
            userInterest.setText("Discount = " + DISCOUNT) ;
            userInterest.setVisible(true);
            isRegistered = true;
        }
    }

    @FXML
    private TextField packageId;

    @FXML
    private TableView<StylePackage> itemTable;

    @FXML
    private TableColumn<StylePackage, Integer> itemId;

    @FXML
    private TableColumn<StylePackage, String> itemName;

    @FXML
    private TableColumn<StylePackage, Double> itemCost;

    @FXML
    private Label totalBill;

    private ObservableList<StylePackage> itemList = FXCollections.observableArrayList();

    public void addPackage(ActionEvent actionEvent) throws SQLException {
        int id = Integer.parseInt(packageId.getText());

        StylePackage stylePackage = PackageModel.getPackage(id);

        if (stylePackage == null) {
            System.out.println("Package Not Found");
        }
        else {
            itemList.add(stylePackage);
            updateTable();
        }
        packageId.setText("");
    }

    private void updateTable() {
        itemId.setCellValueFactory(new PropertyValueFactory<StylePackage, Integer>("id"));
        itemName.setCellValueFactory(new PropertyValueFactory<StylePackage, String>("name"));
        itemCost.setCellValueFactory(new PropertyValueFactory<StylePackage, Double>("cost"));

        itemTable.setItems(itemList);
    }

    public void calculateTotalBill(ActionEvent actionEvent) {

        double totalCost = 0;
        double discount = 0;

        for (StylePackage item : itemList) {
            totalCost += item.getCost();
        }

        if (isRegistered) {
            discount = totalCost * DISCOUNT / 100;
        }

        totalCost += discount;
        totalBill.setText(String.valueOf(totalCost));

    }
}
