import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactBook {
    private static Map<String, Contact> contacts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    deleteContact();
                    break;
                case 3:
                    emailContact();
                    break;
                case 4:
                    printContacts();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    System.out.println("Exiting the Contact Book. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Contact Book Menu");
        System.out.println("1. Add a contact");
        System.out.println("2. Delete a contact");
        System.out.println("3. Email a contact");
        System.out.println("4. Print all contacts");
        System.out.println("5. Search for a contact");
        System.out.println("6. Quit");
        System.out.print("Enter your choice (1-6): ");
    }

    private static void addContact() {
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter the email address: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phone, email);
        contacts.put(name, contact);

        System.out.println("Contact added successfully!");
    }

    private static void deleteContact() {
        System.out.print("Enter the name of the contact to delete: ");
        String name = scanner.nextLine();

        Contact contact = contacts.remove(name);
        if (contact != null) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    private static void emailContact() {
        System.out.print("Enter the name of the contact to email: ");
        String name = scanner.nextLine();

        Contact contact = contacts.get(name);
        if (contact != null) {
            System.out.printf("Emailing %s at %s...%n", name, contact.getEmail());
            // Code to send email
        } else {
            System.out.println("Contact not found!");
        }
    }

    private static void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    private static void searchContact() {
        System.out.print("Enter the name of the contact to search: ");
        String name = scanner.nextLine();

        Contact contact = contacts.get(name);
        if (contact != null) {
            System.out.println("Contact details:");
            System.out.println(contact);
        } else {
            System.out.println("Contact not found!");
        }
    }
}

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}