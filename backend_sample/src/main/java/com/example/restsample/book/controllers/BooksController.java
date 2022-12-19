package com.example.hs_back.book.controllers;

import com.example.hs_back.book.dtos.BooksDTO;
import com.example.hs_back.book.sevices.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/")
public class BooksController {
    @Autowired
    BooksService booksService;

    // select all
    @GetMapping(path="/book", produces="application/json")
    public ResponseEntity<?> getAllBooks(final Pageable pageable, HttpServletResponse response) {
        Page<BooksDTO> books = booksService.findAll(pageable);

        if(books!=null) {
            return new ResponseEntity<>(books, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    // select one
    @GetMapping(path="/books/{id}", produces="application/json")
    public ResponseEntity<?> getBooksById(@PathVariable("id") Long id) {
        BooksDTO dto = booksService.findByID(id);
        if(dto==null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // search
    @GetMapping(path="/books/search", produces="application/json")
    public ResponseEntity<?> searchBooks(BooksDTO dto, final Pageable pageable) {
        System.out.println(dto);
        System.out.println(dto.getTitle());
        if(dto.getTitle()!=null && dto.getTitle().length()<2 ||
            dto.getAuthor()!=null && dto.getAuthor().length()<2) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Page<BooksDTO> books = booksService.searchBooks(dto, pageable);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    // insert
    @PostMapping(path = "/book", produces = "application/json")
    public ResponseEntity<?> insertBooks(BooksDTO dto) {
        if(dto!=null && dto.getId()==null && dto.getTitle()!=null) {
            BooksDTO insertedDTO = booksService.insertBook(dto);
            return new ResponseEntity<>(insertedDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    // delete one/many
    @DeleteMapping(path ="books/{ids}", produces="application/json")
    public ResponseEntity<?> deleteBooks(@PathVariable("ids") String ids) {
        // id validation
        if(!Pattern.matches("^[0-9,]*$", ids)) {
            return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
        }

        List<Long> idList = new ArrayList<>();
        String[] list = ids.split(",");

        for(String id : list) {
            Long tmp = Long.parseLong(id);
            String valid = booksService.entityValidation(tmp);

            if(!valid.equals("null") && !idList.contains(tmp)) {
                idList.add(tmp);
            } else {
                return new ResponseEntity<>(false,HttpStatus.FORBIDDEN);
            }
        }

        // exception
        if(idList.isEmpty()) {
            return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
        }

        booksService.deleteByIds(idList);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    // update one
    @PutMapping(path="/books/{id}", produces="application/json")
    public ResponseEntity<?> updateBook(@PathVariable("id") Long id, BooksDTO dto) {
        BooksDTO updateDTO = booksService.findByID(id);

        if(updateDTO != null) {
            String title = dto.getTitle() != null ? dto.getTitle() : updateDTO.getTitle();
            String author = dto.getAuthor() != null ? dto.getAuthor() : updateDTO.getAuthor();

            updateDTO.setTitle(title);
            updateDTO.setAuthor(author);

            booksService.updateModel(updateDTO);
            BooksDTO updatedDTO = booksService.findByID(id);

            return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Updated",HttpStatus.BAD_REQUEST);
        }
    }
}
