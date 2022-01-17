package br.com.uniongroup.custome.registration.api.controller.request;

import lombok.Data;

@Data
public class AddressRequest {

    private String zipCode;

    private String streetName;

    private String number;

    private String complement;

    private String neighborhood;

    private CityIdRequest city;
}
