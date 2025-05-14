package ecommerce;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Inizializzazione dei clienti
        List<Customer> customers = Arrays.asList(
                new Customer(1L, "Alice", 1),
                new Customer(2L, "Bob", 2),
                new Customer(3L, "Charlie", 1),
                new Customer(4L, "David", 2)
        );

        // Inizializzazione dei prodotti
        List<Product> products = Arrays.asList(
                new Product(101L, "The Lord of the Rings", "Books", 125.50),
                new Product(102L, "Harry Potter", "Books", 99.99),
                new Product(201L, "Wooden Blocks", "Baby", 35.00),
                new Product(202L, "Stroller", "Baby", 150.00),
                new Product(301L, "Action Figure", "Boys", 25.75),
                new Product(302L, "Toy Car", "Boys", 45.20)
        );

        // Inizializzazione degli ordini
        List<Order> orders = Arrays.asList(
                new Order(1001L, "COMPLETED", LocalDate.of(2021, 1, 15), LocalDate.of(2021, 1, 20), Arrays.asList(products.get(0), products.get(1)), customers.get(0)),
                new Order(1002L, "PENDING", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15), Arrays.asList(products.get(2)), customers.get(1)),
                new Order(1003L, "COMPLETED", LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 5), Arrays.asList(products.get(3), products.get(4)), customers.get(3)),
                new Order(1004L, "SHIPPED", LocalDate.of(2021, 3, 20), LocalDate.of(2021, 3, 25), Arrays.asList(products.get(5)), customers.get(1))
        );

        // Esercizio #1
        List<Product> libriCostoElevato = products.stream()
                .filter(prodotto -> prodotto.getCategory().equals("Books"))
                .filter(prodotto -> prodotto.getPrice() > 100)
                .collect(Collectors.toList());
        System.out.println("Esercizio #1: " + libriCostoElevato);

        // Esercizio #2
        List<Order> ordiniConProdottiBaby = orders.stream()
                .filter(ordine -> ordine.getProducts().stream()
                        .anyMatch(prodotto -> prodotto.getCategory().equals("Baby")))
                .collect(Collectors.toList());
        System.out.println("Esercizio #2: " + ordiniConProdottiBaby);

        // Esercizio #3
        List<Product> prodottiBoysScontati = products.stream()
                .filter(prodotto -> prodotto.getCategory().equals("Boys"))
                .map(prodotto -> new Product(prodotto.getId(), prodotto.getName(), prodotto.getCategory(), prodotto.getPrice() * 0.9))
                .collect(Collectors.toList());
        System.out.println("Esercizio #3: " + prodottiBoysScontati);

        // Esercizio #4
        LocalDate dataInizio = LocalDate.of(2021, 2, 1);
        LocalDate dataFine = LocalDate.of(2021, 4, 1);
        List<Product> prodottiClientiTier2 = orders.stream()
                .filter(ordine -> ordine.getCustomer().getTier() == 2)
                .filter(ordine -> ordine.getOrderDate().isAfter(dataInizio) && ordine.getOrderDate().isBefore(dataFine))
                .flatMap(ordine -> ordine.getProducts().stream())
                .collect(Collectors.toList());
        System.out.println("Esercizio #4: " + prodottiClientiTier2);
    }
}