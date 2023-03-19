import java.util.*;

public class PhoneBookDirectory{

    private Map<String, String> phoneBook;

    public PhoneBookDirectory() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String number) {
        phoneBook.put(name, number);
        System.out.println("Contact added successfully.");
    }

    public void searchContact(String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println(name + ": " + phoneBook.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void listContacts() {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void modifyContact(String name, String newNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.put(name, newNumber);
            System.out.println("Contact modified successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String name) {
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        PhoneBookDirectory phoneBookDirectory = new PhoneBookDirectory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add new contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. List all contacts");
            System.out.println("4. Modify a contact");
            System.out.println("5. Delete a contact");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter number: ");
                    String number = scanner.nextLine();
                    phoneBookDirectory.addContact(name, number);
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    phoneBookDirectory.searchContact(name);
                    break;
                case 3:
                    phoneBookDirectory.listContacts();
                    break;
                case 4:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new number: ");
                    String newNumber = scanner.nextLine();
                    phoneBookDirectory.modifyContact(name, newNumber);
                    break;
                case 5:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    phoneBookDirectory.deleteContact(name);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
