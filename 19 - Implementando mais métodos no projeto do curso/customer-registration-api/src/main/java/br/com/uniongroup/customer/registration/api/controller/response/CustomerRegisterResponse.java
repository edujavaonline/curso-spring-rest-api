package br.com.uniongroup.customer.registration.api.controller.response;

import br.com.uniongroup.customer.registration.api.model.Address;
import lombok.Data;

import javax.persistence.Embedded;
import java.time.LocalDate;

@Data
public class CustomerRegisterResponse {

    private Long id;

    private String name;

    private String cpf;

    private String gender;

    private LocalDate birthDate;

    private AddressResponse address;

    private Boolean active;
}
