package com.alejandro.relationshipexample.services;

import com.alejandro.relationshipexample.entities.Book;
import com.alejandro.relationshipexample.entities.Editorial;
import com.alejandro.relationshipexample.repositories.EditorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialService {

    private final EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public Editorial saveEditorials(Editorial editorial) {
        return this.editorialRepository.save(editorial);
    }
    public List<Editorial> getAllEditorial() {
        return this.editorialRepository.findAll();
    }

    public List<Book> getBookForEditorial(Long id) {
        Editorial editorial = this.editorialRepository.getById(id);
        return editorial.getBooks();
    }
}
