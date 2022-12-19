package com.example.hs_back.book.mappers;

import com.example.hs_back.book.dtos.BooksDTO;
import com.example.hs_back.entities.Books;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BooksMapper{
    BooksMapper instance = Mappers.getMapper(BooksMapper.class);

    Books toEntity(BooksDTO dto);
    BooksDTO toDto(Books entity);
    List<Books> toEntityList(List<BooksDTO> dtoList);
    List<BooksDTO> toDtoList(List<Books> entityList);

    // dto -> entity에서 null이 아닌 값만 update되도록
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateFromDto(BooksDTO dto, @MappingTarget Books entity);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateFromEntity(@MappingTarget BooksDTO dto, Books entity);

//    변수명과 필드명이 다르면 수동으로 매핑해야함
//    @Override
//    @Mapping(source="name", target="modelName")
//    DTO toDto(Entity entity);
}
