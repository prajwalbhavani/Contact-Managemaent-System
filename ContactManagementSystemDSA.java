import java.util.*;

// CO2: ADT using Array/Object
class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class ContactManagementSystem {

    // CO2: Array Data Structure
    static Contact[] contacts = new Contact[100];
    static int count = 0;

    // CO3: Queue (FIFO — Recent Contacts)
    static Queue<Contact> recentContacts = new LinkedList<>();

    // CO4: HashMap (Fast Lookup)
    static HashMap<String, String> contactMap = new HashMap<>();

    // CO2 + CO5: Insert Operation
    static void addContact(String name, String phone) {

        Contact newContact = new Contact(name, phone);

        contacts[count++] = newContact; // Array insert (CO2)

        recentContacts.add(newContact); // CO3: Enqueue

        contactMap.put(name.toLowerCase(), phone); // CO4: Hash insert

        System.out.println("Contact added successfully.");
    }

    // CO2: Traversal
    static void displayContacts() {

        if (count == 0) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\nContact List:");

        for (int i = 0; i < count; i++) {
            System.out.println(contacts[i].name + " - " + contacts[i].phone);
        }
    }

    // CO1: Linear Search
    static void searchContactLinear(String name) {

        for (int i = 0; i < count; i++) {
            if (contacts[i].name.equalsIgnoreCase(name)) {
                System.out.println("Found (Linear): " + contacts[i].name + " - " + contacts[i].phone);
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    // CO4: HashMap Search (Fast O(1))
    static void searchContactHash(String name) {

        String phone = contactMap.get(name.toLowerCase());

        if (phone != null)
            System.out.println("Found (HashMap): " + name + " - " + phone);
        else
            System.out.println("Contact not found.");
    }

    // CO1: Bubble Sort
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

        System.out.println("Contacts sorted successfully.");
    }

    // CO3: Queue Processing (Recent Contacts)
    static void showRecentContacts() {

        if (recentContacts.isEmpty()) {
            System.out.println("No recent contacts.");
            return;
        }

        System.out.println("\nRecent Contacts (Queue — FIFO):");

        for (Contact c : recentContacts) {
            System.out.println(c.name + " - " + c.phone);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search (Linear)");
            System.out.println("4. Search (HashMap)");
            System.out.println("5. Sort Contacts");
            System.out.println("6. Show Recent Contacts (Queue)");
            System.out.println("7. Exit");

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
                    searchContactLinear(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter name to search: ");
                    searchContactHash(sc.nextLine());
                    break;

                case 5:
                    sortContacts();
                    break;

                case 6:
                    showRecentContacts();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}