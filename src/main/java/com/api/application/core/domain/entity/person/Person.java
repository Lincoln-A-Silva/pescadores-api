package com.api.application.core.domain.entity.person;

import com.api.application.core.domain.dto.Type;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_person")
@Where(clause = "deleted=false")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String region;

    @Column(nullable = false)
    String fishes;

    @Column(nullable = false)
    String phoneNumber;

    @Column(nullable = false)
    Type type;

    @Column(nullable = false)
    private Boolean deleted = false;
}
