import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> cart = new ArrayList<>();

        System.out.println("Welcome to the Online Shopping System!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View available products");
            System.out.println("2. Add a product to the cart");
            System.out.println("3. Remove a product from the cart");
            System.out.println("4. View cart");
            System.out.println("5. Checkout");
            System.out.println("0. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    displayAvailableProducts();
                    break;
                case 2:
                    System.out.print("Enter the name of the product: ");
                    String productToAdd = scanner.nextLine();
                    addToCart(cart, productToAdd);
                    break;
                case 3:
                    System.out.print("Enter the name of the product to remove: ");
                    String productToRemove = scanner.nextLine();
                    removeFromCart(cart, productToRemove);
                    break;
                case 4:
                    displayCart(cart);
                    break;
                case 5:
                    checkout(cart);
                    return;
                case 0:
                    System.out.println("Thank you for using the Online Shopping System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void displayAvailableProducts() {
        System.out.println("\nAvailable products:");
        System.out.println("1. Laptop");
        System.out.println("2. Smartphone");
        System.out.println("3. Headphones");
    }

    public static void addToCart(List<String> cart, String product) {
        cart.add(product);
        System.out.println(product + " added to the cart.");
    }

    public static void removeFromCart(List<String> cart, String product) {
        if (cart.remove(product)) {
            System.out.println(product + " removed from the cart.");
        } else {
            System.out.println(product + " is not in the cart.");
        }
    }

    public static void displayCart(List<String> cart) {
        System.out.println("\nCart:");
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            for (String product : cart) {
                System.out.println("- " + product);
            }
        }
    }

    public static void checkout(List<String> cart) {
        System.out.println("\nCheckout:");
        if (cart.isEmpty()) {
            System.out.println("The cart is empty. Nothing to checkout.");
        } else {
            System.out.println("Items in the cart:");
            for (String product : cart) {
                System.out.println("- " + product);
            }
            System.out.println("Total: $" + cart.size() * 100);
            System.out.println("Thank you for your purchase!");
        }
    }
}