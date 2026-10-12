
import java.util.Arrays;
import java.util.Scanner;

public class PerformanceManager {

    public void run(Scanner input) {
        System.out.println("\n======================================");
        System.out.println("       PERFORMANCE COMPARISON");
        System.out.println("======================================");

        System.out.print("Enter numbers separated by spaces: ");
        String line = input.nextLine().trim();

        while (line.isEmpty()) {
            System.out.println("Please enter at least one number.");
            System.out.print("Enter numbers separated by spaces: ");
            line = input.nextLine().trim();
        }

        String[] parts = line.split("\\s+");
        int[] numbers = new int[parts.length];

        try {
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Use whole numbers separated by spaces.");
            return;
        }

        System.out.print("Enter the value to search for: ");

        while (!input.hasNextInt()) {
            System.out.println("Invalid input! Enter a whole number.");
            input.nextLine();
            System.out.print("Enter the value to search for: ");
        }

        int target = input.nextInt();
        input.nextLine();

        // Linear Search
        int linearSteps = 0;
        int linearIndex = -1;

        long linearStart = System.nanoTime();

        for (int i = 0; i < numbers.length; i++) {
            linearSteps++;

            if (numbers[i] == target) {
                linearIndex = i;
                break;
            }
        }

        long linearTime = System.nanoTime() - linearStart;

        // Sort a copy before Binary Search
        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted);

        // Binary Search
        int left = 0;
        int right = sorted.length - 1;
        int binarySteps = 0;
        int binaryIndex = -1;

        long binaryStart = System.nanoTime();

        while (left <= right) {
            binarySteps++;
            int middle = left + (right - left) / 2;

            if (sorted[middle] == target) {
                binaryIndex = middle;
                break;
            } else if (sorted[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        long binaryTime = System.nanoTime() - binaryStart;

        // Display comparison
        System.out.println("\nOriginal numbers: "
                + Arrays.toString(numbers));

        System.out.println("\n--- LINEAR SEARCH ---");
        if (linearIndex != -1) {
            System.out.println("Value found at original index "
                    + linearIndex);
        } else {
            System.out.println("Value not found.");
        }
        System.out.println("Steps: " + linearSteps);
        System.out.println("Execution time: " + linearTime + " ns");
        System.out.println("Complexity: O(n)");

        System.out.println("\n--- BINARY SEARCH ---");
        System.out.println("Sorted numbers: "
                + Arrays.toString(sorted));

        if (binaryIndex != -1) {
            System.out.println("Value found at sorted index "
                    + binaryIndex);
        } else {
            System.out.println("Value not found.");
        }
        System.out.println("Steps: " + binarySteps);
        System.out.println("Execution time: " + binaryTime + " ns");
        System.out.println("Search complexity: O(log n)");
        System.out.println("Note: Sorting the numbers takes extra time.");

        System.out.println("\n======================================");
    }
}
