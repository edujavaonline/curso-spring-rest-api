package br.com.uniongroup.custome.registration.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String email;

    private String password;

    private OffsetDateTime createDate;

    private List<Permission> permissions = new ArrayList<>();
}