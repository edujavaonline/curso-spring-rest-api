package br.com.uniongroup.customer.registration.api.service;

import br.com.uniongroup.customer.registration.api.controller.request.CustomerRegisterRequest;
import br.com.uniongroup.customer.registration.api.controller.response.CustomerRegisterResponse;
import br.com.uniongroup.customer.registration.api.mapper.CustomerRegisterMapper;
import br.com.uniongroup.customer.registration.api.model.City;
import br.com.uniongroup.customer.registration.api.model.CustomerRegister;
import br.com.uniongroup.customer.registration.api.repository.CustomerRegisterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class CustomerRegisterService {

    @Autowired
    private CustomerRegisterRepository customerRegisterRepository;

    @Autowired
    private CustomerRegisterMapper customerRegisterMapper;

    @Autowired
    private CityService cityService;

    @Transactional
    public CustomerRegisterResponse save(CustomerRegisterRequest customerRegisterRequest) {
        CustomerRegister customerRegister = customerRegisterMapper.fromCustomerRegisterRequestToCustomerRegister(customerRegisterRequest);
        validateCity(customerRegister);
        customerRegister = customerRegisterRepository.save(customerRegister);
        return customerRegisterMapper.fromCustomerRegisterToCustomerResponse(customerRegister);
    }

    @Transactional
    public CustomerRegisterResponse update(Long id, CustomerRegisterRequest customerRegisterRequest) {
        CustomerRegister customerRegister = findById(id);
        customerRegisterMapper.fromCustomerRegisterRequestToCustomerRegister(customerRegisterRequest, customerRegister);
        validateCity(customerRegister);
        customerRegister = customerRegisterRepository.save(customerRegister);
        return customerRegisterMapper.fromCustomerRegisterToCustomerResponse(customerRegister);
    }

    @Transactional
    public CustomerRegisterResponse updatePatch(Long id, Map<String, Object> fields) {
        CustomerRegister customerRegister = findById(id);
        merge(fields, customerRegister);
        validateCity(customerRegister);
        customerRegister = customerRegisterRepository.save(customerRegister);
        return customerRegisterMapper.fromCustomerRegisterToCustomerResponse(customerRegister);
    }

    private void merge(Map<String, Object> fields, CustomerRegister customerRegister) {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerRegister customerRegisterConvert = objectMapper.convertValue(fields, CustomerRegister.class);
        fields.forEach((propertyName, propertyValue) -> {
            Field field = ReflectionUtils.findField(CustomerRegister.class, propertyName);
            field.setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, customerRegisterConvert);

            ReflectionUtils.setField(field, customerRegister, newValue);
        });
    }

    private void validateCity(CustomerRegister customerRegister) {
        City city = cityService.findById(customerRegister.getAddress().getCity().getId());
        customerRegister.getAddress().setCity(city);
    }

    @Transactional
    public void active(Long id) {
        CustomerRegister customerRegister = findById(id);
        customerRegister.active();
    }

    @Transactional
    public void inactive(Long id) {
        CustomerRegister customerRegister = findById(id);
        customerRegister.inactive();
    }

    @Transactional
    public void delete(Long id) {
        customerRegisterRepository.deleteById(id);
    }

    public CustomerRegister findById(Long id) { return customerRegisterRepository.findById(id).get(); }

    public CustomerRegisterResponse findOne(Long id) {
        CustomerRegister customerRegister = findById(id);
        return customerRegisterMapper.fromCustomerRegisterToCustomerResponse(customerRegister);
    }

    public List<CustomerRegisterResponse> findAll() {
        List<CustomerRegister> customerRegisters = customerRegisterRepository.findAll();
        return customerRegisterMapper.fromListCustomerRegisterToListCustomerRegisterResponse(customerRegisters);
    }
}
