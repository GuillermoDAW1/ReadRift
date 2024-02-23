package com.proyecto.ReadRift.mappers;

import com.proyecto.ReadRift.dtos.BookRequestDto;
import com.proyecto.ReadRift.dtos.BookResponseDto;
import com.proyecto.ReadRift.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Component
public class BookMapper {

    private final ExchangeMapper exchangeMapper;

    @Autowired
    public BookMapper(ExchangeMapper exchangeMapper) {
        this.exchangeMapper = exchangeMapper;
    }


    public BookResponseDto toResponse(Book book) {
        return new BookResponseDto(
                book.getId(),
                book.getUuid(),
                book.getAuthor(),
                book.getTitle(),
                book.getDescription(),
                book.getCondition(),
                book.isAvailable(),
                book.getUpdatedAt(),
                book.getUrlImage(),
                book.getIsbn(),
                book.getOwner(),
                book.getCreatedAt(),
                book.getUpdatedAt(),
                );
    }

    public List<BookResponseDto> toResponse(List<Book> books) {
        return books.stream()
                .map(this::toResponse)
                .toList();
    }

    // Mapeamos de DTO a modelo
    public Book toModel(BookRequestDto bookRequestDto) {
        return new Book(
                0L,
                UUID.randomUUID(),
                BookRequestDto.getAuthor(),
                BookRequestDto.getTitle(),
                LocalDateTime.now(), // TODO: esto está puesto a piñón fijo pero no es así.
                productRequestDto.getToBuy(),
                LocalDateTime.now(), // TODO: esto está puesto a piñón fijo pero no es así.
                productRequestDto.getToCheck(),
                LocalDateTime.now(), // TODO: esto está puesto a piñón fijo pero no es así.
                productRequestDto.getCategoryId() != null ?
                        categoryMapper.toModelfromRequestDto(productRequestDto.getCategoryId()) : null,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}

