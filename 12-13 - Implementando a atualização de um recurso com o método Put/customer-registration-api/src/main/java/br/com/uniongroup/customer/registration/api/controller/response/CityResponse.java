package br.com.uniongroup.customer.registration.api.controller.response;

import lombok.Data;

@Data
public class CityResponse {

    private Long id;

    private String name;

    private String stateName;
}
