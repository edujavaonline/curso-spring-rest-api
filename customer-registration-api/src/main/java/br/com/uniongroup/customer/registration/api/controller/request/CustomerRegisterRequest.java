package br.com.uniongroup.customer.registration.api.controller.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRegisterRequest {

    private String name;

    private String cpf;

    private String gender;

    private LocalDate birthDate;

    private AddressRequest address;
}
