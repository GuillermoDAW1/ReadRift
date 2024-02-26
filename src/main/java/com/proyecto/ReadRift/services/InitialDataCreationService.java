package com.proyecto.ReadRift.services;
import com.proyecto.ReadRift.models.ExchangeStatus;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.Exchange;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class InitialDataCreationService {
    private final BookService bookService;
    private final ExchangeService exchangeService;
    private final UserDetailsServiceImpl userDetailsService;
    private final Faker faker = new Faker(new Locale("en-US"));

    public void createDefaultUser(int number) {
        if(number <= 0) return;
        for (int i = 0; i < number; i++) {
            User user = new User("user"+i, "$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO"); // Esto es "password" codificado con bcrypt)
            userDetailsService.save(user);
        }
    }

    public void createFakeBooks(int number) {
        if(number <= 0) return;
        for (int i = 0; i < number; i++) {
            Book book = new Book(
                    null,
                UUID.randomUUID(),
            faker.book().author(),
            faker.book().title(),
            faker.lorem().characters(255),
            faker.options().option("New", "Used", "Damaged"),
            faker.bool().bool(),
            faker.internet().image(),
            faker.code().isbn10(),
            null,
            LocalDateTime.now(),
            LocalDateTime.now()
            );
            bookService.save(book);
        }
    }
    public void createFakeExchanges(int number) {
        if(number <= 0) return;
        List<User> users = userDetailsService.findAll();
        List<Book> books = bookService.findAll();
        String[] statusValues = {"PENDING", "APPROVED", "COMPLETED", "CANCELLED"};
        int randomIndex = faker.number().numberBetween(0, statusValues.length);


        for (int i = 0; i < number; i++) {
            Exchange exchange = new Exchange(
                    null,
                    UUID.randomUUID(),
                    userDetailsService.findById((long) faker.number().numberBetween(1,users.size())),
                    userDetailsService.findById((long) faker.number().numberBetween(1,users.size())),
                    bookService.findById((long) faker.number().numberBetween(1,books.size())),
                    ExchangeStatus.valueOf(statusValues[randomIndex])
            );
            exchangeService.save(exchange);
        }
    }
}