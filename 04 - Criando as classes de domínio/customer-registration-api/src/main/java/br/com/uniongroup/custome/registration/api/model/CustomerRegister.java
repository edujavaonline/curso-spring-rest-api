package br.com.uniongroup.custome.registration.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embedded;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerRegister {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String cpf;

    private String gender;

    private LocalDate birthDate;

    @Embedded
    private Address address;

    private Boolean active = Boolean.TRUE;

    private OffsetDateTime createDate;

    private OffsetDateTime upDate;
}
