package com.example.hs_back.book.sevices;

import com.example.hs_back.book.dtos.BooksDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BooksService {
    public String entityValidation(Long id);
    public Page<BooksDTO> findAll(Pageable pageable);
    public BooksDTO findByID(Long id);
    public Page<BooksDTO> searchBooks(BooksDTO dto, Pageable pageable);
    public BooksDTO insertBook(BooksDTO dto);
    public void deleteByIds(List<Long> idList);
    public void updateModel(BooksDTO dto);
}
