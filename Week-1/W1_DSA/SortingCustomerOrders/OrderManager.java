package SortingCustomerOrders;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}

public class OrderManager {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // Swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                // Swap
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap pivot
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 450.0),
            new Order(102, "Bob", 120.5),
            new Order(103, "Charlie", 230.0),
            new Order(104, "David", 320.75)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Bubble Sort
        bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort:");
        printOrders(orders);

        // Re-initialize for Quick Sort
        orders = new Order[] {
            new Order(101, "Alice", 450.0),
            new Order(102, "Bob", 120.5),
            new Order(103, "Charlie", 230.0),
            new Order(104, "David", 320.75)
        };

        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nAfter Quick Sort:");
        printOrders(orders);
    }

    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
