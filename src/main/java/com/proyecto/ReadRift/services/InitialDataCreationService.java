package com.proyecto.ReadRift.services;
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
    private final ExchangeService productService;
    private final UserDetailsServiceImpl userDetailsService;
    private final Faker faker = new Faker(new Locale("en-US"));

    public void createDefaultAdminUser() {
        User user = new User("user", "$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO"); // Esto es "password" codificado con bcrypt)
        userDetailsService.save(user);
    }

 /*   public void createFakeCategories(int number) {
        if(number <= 0) return;
        for (int i = 0; i < number; i++) {
            Book book = new Book(
                    null,
                    UUID.randomUUID(),
                    faker.commerce().department(),
                    Math.random() <0.50 ? faker.lorem().sentence(10) : null,
                    faker.color().hex(),
                    null,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            bookService.save(book);
        }
    }
    public void createFakeProducts(int number) {
        if(number <= 0) return;
        List<Boook> categories = bookService.findAll();

        for (int i = 0; i < number; i++) {
            int categoryIndex = faker.number().numberBetween(0, categories.size());
            Category category = categories.get(categoryIndex);
            Product product = new Product(
                    null,
                    UUID.randomUUID(),
                    faker.commerce().productName(),
                    Math.random() <0.50 ? faker.lorem().sentence(10) : null,
                    faker.number().randomDouble(1, 0, 2),
                    LocalDateTime.now(),
                    faker.bool().bool(),
                    LocalDateTime.now(),
                    faker.bool().bool(),
                    LocalDateTime.now(),
                    category,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            productService.save(product);
        }
    }*/
}