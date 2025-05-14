package ecommerce;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Inizializzazione dei dati di esempio utilizzando la classe DataInitializer
        List<Customer> customers = DataInitializer.initializeCustomers();
        List<Product> products = DataInitializer.initializeProducts();
        List<Order> orders = DataInitializer.initializeOrders(customers, products);

        // Esercizio #1: Ottenere una lista di prodotti che appartengono alla categoria "Books" ed hanno un prezzo > 100
        List<Product> libriCostoElevato = products.stream()
                .filter(prodotto -> prodotto.getCategory().equals("Books")) // Filtra i prodotti per categoria "Books"
                .filter(prodotto -> prodotto.getPrice() > 100)            // Filtra i prodotti con prezzo maggiore di 100
                .collect(Collectors.toList());                           // Raccoglie i risultati in una nuova lista
        System.out.println("Esercizio #1: " + libriCostoElevato);

        // Esercizio #2: Ottenere una lista di ordini con prodotti che appartengono alla categoria "Baby"
        List<Order> ordiniConProdottiBaby = orders.stream()
                .filter(ordine -> ordine.getProducts().stream()          // Per ogni ordine, ottiene lo stream dei prodotti
                        .anyMatch(prodotto -> prodotto.getCategory().equals("Baby"))) // Verifica se almeno un prodotto è "Baby"
                .collect(Collectors.toList());                           // Raccoglie gli ordini in una nuova lista
        System.out.println("Esercizio #2: " + ordiniConProdottiBaby);

        // Esercizio #3: Ottenere una lista di prodotti che appartengono alla categoria "Boys" ed applicare 10% di sconto al loro prezzo
        List<Product> prodottiBoysScontati = products.stream()
                .filter(prodotto -> prodotto.getCategory().equals("Boys")) // Filtra i prodotti per categoria "Boys"
                .map(prodotto -> new Product(prodotto.getId(), prodotto.getName(), prodotto.getCategory(), prodotto.getPrice() * 0.9)) // Crea un nuovo prodotto con il prezzo scontato
                .collect(Collectors.toList());                           // Raccoglie i prodotti scontati in una nuova lista
        System.out.println("Esercizio #3: " + prodottiBoysScontati);

        // Esercizio #4: Ottenere una lista di prodotti ordinati da clienti di livello (tier) 2 tra l'01-Feb-2021 e l'01-Apr-2021
        LocalDate dataInizio = LocalDate.of(2021, 2, 1);
        LocalDate dataFine = LocalDate.of(2021, 4, 1 );
    }
}
