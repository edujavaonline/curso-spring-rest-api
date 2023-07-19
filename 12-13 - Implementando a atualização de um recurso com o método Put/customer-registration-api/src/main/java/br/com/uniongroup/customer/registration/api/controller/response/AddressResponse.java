package br.com.uniongroup.customer.registration.api.controller.response;

import br.com.uniongroup.customer.registration.api.model.City;
import lombok.Data;

@Data
public class AddressResponse {

    private String zipCode;

    private String streetName;

    private String number;

    private String complement;

    private String neighborhood;

    private CityResponse city;
}
