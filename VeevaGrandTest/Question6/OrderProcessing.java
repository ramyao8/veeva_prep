package Question6;

import java.util.*;
// Item class
class Item {
    String name;
    double price;
    int quantity;
    int reorderLevel;

    Item(String name, double price, int quantity, int reorderLevel) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }
}

// Customer class
class Customer {
    String name, address, phone, email;

    Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}

// Order class
class Order {
    int orderId;
    Customer customer;
    Map<Item, Integer> items = new HashMap<>();
    Date date;
    double totalAmount = 0;

    Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.date = new Date();
    }

    void addItem(Item item, int qty) {
        items.put(item, qty);
        totalAmount += item.price * qty;
    }
}

public class OrderProcessing {

    static Scanner sc = new Scanner(System.in);

    static List<Item> itemList = new ArrayList<>();
    static List<Customer> customerList = new ArrayList<>();
    static List<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== ORDER SYSTEM MENU =====");
            System.out.println("1. Add Item");
            System.out.println("2. Add Customer");
            System.out.println("3. Place Order");
            System.out.println("4. Search Item by Name");
            System.out.println("5. Search Item by Price");
            System.out.println("6. Get Order by ID");
            System.out.println("7. Get Orders by Customer");
            System.out.println("8. Highest Order");
            System.out.println("9. Lowest Order");
            System.out.println("10. Last Week Orders");
            System.out.println("11. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addItem();
                    break;

                case 2:
                    addCustomer();
                    break;

                case 3:
                    placeOrder();
                    break;

                case 4:
                    System.out.print("Enter item name: ");
                    String name = sc.next();
                    findItemByName(name);
                    break;

                case 5:
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    findItemsByPrice(price);
                    break;

                case 6:
                    System.out.print("Enter order id: ");
                    int id = sc.nextInt();
                    getOrderById(id);
                    break;

                case 7:
                    System.out.print("Enter customer name: ");
                    String cname = sc.next();
                    getOrdersByCustomer(cname);
                    break;

                case 8:
                    highestOrder();
                    break;

                case 9:
                    lowestOrder();
                    break;

                case 10:
                    lastWeekOrders();
                    break;

                case 11:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 11);
    }

    // Add Item
    static void addItem() {

        System.out.print("Enter item name: ");
        String name = sc.next();

        System.out.print("Enter item price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter reorder level: ");
        int reorder = sc.nextInt();

        itemList.add(new Item(name, price, quantity, reorder));

        System.out.println("Item added successfully");
    }

    // Add Customer
    static void addCustomer() {

        System.out.print("Enter customer name: ");
        String name = sc.next();

        System.out.print("Enter address: ");
        String address = sc.next();

        System.out.print("Enter phone: ");
        String phone = sc.next();

        System.out.print("Enter email: ");
        String email = sc.next();

        customerList.add(new Customer(name, address, phone, email));

        System.out.println("Customer added successfully");
    }

    // Place Order
    static void placeOrder() {

        if (customerList.isEmpty() || itemList.isEmpty()) {
            System.out.println("Add customer and item first.");
            return;
        }

        System.out.print("Enter order id: ");
        int id = sc.nextInt();

        System.out.print("Enter customer name: ");
        String cname = sc.next();

        Customer c = null;

        for (Customer cust : customerList) {
            if (cust.name.equalsIgnoreCase(cname)) {
                c = cust;
            }
        }

        if (c == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter item name: ");
        String itemName = sc.next();

        Item selected = null;

        for (Item i : itemList) {
            if (i.name.equalsIgnoreCase(itemName)) {
                selected = i;
            }
        }

        if (selected == null) {
            System.out.println("Item not found.");
            return;
        }

        if (selected.quantity <= selected.reorderLevel) {
            System.out.println("Stock low. Cannot place order.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        if (qty > selected.quantity) {
            System.out.println("Not enough stock");
            return;
        }

        Order order = new Order(id, c);
        order.addItem(selected, qty);

        selected.quantity -= qty;
        orderList.add(order);

        System.out.println("Order placed successfully");
    }

    // Search Item by Name
    static void findItemByName(String name) {

        boolean found = false;

        for (Item i : itemList) {
            if (i.name.equalsIgnoreCase(name)) {
                System.out.println("Item: " + i.name + " Price: " + i.price + " Quantity: " + i.quantity);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Item not found");
        }
    }

    // Search Item by Price
    static void findItemsByPrice(double price) {

        boolean found = false;

        for (Item i : itemList) {
            if (i.price == price) {
                System.out.println("Item: " + i.name);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No items found with this price");
        }
    }

    // Get Order by ID
    static void getOrderById(int id) {

        boolean found = false;

        for (Order o : orderList) {
            if (o.orderId == id) {
                System.out.println("Order Found: " + o.orderId + " Amount: " + o.totalAmount);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Order not found");
        }
    }

    // Get Orders by Customer
    static void getOrdersByCustomer(String name) {

        boolean found = false;

        for (Order o : orderList) {
            if (o.customer.name.equalsIgnoreCase(name)) {
                System.out.println("Order ID: " + o.orderId + " Amount: " + o.totalAmount);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No orders found for this customer");
        }
    }

    // Highest Order
    static void highestOrder() {

        if (orderList.isEmpty()) {
            System.out.println("No orders available");
            return;
        }

        Order max = orderList.get(0);

        for (Order o : orderList) {
            if (o.totalAmount > max.totalAmount) {
                max = o;
            }
        }

        System.out.println("Highest Order ID: " + max.orderId + " Amount: " + max.totalAmount);
    }

    // Lowest Order
    static void lowestOrder() {

        if (orderList.isEmpty()) {
            System.out.println("No orders available");
            return;
        }

        Order min = orderList.get(0);

        for (Order o : orderList) {
            if (o.totalAmount < min.totalAmount) {
                min = o;
            }
        }

        System.out.println("Lowest Order ID: " + min.orderId + " Amount: " + min.totalAmount);
    }

    // Orders in Last Week
    static void lastWeekOrders() {

        if (orderList.isEmpty()) {
            System.out.println("No orders available");
            return;
        }

        Date now = new Date();
        boolean found = false;

        for (Order o : orderList) {

            long diff = now.getTime() - o.date.getTime();
            long days = diff / (1000 * 60 * 60 * 24);

            if (days <= 7) {
                System.out.println("Recent Order ID: " + o.orderId);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No orders in last week");
        }
    }
}