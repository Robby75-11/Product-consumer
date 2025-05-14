package ecommerce;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DataInitializer {

    public static List<Customer>initializeCustomers() {
        return Arrays.asList(
                new Customer(1L, "Alice", 1),
                new Customer(2L, "Roberto", 2),
                new Customer(1L, "Luca", 1),
                new Customer(1L, "Giulia", 2)
        );

    }

    public static List<Product> initializeProducts() {
        return Arrays.asList(
                new Product(101L, "The Lord of the Rings", "Books", 125.50),
                new Product(102L, "Harry Potter", "Books", 99.99),
                new Product(201L, "pannolini", "Baby", 35.00),
                new Product(202L, "Passeggino", "Baby", 150.00),
                new Product(301L, "Action Figure", "Boys", 25.75),
                new Product(302L, "Toy Car", "Boys", 45.20)
        );
    }
    public static List<Order> initializeOrders(List<Customer> customers, List<Product> products) {
        return Arrays.asList(
                new Order(1001L, "COMPLETED", LocalDate.of(2021, 1, 15), LocalDate.of(2021, 1, 20), Arrays.asList(products.get(0), products.get(1)), customers.get(0)),
                new Order(1002L, "PENDING", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15), Arrays.asList(products.get(2)), customers.get(1)),
                new Order(1003L, "COMPLETED", LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 5), Arrays.asList(products.get(3), products.get(4)), customers.get(3)),
                new Order(1004L, "SHIPPED", LocalDate.of(2021, 3, 20), LocalDate.of(2021, 3, 25), Arrays.asList(products.get(5)), customers.get(1))
        );
    }

}
