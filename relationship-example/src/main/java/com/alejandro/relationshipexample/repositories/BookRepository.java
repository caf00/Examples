package com.alejandro.relationshipexample.repositories;

import com.alejandro.relationshipexample.entities.Author;
import com.alejandro.relationshipexample.entities.Book;
import com.alejandro.relationshipexample.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByAuthor(Author author);
    public List<Book> findByEditorial(Editorial editorial);
}
