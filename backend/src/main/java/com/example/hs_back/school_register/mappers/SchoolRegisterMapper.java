package com.example.hs_back.school_register.mappers;

import com.example.hs_back.entities.SchoolRegisters;
import com.example.hs_back.school_register.dtos.SchoolRegisterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolRegisterMapper {
    SchoolRegisterMapper instance = Mappers.getMapper(SchoolRegisterMapper.class);

    SchoolRegisters toEntity(SchoolRegisterDTO dto);
    SchoolRegisterDTO toDto(SchoolRegisters entity);
    List<SchoolRegisters> toEntityList(List<SchoolRegisterDTO> dtoList);
    List<SchoolRegisterDTO> toDtoList(List<SchoolRegisterDTO> entityList);

}
