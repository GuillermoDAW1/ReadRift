package com.proyecto.ReadRift.repositories;
import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
    List<Book> findByCondition(String condition);
    List<Book> findByAvailableTrue();
    Book findByIsbn(String isbn);
    List<Book> findByOwner(User owner);

    Book findByUuid(UUID uuid);

    // Puedes agregar métodos personalizados de consulta si es necesario
}