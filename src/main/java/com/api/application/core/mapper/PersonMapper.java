package com.api.application.core.mapper;

import com.api.application.core.domain.dto.person.PersonDTO;
import com.api.application.core.domain.entity.person.Person;

public class PersonMapper {
    private PersonMapper() {
    }

    public static Person createEntityFromDTO(PersonDTO dto) {
        return Person.builder()
                .fishes(dto.getFishes())
                .name(dto.getName())
                .region(dto.getRegion())
                .phoneNumber(dto.getPhoneNumber())
                .type(dto.getType())
                .build();
    }

    public static PersonDTO createDTOFromEntity(Person entity) {
        return PersonDTO.builder()
                .fishes(entity.getFishes())
                .name(entity.getName())
                .region(entity.getRegion())
                .phoneNumber(entity.getPhoneNumber())
                .type(entity.getType())
                .build();
    }
}
