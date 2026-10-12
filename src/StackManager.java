
import java.util.Scanner;

public class StackManager {

    private int[] stack = new int[100];
    private int top = -1;

    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full!");
            return;
        }

        stack[++top] = value;
        System.out.println("Value pushed successfully.");
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty! Nothing to pop.");
            return;
        }

        System.out.println("Popped value: " + stack[top]);
        top--;
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.println("Top value: " + stack[top]);
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack values (top to bottom):");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public void run(Scanner input) {
        int choice;

        do {
            System.out.println("\n--- STACK OPERATIONS ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
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
                    System.out.print("Enter a value to push: ");
                    while (!input.hasNextInt()) {
                        System.out.println("Please enter a whole number.");
                        input.nextLine();
                        System.out.print("Enter a value to push: ");
                    }
                    push(input.nextInt());
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    peek();
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
