package com.example.hs_back.book.repositories.custom;

import com.example.hs_back.entities.Books;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BooksRepositoryCustom {
    public List<Books> searchBooks(Books entity, Pageable pageable);
}
