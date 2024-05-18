package controller;

import java.sql.SQLException;
import java.util.List;
import entity.Contact;
import model.ContactDAO;


public class ContactController {
    ContactDAO contactDAO = new ContactDAO();
    public List<Contact> findContactsByName(String name) {
        try {
            return contactDAO.findByName(name);
        } catch (SQLException e) {
            System.out.println("An error occurred while finding contacts by name: " + e.getMessage());
            return null;
        }
    }

    // Phương thức để thêm một contact mới vào cơ sở dữ liệu
    public void addContact(Contact contact) {
        try {
            contactDAO.addContact(contact); // Sửa ở đây: đã bỏ dấu chấm và thêm phương thức addContact(contact)
            System.out.println("Contact added successfully.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Phương thức để hiển thị tất cả các contacts
    public List<Contact> getAllContacts() {
        try {
            return contactDAO.getAllContacts();
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving contacts: " + e.getMessage());
            return null;
        }
    }
}
