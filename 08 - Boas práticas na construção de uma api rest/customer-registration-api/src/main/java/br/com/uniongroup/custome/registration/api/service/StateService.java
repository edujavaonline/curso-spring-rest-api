package br.com.uniongroup.custome.registration.api.service;

import br.com.uniongroup.custome.registration.api.controller.response.StateResponse;
import br.com.uniongroup.custome.registration.api.mapper.StateMapper;
import br.com.uniongroup.custome.registration.api.model.State;
import br.com.uniongroup.custome.registration.api.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private StateMapper stateMapper;

    public List<StateResponse> findAll() {
        List<State> states = stateRepository.findAll();
        return stateMapper.fromListStateToListStateResponse(states);
    }
}
