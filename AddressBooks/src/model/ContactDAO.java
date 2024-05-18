package model;

import dao.DbConnection;
import entity.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private static Connection conn;


    static {
        try {
            conn = DbConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addContact(Contact contact){
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO contacts (contact_name, contact_company, contact_email, contact_phone) VALUES (?, ?, ?, ?)");
            statement.setString(1, contact.getContact_name());
            statement.setString(2, contact.getContact_company());
            statement.setString(3, contact.getContact_email());
            statement.setString(4, contact.getContact_phone());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public  List<Contact> findByName(String name) throws SQLException {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM contacts WHERE contact_name LIKE ?")) {
            statement.setString(1, "%" + name + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Contact> contacts = new ArrayList<>();
                while (resultSet.next()) {
                    String contactName = resultSet.getString("contact_name");
                    String company = resultSet.getString("contact_company");
                    String email = resultSet.getString("contact_email");
                    String phone = resultSet.getString("contact_phone");
                    contacts.add(new Contact(contactName, company, email, phone));
                }
                return contacts;
            }
        }
    }

    public  ArrayList<Contact> getAllContacts() throws SQLException {
        Connection conn = DbConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");
        ArrayList<Contact> contacts = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("contact_name");
            String company = resultSet.getString("contact_company");
            String email = resultSet.getString("contact_email");
            String phone = resultSet.getString("contact_phone");
            contacts.add(new Contact(name, company, email, phone));
        }
        conn.close();
        return contacts;
    }


}
