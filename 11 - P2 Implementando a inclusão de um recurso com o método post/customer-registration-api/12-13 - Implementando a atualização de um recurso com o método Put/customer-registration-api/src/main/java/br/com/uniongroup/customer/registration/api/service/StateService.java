package br.com.uniongroup.customer.registration.api.service;

import br.com.uniongroup.customer.registration.api.controller.response.StateResponse;
import br.com.uniongroup.customer.registration.api.mapper.StateMapper;
import br.com.uniongroup.customer.registration.api.model.State;
import br.com.uniongroup.customer.registration.api.repository.StateRepository;
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

    public StateResponse findById(Long id) {
        State state = stateRepository.findById(id).get();
        return stateMapper.fromStateToStateResponse(state);
    }
}
