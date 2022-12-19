package com.example.hs_back.book.sevices.impl;

import com.example.hs_back.book.dtos.BooksDTO;
import com.example.hs_back.book.mappers.BooksMapper;
import com.example.hs_back.book.repositories.BooksRepository;
import com.example.hs_back.book.sevices.BooksService;
import com.example.hs_back.entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private BooksMapper booksMapper;

    // validation
    @Override
    public String entityValidation(Long id) {
        String validation = booksRepository.entityValidation(id);
        return validation == null ? "null" : validation;
    }

    // select all
    @Override
    public Page<BooksDTO> findAll(Pageable pageable) {
        // 한 번에 몇개의 페이지를 조회할 것인지 설정
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1, 10, Sort.by(Sort.Direction.DESC, "id"));

        Page<Books> entity = booksRepository.findAll(pageable);

        if(entity.getTotalPages()!=0) {
            return new PageImpl<>(booksMapper.toDtoList(entity.getContent()),pageable, entity.getTotalElements());
        } else {
            return null;
        }
    }

    // select one
    @Override
    public BooksDTO findByID(Long id) {
        Optional<Books> entity = booksRepository.findById(id);
        BooksDTO dto;
        if(entity.isPresent()) {
            dto = booksMapper.toDto(entity.get());
            return dto;
        } else {
            return null;
        }
    }

    // search
    @Override
    public Page<BooksDTO> searchBooks(BooksDTO dto, Pageable pageable) {
        System.out.println("serviceimpl: "+dto.getTitle());
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1, 10, Sort.by(Sort.Direction.DESC, "id"));

        List<Books> searches = booksRepository.searchBooks(booksMapper.toEntity(dto), pageable);

        List<BooksDTO> dtos = booksMapper.toDtoList(searches);
        return new PageImpl<>(dtos, pageable, dtos.size());
    }

    // insert
    @Override
    public BooksDTO insertBook(BooksDTO dto) {
        Books entity = booksRepository.save(booksMapper.toEntity(dto));
        return booksMapper.toDto(entity);
    }

    // delete
    @Override
    public void deleteByIds(List<Long> idList) {
        booksRepository.deleteByIds(idList);
    }

    // update
    @Override
    public void updateModel(BooksDTO dto) {
        Books entity = booksMapper.toEntity(dto);
        booksRepository.save(entity);
    }
}
