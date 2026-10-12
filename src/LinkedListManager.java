
import java.util.Scanner;

public class LinkedListManager {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;

    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Value inserted successfully.");
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println("Value deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Value deleted successfully.");
        }
    }

    public void search(int value) {
        Node current = head;
        int position = 0;

        while (current != null) {
            if (current.data == value) {
                System.out.println(
                    "Value found at position " + position
                );
                return;
            }

            current = current.next;
            position++;
        }

        System.out.println("Value not found.");
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        Node current = head;

        System.out.print("Linked List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public void run(Scanner input) {
        int choice;

        do {
            System.out.println("\n--- LINKED LIST OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            choice = readInt(input, "Enter your choice: ");

            switch (choice) {
                case 1:
                    insert(readInt(input, "Enter a value: "));
                    break;

                case 2:
                    delete(readInt(input, "Enter value to delete: "));
                    break;

                case 3:
                    search(readInt(input, "Enter value to search: "));
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Choose a number from 1 to 5.");
            }

        } while (choice != 5);
    }

    private int readInt(Scanner input, String message) {
        while (true) {
            System.out.print(message);

            if (input.hasNextInt()) {
                return input.nextInt();
            }

            System.out.println("Invalid input! Enter a whole number.");
            input.nextLine();
        }
    }
}
