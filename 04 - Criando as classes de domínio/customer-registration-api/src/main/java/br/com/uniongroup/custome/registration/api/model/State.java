package br.com.uniongroup.custome.registration.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class State {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;
}
