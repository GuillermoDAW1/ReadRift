package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Puedes agregar más métodos de servicio según sea necesario
}