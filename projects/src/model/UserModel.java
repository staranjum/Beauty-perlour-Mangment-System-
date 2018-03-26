package model;

import dataclass.packages.StylePackage;
import dataclass.user.User;
import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserModel {

    // Get User By User Id
    public static User getUser(int id) throws SQLException {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM users WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(id));

        ResultSet set = statement.executeQuery();

        if (set.next()) {
            return generateUser(set);
        }
        return null;
    }

    private static User generateUser(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String name = set.getString("name");
        String phone = set.getString("phone");
        String address = set.getString("address");
        long lastVisited = set.getLong("lastvisited");

        User user = new User(id, name, phone, address, lastVisited);
        return user;
    }

    private static void updateUserById(int id, long date) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "UPDATE ?lastvisited FROM users WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(date));
        statement.setString(2, String.valueOf(id));

        statement.execute();
        System.out.println("Updated Successfully...");
    }

    // Get all Users
    public static List<User> getUsers() throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM users";
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet set = statement.executeQuery();

        List<User> list = new LinkedList<>();

        while (set.next()) {
            list.add(generateUser(set));
        }

        return list;
    }

    // Create A Package

    public static void createUser(User user) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "INSERT INTO users (name, phone, address, lastvisited) " +
                "VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, user.getName());
        statement.setString(2, user.getPhone());
        statement.setString(3, user.getAddress());
        statement.setString(4, String.valueOf(new Date().getTime()));

        statement.executeUpdate();
        System.out.println("User Created Successfully...");

    }
}
