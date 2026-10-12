
import java.util.*;

public class GraphManager {

    // Each vertex stores the vertices connected to it.
    private Map<String, Set<String>> graph = new LinkedHashMap<>();

    // Add a new vertex
    public void addVertex(String vertex) {
        if (graph.containsKey(vertex)) {
            System.out.println("Vertex already exists!");
            return;
        }

        graph.put(vertex, new LinkedHashSet<>());
        System.out.println("Vertex added successfully.");
    }

    // Add an undirected edge
    public void addEdge(String from, String to) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            System.out.println(
                "Both vertices must exist before adding an edge."
            );
            return;
        }

        if (from.equals(to)) {
            System.out.println("A vertex cannot connect to itself.");
            return;
        }

        if (graph.get(from).contains(to)) {
            System.out.println("Edge already exists!");
            return;
        }

        graph.get(from).add(to);
        graph.get(to).add(from);

        System.out.println("Edge added successfully.");
    }

    // Display vertices and their connections
    public void displayGraph() {
        if (graph.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("\nGraph Connections:");

        for (String vertex : graph.keySet()) {
            System.out.println(
                vertex + " -> " + graph.get(vertex)
            );
        }
    }

    // Search for a vertex
    public void searchVertex(String vertex) {
        if (graph.containsKey(vertex)) {
            System.out.println("Vertex " + vertex + " exists.");
        } else {
            System.out.println("Vertex not found.");
        }
    }

    // Breadth-First Search: visit neighbours first
    public void bfs(String start) {
        if (!graph.containsKey(start)) {
            System.out.println("Starting vertex not found.");
            return;
        }

        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbour : graph.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }

        System.out.println();
    }

    // Depth-First Search: explore a path deeply
    public void dfs(String start) {
        if (!graph.containsKey(start)) {
            System.out.println("Starting vertex not found.");
            return;
        }

        Set<String> visited = new LinkedHashSet<>();

        System.out.print("DFS Traversal: ");
        dfsVisit(start, visited);
        System.out.println();
    }

    private void dfsVisit(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (String neighbour : graph.get(vertex)) {
            if (!visited.contains(neighbour)) {
                dfsVisit(neighbour, visited);
            }
        }
    }

    // Graph menu
    public void run(Scanner input) {
        int choice;

        do {
            System.out.println("\n--- GRAPH OPERATIONS ---");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. Search Vertex");
            System.out.println("5. BFS Traversal");
            System.out.println("6. DFS Traversal");
            System.out.println("7. Return to Main Menu");

            choice = readInt(input, "Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex name: ");
                    addVertex(input.next().trim());
                    break;

                case 2:
                    System.out.print("Enter first vertex: ");
                    String from = input.next().trim();

                    System.out.print("Enter second vertex: ");
                    String to = input.next().trim();

                    addEdge(from, to);
                    break;

                case 3:
                    displayGraph();
                    break;

                case 4:
                    System.out.print("Enter vertex to search: ");
                    searchVertex(input.next().trim());
                    break;

                case 5:
                    System.out.print("Enter starting vertex for BFS: ");
                    bfs(input.next().trim());
                    break;

                case 6:
                    System.out.print("Enter starting vertex for DFS: ");
                    dfs(input.next().trim());
                    break;

                case 7:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Choose a number from 1 to 7.");
            }

        } while (choice != 7);
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
