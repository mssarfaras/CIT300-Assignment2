
import java.util.Scanner;

public class Main {
    private static final ArrayManager arrayManager = new ArrayManager();
    private static final StackManager stackManager = new StackManager();
    private static final QueueManager queueManager = new QueueManager();
    private static final LinkedListManager linkedListManager = new LinkedListManager();
    private static final SearchingManager searchingManager = new SearchingManager();
    private static final GraphManager graphManager = new GraphManager();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("     DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("========================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                input.nextLine();
                choice = 0;
                continue;
            }

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    arrayManager.run(input);
                    break;

                case 2:
                    stackManager.run(input);
                    break;

                case 3:
                    queueManager.run(input);
                    break;

                case 4:
                    linkedListManager.run(input);
                    break;

                case 5:
                    searchingManager.run(input);
                    break;

                case 6:
                    graphManager.run(input);
                    break;

                case 7: {
                    PerformanceManager performanceManager = new PerformanceManager();
                    performanceManager.run(input);
                    break;
                }

                case 8:
                    displayAllResults();
                    break;

                case 9:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Choose 1 to 9.");
            }

        } while (choice != 9);

        input.close();
    }

    private static void displayAllResults() {
        System.out.println("\n========================================");
        System.out.println("           DISPLAY ALL RESULTS");
        System.out.println("========================================");

        arrayManager.displaySummary();
        stackManager.displaySummary();
        queueManager.displaySummary();
        linkedListManager.displaySummary();
        searchingManager.displaySummary();
        graphManager.displaySummary();
    }
}
