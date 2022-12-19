package com.example.hs_back.book.repositories;

import com.example.hs_back.book.repositories.custom.BooksRepositoryCustom;
import com.example.hs_back.entities.Books;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>, BooksRepositoryCustom {
    @NonNull
    public Optional<Books> findById(@NonNull Long id);
    public List<Books> findByTitle(String title);
    public List<Books> findByAuthor(String author);

    @Modifying
    @Transactional
    @Query(" delete from Books m where m.id in :idList ")
    public void deleteByIds(@Param("idList") List<Long> idList);

    // Validation
    @Query(" select m.id from Books m where m.id=:entityId ")
    public String entityValidation(@Param("entityId") Long entityId);
}
