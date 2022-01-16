package br.com.uniongroup.custome.registration.api.controller.request;

import br.com.uniongroup.custome.registration.api.model.Address;
import lombok.Data;

import javax.persistence.Embedded;
import java.time.LocalDate;

@Data
public class CustomerRegisterRequest {

    private String name;

    private String cpf;

    private String gender;

    private LocalDate birthDate;

    private AddressRequest address;
}
