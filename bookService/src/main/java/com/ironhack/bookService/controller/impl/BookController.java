package com.ironhack.bookService.controller.impl;

import com.ironhack.bookService.client.BookFormatClient;
import com.ironhack.bookService.controller.dto.BookDto;
import com.ironhack.bookService.controller.dto.BookFormatDto;
import com.ironhack.bookService.controller.interfaces.IBookController;
import com.ironhack.bookService.model.Book;
import com.ironhack.bookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController implements IBookController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private BookFormatClient bookFormatClient;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBook (@PathVariable("isbn") String isbn) {

        String[] url = bookFormatClient.getBookFormat(isbn);

        Optional<Book> book = bookRepository.findById(isbn);
        if (book.isPresent()) {
            BookDto bookDto = new BookDto();
            bookDto.setIsbn(book.get().getIsbn());
            bookDto.setTitle(book.get().getTitle());
            bookDto.setAuthor(book.get().getAuthor());
            bookDto.setGenre(book.get().getGenre());
            bookDto.setFormats(url);

            return bookDto;

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found");
        }
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book registerNewBook(@RequestBody @Valid BookDto bookDto){

        Book book = new Book();
        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());


        BookFormatDto bookFormatDto = new BookFormatDto(bookDto.getIsbn(), bookDto.getFormats());

        bookFormatClient.createBookFormat((bookFormatDto));

        return bookRepository.save(book);
    }



}
