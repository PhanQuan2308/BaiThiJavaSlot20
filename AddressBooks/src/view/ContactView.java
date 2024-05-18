package view;

import java.util.List;
import java.util.Scanner;
import entity.Contact;
import controller.ContactController;

public class ContactView {
    private ContactController contactController;
    private Scanner scanner;

    public ContactView() {
        this.contactController = new ContactController();
        this.scanner = new Scanner(System.in);
    }

    // Hiển thị menu và xử lý lựa chọn của người dùng
    public void displayMenu() {
        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display all contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    findContactByName();
                    break;
                case 3:
                    displayAllContacts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    // Thêm một contact mới
    private void addNewContact() {
        System.out.println("Enter contact details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Company: ");
        String company = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        Contact contact = new Contact(name, company, email, phone);
        contactController.addContact(contact);
    }

    // Tìm kiếm contact theo tên và hiển thị kết quả
    private void findContactByName() {
        System.out.print("Enter name to find contact: ");
        String name = scanner.nextLine();
        List<Contact> foundContacts = contactController.findContactsByName(name);
        if (!foundContacts.isEmpty()) {
            System.out.println("Found contacts:");
            for (Contact contact : foundContacts) {
                System.out.println(contact.getContact_name() + " - " + contact.getContact_phone());
            }
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Hiển thị tất cả các contacts
    // Hiển thị tất cả các contacts dưới dạng bảng
    private void displayAllContacts() {
        List<Contact> contacts = contactController.getAllContacts();
        if (!contacts.isEmpty()) {
            System.out.println("                                   ======== Address Book ============                  ");
            System.out.printf("%-30s%-35s%-30s%-15s\n", "Contact Name", "Company", "Email", "Phone number");
            for (Contact contact : contacts) {
                System.out.printf("%-30s%-35s%-30s%-15s\n", contact.getContact_name(), contact.getContact_company(), contact.getContact_email(), contact.getContact_phone());
            }
        } else {
            System.out.println("No contacts found.");
        }
    }


    // Main method để chạy ứng dụng
    public static void main(String[] args) {
        ContactView contactView = new ContactView();
        contactView.displayMenu();
    }
}
