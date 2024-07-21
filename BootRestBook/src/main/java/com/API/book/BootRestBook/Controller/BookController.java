package com.API.book.BootRestBook.Controller;

import com.API.book.BootRestBook.Entities.Book;
import com.API.book.BootRestBook.Repository.BookRepository;
import com.API.book.BootRestBook.services.Bookservice;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    Bookservice bookservice = new Bookservice();
   BookRepository v;
    @GetMapping("/books")
    public ResponseEntity getbooks() {
        List<Book> myboks = this.bookservice.getallbook();
        if (myboks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(myboks));
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity getonebook(@PathVariable("id") int id) {
        Book result = bookservice.getbookbyid(id);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(result));
        }
    }

    @PostMapping("/books")
    public ResponseEntity addbook(@RequestBody Book book) {
        try {
            Book add = this.bookservice.addbook(book);
            return ResponseEntity.of(Optional.of(add));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deletebook(@PathVariable("id") int id) {
        try {
            this.bookservice.Removebook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/books/{id}")
    public Book updatebook(@RequestBody Book book, @PathVariable("id") int id) {
        this.bookservice.updatebook(book, id);
        return book;
    }
}
