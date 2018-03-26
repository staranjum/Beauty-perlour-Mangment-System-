package model;

import db.DatabaseConnection;
import dataclass.beauticians.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BeautiModel {

    // Get all packages
    //package list
    public static List<Beauticians> getBeauticians() throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "SELECT * FROM beauticians";
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet set = statement.executeQuery();

        List<Beauticians> list = new LinkedList<>();

        while (set.next()) {
            list.add(generateBeauticians(set));
        }

        return list;
    }

    // Create Beauticians
    public static void createBeauticians(Beauticians beauticians) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String query = "INSERT INTO beauticians (name, phone, email, salary, category, shift) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, beauticians.getName());
        statement.setString(2, beauticians.getPhone());
        statement.setString(3, beauticians.getEmail());
        statement.setString(4, String.valueOf(beauticians.getSalary()));
        statement.setString(5, beauticians.getCatogory().name());
        statement.setString(6, beauticians.getShift().name());

        statement.executeUpdate();
        System.out.println("Beautician Created Successfully...");
    }

    private static Beauticians generateBeauticians(ResultSet set) throws SQLException {
        int id = set.getInt("id");
        String name = set.getString("name");
        String phone = set.getString("phone");
        String email = set.getString("email");
        double salary = set.getDouble("salary");
        String category = set.getString("category");
        String shift = set.getString("shift");

        Beauticians beauticians = null;

        if (category.equals(BeauticianCatogory.COSMOLOGIST.name())) {
            beauticians = new Cosmologist(id, name, phone, email, salary, BeauticianCatogory.COSMOLOGIST, Shift.valueOf(shift));
        } else if (category.equals(BeauticianCatogory.HAIREXPERT.name())){
            beauticians = new HairExpert(id, name, phone, email, salary, BeauticianCatogory.HAIREXPERT, Shift.valueOf(shift));
        } else if (category.equals(BeauticianCatogory.MAKEUPARTIST.name())) {
            beauticians = new MakeupArtist(id, name, phone, email, salary, BeauticianCatogory.MAKEUPARTIST, Shift.valueOf(shift));
        }

        return beauticians;
    }

    // Create A Package

}
