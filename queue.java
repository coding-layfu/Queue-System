import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
    private static int counter = 1;  // static counter for auto-incremented numbers
    private String name;
    private int number;

    public Customer(String name) {
        this.name = name;
        this.number = counter++;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Customer " + number + " - " + name;
    }
}

public class queue {
    private static Queue<Customer> queue = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> serveCustomer();
                case 3 -> viewQueue();
                case 4 -> System.out.println("Exiting program. Thank you!");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    private static void displayMenu() {
        System.out.println("\n--- Bank Queue System ---");
        System.out.println("1. Add customer to queue");
        System.out.println("2. Serve next customer");
        System.out.println("3. View queue");
        System.out.println("4. Exit");
    }

    private static void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);
        queue.add(customer);
        System.out.println("Customer added: " + customer);
        viewQueue();
    }

    private static void serveCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue.");
        } else {
            Customer served = queue.poll();
            System.out.println("Now serving: " + served);
        }
        viewQueue();
    }

    private static void viewQueue() {
        System.out.println("\nCurrent Queue:");
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            for (Customer c : queue) {
                System.out.println(c);
            }
        }
    }
}
