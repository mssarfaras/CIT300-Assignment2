
import java.util.Scanner;

public class QueueManager {
    private int[] queue = new int[100];
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    public void enqueue(int value) {
        if (size == queue.length) {
            System.out.println("Queue is full!");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;

        System.out.println("Value added to queue successfully.");
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty! Nothing to remove.");
            return;
        }

        System.out.println("Removed value: " + queue[front]);
        front = (front + 1) % queue.length;
        size--;
    }

    public void showFront() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Front value: " + queue[front]);
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue values (front to rear): ");

        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + " ");
        }

        System.out.println();
    }

    public void run(Scanner input) {
        int choice;

        do {
            System.out.println("\n--- QUEUE OPERATIONS ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Show Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                input.nextLine();
                System.out.print("Enter your choice: ");
            }

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to add: ");

                    while (!input.hasNextInt()) {
                        System.out.println("Please enter a whole number.");
                        input.nextLine();
                        System.out.print("Enter a value to add: ");
                    }

                    enqueue(input.nextInt());
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    showFront();
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
}
