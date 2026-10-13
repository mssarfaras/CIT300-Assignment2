 
import java.util.Scanner;

public class ArrayManager {

    private int[] numbers = new int[100];
    private int size = 0;

    public void insert(int value) {
        if (size == numbers.length) {
            System.out.println("Array is full!");
            return;
        }

        numbers[size] = value;
        size++;
        System.out.println("Value inserted successfully.");
    }

    public void delete(int value) {
        int index = search(value);

        if (index == -1) {
            System.out.println("Value not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            numbers[i] = numbers[i + 1];
        }

        size--;
        System.out.println("Value deleted successfully.");
    }

    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (numbers[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print("Array values: ");

        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
    }

    public void displaySummary() {
        System.out.println("\n--- Array Summary ---");
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print("Array values: ");

        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
    }

    public void run(Scanner input) {
        int choice;

        do {
            System.out.println("\n--- ARRAY OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            choice = readInt(input, "Enter your choice: ");

            switch (choice) {
                case 1:
                    insert(readInt(input, "Enter a number: "));
                    break;

                case 2:
                    delete(readInt(input, "Enter number to delete: "));
                    break;

                case 3:
                    int value = readInt(input, "Enter number to search: ");
                    int index = search(value);

                    if (index == -1) {
                        System.out.println("Value not found.");
                    } else {
                        System.out.println(
                            "Value found at index " + index
                        );
                    }
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


