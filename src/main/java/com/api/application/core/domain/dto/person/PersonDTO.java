package com.api.application.core.domain.dto.person;

import com.api.application.core.domain.dto.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonDTO {
    String name;
    String region;
    String fishes;
    String phoneNumber;
    Type type;
}
