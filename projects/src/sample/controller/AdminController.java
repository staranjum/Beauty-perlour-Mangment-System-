package sample.controller;

import dataclass.user.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import dataclass.beauticians.BeauticianCatogory;
import dataclass.beauticians.Beauticians;
import dataclass.beauticians.Shift;
import dataclass.packages.PackageType;
import dataclass.packages.StylePackage;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BeautiModel;
import model.PackageModel;
import model.UserModel;
import sample.PageHelper;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable{

    // Display Al User List
    // User Related Variables
    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, Integer> userId;

    @FXML
    private TableColumn<User, String> userName;

    @FXML
    private TableColumn<User, String> userPhone;

    @FXML
    private TableColumn<User, String> userAddress;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        packageTypeComboBox.getItems().addAll(PackageType.HAIR, PackageType.COSMIC, PackageType.MAKEOVER);
        packageSuccessLabel.setVisible(false);

        beautiCategory.getItems().addAll(BeauticianCatogory.COSMOLOGIST, BeauticianCatogory.HAIREXPERT, BeauticianCatogory.MAKEUPARTIST);
        beautiShift.getItems().addAll(Shift.DAY, Shift.EVENING, Shift.NIGHT);
        beautiSuccessLabel.setVisible(false);

        userCreatedSuccessfully.setVisible(false);

        try {
            userId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
            userName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
            userPhone.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
            userAddress.setCellValueFactory(new PropertyValueFactory<User, String>("address"));

            userTable.setItems(getUsersList());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*
    * This Section is Only For Navigation Purpose
    *
    * There Are Four Methods
    *
    * Each for One Link
    * */
    public void gotoPackages(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    public void gotoBeauticians(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/beauticians.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    public void gotoUsers(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/users.fxml"));
        PageHelper.gotoPage(actionEvent, parent);
    }

    public void gotoAdmin(ActionEvent actionEvent) {
    }



    // This Section is for Create Package

    @FXML
    private TextField packageNameField;

    @FXML
    private TextField packageCostField;

    @FXML
    private ComboBox<PackageType> packageTypeComboBox;

    @FXML
    private Label packageSuccessLabel;

    private PackageType selectedPackageType;

    public void changePackageType(ActionEvent actionEvent) {
        selectedPackageType = packageTypeComboBox.getValue();
    }

    public void createPackage(ActionEvent actionEvent) throws SQLException {
        String name = packageNameField.getText();
        double cost = Double.parseDouble(packageCostField.getText());

        StylePackage stylePackage = new StylePackage(name, selectedPackageType, cost);
        PackageModel.createPackage(stylePackage);

        packageSuccessLabel.setVisible(true);
        packageNameField.setText("");
        packageCostField.setText("");
        packageTypeComboBox.setPromptText("Type");
    }


    // This section is for beautician Creation
    @FXML
    private TextField beautiName;

    @FXML
    private TextField beautiPhone;

    @FXML
    private TextField beautiEmail;

    @FXML
    private TextField beautiSalary;

    @FXML
    private ComboBox<BeauticianCatogory> beautiCategory;

    @FXML
    private ComboBox<Shift> beautiShift;

    @FXML
    private Label beautiSuccessLabel;

    private BeauticianCatogory selectedCategory;
    private Shift selectedShift;

    public void changeBeautiCategory(ActionEvent actionEvent) {
        selectedCategory = beautiCategory.getValue();
    }

    public void changeBeautiShift(ActionEvent actionEvent) {
        selectedShift = beautiShift.getValue();
    }

    public void registerBeauti(ActionEvent actionEvent) throws SQLException {
        String name = beautiName.getText();
        String phone = beautiPhone.getText();
        String email = beautiEmail.getText();
        double salary = Double.parseDouble(beautiSalary.getText());

        Beauticians beauticians = new Beauticians(name, phone, email, salary, selectedCategory, selectedShift);
        BeautiModel.createBeauticians(beauticians);

        beautiName.setText("");
        beautiPhone.setText("");
        beautiEmail.setText("");
        beautiSalary.setText("");
        beautiSuccessLabel.setVisible(true);
    }


    // Create User Account

    @FXML
    private TextField createUserName;

    @FXML
    private TextField createUserPhone;

    @FXML
    private TextArea createUserAddress;

    @FXML
    private Label userCreatedSuccessfully;

    public void createNewUser(ActionEvent actionEvent) throws SQLException {

        String name = createUserName.getText();
        String phone = createUserPhone.getText();
        String address = createUserAddress.getText();

        User user = new User(name, phone, address);
        UserModel.createUser(user);

        createUserName.setText("");
        createUserAddress.setText("");
        createUserPhone.setText("");
        userCreatedSuccessfully.setVisible(true);

    }


    // Get All Users From Database and Convert it to Observable List
    private ObservableList<User> getUsersList() throws SQLException {

        List<User> userList = UserModel.getUsers();

        ObservableList<User> list = FXCollections.observableArrayList();
        list.addAll(userList);

        return list;
    }
}
