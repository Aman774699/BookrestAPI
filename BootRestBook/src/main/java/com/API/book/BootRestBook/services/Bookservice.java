package com.API.book.BootRestBook.services;

import com.API.book.BootRestBook.Entities.Book;
import com.API.book.BootRestBook.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bookservice {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getallbook() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getbookbyid(int id) {
        Book singlebook = this.bookRepository.findById(id);
        return singlebook;
    }

    //add book
    public Book addbook(Book b) {
        Book result = this.bookRepository.save(b);
        return result;
    }

    //delete book
    public String Removebook(int id) {
        this.bookRepository.deleteById(id);
        return "Book Removed successfully...";
    }

    public void updatebook(Book book1, int id) {
        book1.setId(id);
        this.bookRepository.save(book1);
    }
}

