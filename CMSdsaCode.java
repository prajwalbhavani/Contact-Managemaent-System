import java.util.Scanner;

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class ContactManager {

    static Contact[] contacts = new Contact[100];
    static int count = 0;

    // Add Contact
    static void addContact(String name, String phone) {
        contacts[count] = new Contact(name, phone);
        count++;
        System.out.println("Contact Added Successfully");
    }

    // Display Contacts
    static void displayContacts() {
        if (count == 0) {
            System.out.println("No contacts available");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(contacts[i].name + " - " + contacts[i].phone);
        }
    }

    // Linear Search
    static void searchContact(String name) {
        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + contacts[i].name + " - " + contacts[i].phone);
                return;
            }
        }
        System.out.println("Contact not found");
    }

    // Bubble Sort
    static void sortContacts() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (contacts[j].name.compareToIgnoreCase(contacts[j + 1].name) > 0) {
                    Contact temp = contacts[j];
                    contacts[j] = contacts[j + 1];
                    contacts[j + 1] = temp;
                }
            }
        }
        System.out.println("Contacts Sorted Successfully");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Sort Contacts");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    addContact(name, phone);
                    break;

                case 2:
                    displayContacts();
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String search = sc.nextLine();
                    searchContact(search);
                    break;

                case 4:
                    sortContacts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}