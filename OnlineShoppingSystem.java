import java.util.*;

public class OnlineShoppingSystem {

    public static void main(String[] args) {
        // Create WebUser
        WebUser user = new WebUser("user123", "pass123", "user@example.com");

        // Create Customer
        Customer customer = new Customer("C001", "123 Main St", new Date());

        // Create Products
        Product p1 = new Product("P001", "Laptop", "Tech Supplier");
        Product p2 = new Product("P002", "Headphones", "Audio Supplier");

        // Create ShoppingCart and add LineItems
        ShoppingCart cart = new ShoppingCart(new Date());
        cart.addItem(new LineItem(p1, 1, 800.0));
        cart.addItem(new LineItem(p2, 2, 50.0));

        // Create Order
        Order order = new Order("O001", new Date(), 900.0);
        order.setShipToDate(new Date());
        order.setStatus(OrderStatus.SHIPPED);

        // Create Payment
        Payment payment = new Payment("PAY001", new Date(), 900.0);

        // Output
        System.out.println("Order No: " + order.getNumber());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Paid: " + payment.getTotal() + " on " + payment.getPaidDate());
    }
}

// ------------ WebUser Class ------------
class WebUser {
    private String loginId;
    private String password;
    private String email;

    public WebUser(String loginId, String password, String email) {
        this.loginId = loginId;
        this.password = password;
        this.email = email;
    }

    // Getters and setters (can be added if needed)
}

// ------------ Customer Class ------------
class Customer {
    private String id;
    private String billingAddress;
    private boolean isClosed;
    private Date openDate;
    private Date closedDate;

    public Customer(String id, String billingAddress, Date openDate) {
        this.id = id;
        this.billingAddress = billingAddress;
        this.openDate = openDate;
        this.isClosed = false;
    }

    // Getters and setters (can be added if needed)
}

// ------------ Account Class ------------
class Account {
    private String id;
    private String billingAddress;
    private boolean isClosed;
    private Date openDate;
    private Date closedDate;

    public Account(String id, String billingAddress, Date openDate) {
        this.id = id;
        this.billingAddress = billingAddress;
        this.openDate = openDate;
        this.isClosed = false;
    }

    // Getters and setters (can be added if needed)
}

// ------------ ShoppingCart Class ------------
class ShoppingCart {
    private Date createdDate;
    private List<LineItem> items = new ArrayList<>();

    public ShoppingCart(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void addItem(LineItem item) {
        items.add(item);
    }

    // Getters and setters (can be added if needed)
}

// ------------ LineItem Class ------------
class LineItem {
    private int quantity;
    private double price;
    private Product product;

    public LineItem(Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters (can be added if needed)
}

// ------------ Product Class ------------
class Product {
    private String id;
    private String name;
    private String supplier;

    public Product(String id, String name, String supplier) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
    }

    // Getters and setters (can be added if needed)
}

// ------------ Order Class ------------
class Order {
    private String number;
    private Date orderedDate;
    private Date shipToDate;
    private double total;
    private OrderStatus status;

    public Order(String number, Date orderedDate, double total) {
        this.number = number;
        this.orderedDate = orderedDate;
        this.total = total;
        this.status = OrderStatus.NEW;
    }

    public String getNumber() {
        return number;
    }

    public double getTotal() {
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Date getPaidDate() {
        return orderedDate;
    }

    public void setShipToDate(Date date) {
        this.shipToDate = date;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

// ------------ OrderStatus Enum ------------
enum OrderStatus {
    NEW, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}

// ------------ Payment Class ------------
class Payment {
    private String id;
    private Date paidDate;
    private double total;

    public Payment(String id, Date paidDate, double total) {
        this.id = id;
        this.paidDate = paidDate;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public Date getPaidDate() {
        return paidDate;
    }
}
