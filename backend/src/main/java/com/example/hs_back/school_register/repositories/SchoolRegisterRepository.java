package com.example.hs_back.school_register.repositories;

import com.example.hs_back.entities.SchoolRegisters;
import com.example.hs_back.school_register.repositories.custom.SchoolRegisterRepositoryCustom;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SchoolRegisterRepository  extends JpaRepository<SchoolRegisters, Long>, SchoolRegisterRepositoryCustom {
    @NonNull
    public Optional<SchoolRegisters> findBySchoolId(@NonNull Long school_id);
    public List<SchoolRegisters> findByName(String name);
}
