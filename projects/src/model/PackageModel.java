package model;

import db.DatabaseConnection;
import dataclass.packages.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PackageModel {

    // Get Packages By Package Id
    public static StylePackage getPackage(int id) throws SQLException {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM packages WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, String.valueOf(id));

        ResultSet set = statement.executeQuery();

        if (set.next()) {
            return generatePackage(set);
        }
        return null;
    }

    // Get all packages
    public static List<StylePackage> getPackages() throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM packages";
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet set = statement.executeQuery();

        List<StylePackage> list = new LinkedList<>();

        while (set.next()) {
            list.add(generatePackage(set));
        }

        return list;
    }

    // Create A Package

    public static void createPackage(StylePackage stylePackage) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "INSERT INTO packages (name, type, cost) " +
                "VALUES(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, stylePackage.getName());
        statement.setString(2, stylePackage.getType().name());
        statement.setString(3, String.valueOf(stylePackage.getCost()));

        statement.executeUpdate();
        System.out.println("Package Created Successfully...");

    }

    // Generate Package from result set
    private static StylePackage generatePackage(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String name = set.getString("name");
        String type = set.getString("type");
        double cost = set.getDouble("cost");

        StylePackage stylePackage = null;

        if (type.equals(PackageType.COSMIC.name())) {
            stylePackage = new CosmicPackage(id, name, PackageType.COSMIC, cost);
        } else if (type.equals(PackageType.HAIR.name())) {
            stylePackage = new HairPackage(id, name, PackageType.HAIR, cost);
        } else if (type.equals(PackageType.MAKEOVER.name())) {
            stylePackage = new MakeOverPackage(id, name, PackageType.MAKEOVER, cost);
        }

        return stylePackage;
    }
}
