package br.com.uniongroup.customer.registration.api.controller.request;

import lombok.Data;

@Data
public class CityRequest {

    private String name;

    private StateIdRequest state;
}
