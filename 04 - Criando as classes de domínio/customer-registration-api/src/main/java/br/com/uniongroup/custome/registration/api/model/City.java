package br.com.uniongroup.custome.registration.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class City {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private State state;
}
