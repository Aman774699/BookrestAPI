package com.API.book.BootRestBook.Repository;

import com.API.book.BootRestBook.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findById(int id);
}
