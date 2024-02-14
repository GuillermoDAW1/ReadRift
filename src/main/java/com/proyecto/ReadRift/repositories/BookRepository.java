package com.proyecto.ReadRift.repositories;
import com.proyecto.ReadRift.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Puedes agregar métodos personalizados de consulta si es necesario
}