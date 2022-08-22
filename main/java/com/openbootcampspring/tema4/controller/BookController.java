package com.openbootcampspring.tema4.controller;
import com.openbootcampspring.tema4.entities.Book;
import com.openbootcampspring.tema4.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/api/books")
    public List<Book> findAll(){

        return bookRepository.findAll();
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        bookRepository.findById(id);
        Optional<Book> bookOpt = bookRepository.findById(id);
        //opcion 1
        if (bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else {
            return ResponseEntity.notFound().build();
        }
        //opcion 2
        //return bookOpt.orElse(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        System.out.println(headers.get("Host"));
        bookRepository.save(book);
        return bookRepository.save(book);
    }
}
