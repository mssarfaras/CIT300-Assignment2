
import java.util.Arrays;
import java.util.Scanner;

public class SearchingManager {

    private int[] numbers = new int[100];
    private int size = 0;

    public void addNumber(int value) {
        if (size == numbers.length) {
            System.out.println("Array is full!");
            return;
        }

        numbers[size++] = value;
        System.out.println("Number added successfully.");
    }

    public void display() {
        if (size == 0) {
            System.out.println("No numbers added yet.");
            return;
        }

        System.out.println("Numbers: "
                + Arrays.toString(Arrays.copyOf(numbers, size)));
    }

    public void displaySummary() {
        System.out.println("\n--- Searching Summary ---");
        if (size == 0) {
            System.out.println("No numbers added yet.");
            return;
        }

        System.out.println("Numbers: "
                + Arrays.toString(Arrays.copyOf(numbers, size)));
    }

    public void linearSearch(int target) {
        int steps = 0;

        for (int i = 0; i < size; i++) {
            steps++;

            if (numbers[i] == target) {
                System.out.println("Value found at index " + i);
                System.out.println("Steps: " + steps);
                return;
            }
        }

        System.out.println("Value not found.");
        System.out.println("Steps: " + steps);
    }

    public void binarySearch(int target) {
        if (size == 0) {
            System.out.println("Please add numbers first.");
            return;
        }

        int[] sorted = Arrays.copyOf(numbers, size);
        Arrays.sort(sorted);

        int left = 0;
        int right = sorted.length - 1;
        int steps = 0;

        while (left <= right) {
            steps++;
            int middle = left + (right - left) / 2;

            if (sorted[middle] == target) {
                System.out.println("Value found at sorted index "
                        + middle);
                System.out.println("Steps: " + steps);
                System.out.println("Sorted numbers: "
                        + Arrays.toString(sorted));
                return;
            } else if (sorted[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println("Value not found.");
        System.out.println("Steps: " + steps);
        System.out.println("Sorted numbers: "
                + Arrays.toString(sorted));
    }

    public void run(Scanner input) {
        int choice;

        do {
            System.out.println("\n--- SEARCHING OPERATIONS ---");
            System.out.println("1. Add Number");
            System.out.println("2. Display Numbers");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Return to Main Menu");

            choice = readInt(input, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addNumber(readInt(input, "Enter a number: "));
                    break;

                case 2:
                    display();
                    break;

                case 3:
                    linearSearch(readInt(input,
                            "Enter value to search: "));
                    break;

                case 4:
                    binarySearch(readInt(input,
                            "Enter value to search: "));
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
