package com.proyecto.ReadRift.mappers;

import com.proyecto.ReadRift.dtos.BookRequestDto;
import com.proyecto.ReadRift.dtos.BookResponseDto;
import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    @Autowired
    private BookRepository bookRepository;


    public BookResponseDto toResponse(Book book) {
        return new BookResponseDto(
                book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getDescription(),
                book.getCondition(),
                book.getAvailable(),
                book.getUrl_image(),
                book.getIsbn(),
                book.getOwnerId(),
                book.getCreatedAt(),
                book.getUpdatedAt()
        );
    }

    public List<BookResponseDto> toResponse(List<Book> books) {
        return books.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

   public Book toModel(BookRequestDto bookRequestDto) {
        return new Book(
                null,
                bookRequestDto.getAuthor(),
                bookRequestDto.getTitle(),
                bookRequestDto.getDescription(),
                bookRequestDto.getCondition(),
                bookRequestDto.getAvailable(),
                bookRequestDto.getUrl_image(),
                bookRequestDto.getIsbn(),
                bookRequestDto.getOwnerId(),
                LocalDateTime.now(),
                LocalDateTime.now()

        );
    }
    public Book toModel(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + bookId));
    }
}
