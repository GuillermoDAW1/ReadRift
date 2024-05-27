package com.proyecto.ReadRift.Controllers;

import com.proyecto.ReadRift.dtos.BookRequestDto;
import com.proyecto.ReadRift.dtos.BookResponseDto;
import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.services.BookService;
import com.proyecto.ReadRift.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto) {
        Book book = bookService.save(bookMapper.toModel(bookRequestDto));
        BookResponseDto bookResponseDto = bookMapper.toResponse(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book != null) {
            BookResponseDto bookResponseDto = bookMapper.toResponse(book);
            return ResponseEntity.ok(bookResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long id, @RequestBody BookRequestDto bookRequestDto) {
        Book existingBook = bookService.findById(id);
        if (existingBook != null) {
            Book updatedBook = bookService.update(id, bookMapper.toModel(bookRequestDto));
            BookResponseDto bookResponseDto = bookMapper.toResponse(updatedBook);
            return ResponseEntity.ok(bookResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<Book> books = bookService.findAll();
        List<BookResponseDto> bookResponseDtos = bookMapper.toResponse(books);
        return ResponseEntity.ok(bookResponseDtos);
    }

    @PatchMapping("/{id}/availability")
    public ResponseEntity<BookResponseDto> updateBookAvailability(
            @PathVariable Long id,
            @RequestParam Boolean available) {
        // Llama al método del servicio para actualizar la disponibilidad del libro
        Book updatedBook = bookService.updateAvailability(id, available);

        if (updatedBook != null) {
            // Si el libro se actualiza correctamente, devuelve una respuesta con el libro actualizado
            BookResponseDto bookResponseDto = bookMapper.toResponse(updatedBook);
            return ResponseEntity.ok(bookResponseDto);
        } else {
            // Si el libro no se encuentra, devuelve una respuesta notFound
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/details")
    public ResponseEntity<BookResponseDto> getBookDetails(@PathVariable Long id) {
        Book book = bookService.getBookDetails(id);
        if (book != null) {
            BookResponseDto bookResponseDto = bookMapper.toResponse(book);
            return ResponseEntity.ok(bookResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookResponseDto>> getBooksByAuthor(@PathVariable String author) {
        List<Book> booksByAuthor = bookService.findByAuthor(author);
        List<BookResponseDto> bookResponseDtos = bookMapper.toResponse(booksByAuthor);
        return ResponseEntity.ok(bookResponseDtos);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookResponseDto>> getBooksByTitle(@PathVariable String title) {
        List<Book> booksByTitle = bookService.findByTitle(title);
        List<BookResponseDto> bookResponseDtos = bookMapper.toResponse(booksByTitle);
        return ResponseEntity.ok(bookResponseDtos);
    }

    @GetMapping("/condition/{condition}")
    public ResponseEntity<List<BookResponseDto>> getBooksByCondition(@PathVariable String condition) {
        List<Book> booksByCondition = bookService.findByCondition(condition);
        List<BookResponseDto> bookResponseDtos = bookMapper.toResponse(booksByCondition);
        return ResponseEntity.ok(bookResponseDtos);
    }

    @GetMapping("/available/{true}")
    public ResponseEntity<List<BookResponseDto>> getAvailableBooks() {
        List<Book> availableBooks = bookService.findByAvailableTrue();
        List<BookResponseDto> bookResponseDtos = bookMapper.toResponse(availableBooks);
        return ResponseEntity.ok(bookResponseDtos);
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookResponseDto> getBookByIsbn(@PathVariable String isbn) {
        Book book = bookService.findByIsbn(isbn);
        if (book != null) {
            BookResponseDto bookResponseDto = bookMapper.toResponse(book);
            return ResponseEntity.ok(bookResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Book>> getBooksByOwner(@PathVariable Long ownerId) {
        Long owner_id = new User();
        owner.setId(ownerId); // Suponiendo que tengas un método para obtener un usuario por ID en tu servicio de usuario
        List<Book> books = bookService.findByOwner(owner_id);
        if (books != null && !books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

    @GetMapping("/search")
    public ResponseEntity<List<BookResponseDto>> searchBooks(@RequestParam(required = false) String title,
                                                             @RequestParam(required = false) String author,
                                                             @RequestParam(required = false) String isbn) {
        List<Book> foundBooks = bookService.searchBooks(title, author, isbn);
        List<BookResponseDto> bookResponseDtos = bookMapper.toResponse(foundBooks);
        return ResponseEntity.ok(bookResponseDtos);
    }

}

