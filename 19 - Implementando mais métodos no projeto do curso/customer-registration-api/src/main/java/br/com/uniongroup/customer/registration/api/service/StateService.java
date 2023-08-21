package br.com.uniongroup.customer.registration.api.service;

import br.com.uniongroup.customer.registration.api.controller.request.StateRequest;
import br.com.uniongroup.customer.registration.api.controller.response.StateResponse;
import br.com.uniongroup.customer.registration.api.mapper.StateMapper;
import br.com.uniongroup.customer.registration.api.model.State;
import br.com.uniongroup.customer.registration.api.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public State findById(Long id) {
        return stateRepository.findById(id).get();
    }

    public StateResponse findOne(Long id) {
        State state = findById(id);
        return stateMapper.fromStateToStateResponse(state);
    }

    @Transactional
    public StateResponse save(StateRequest stateRequest) {
        State state = stateMapper.fromStateRequestToState(stateRequest);
        state = stateRepository.save(state);
        return stateMapper.fromStateToStateResponse(state);
    }

    @Transactional
    public StateResponse update(Long id, StateRequest stateRequest) {
        State state = findById(id);
        stateMapper.fromStateRequestToState(stateRequest, state);
        state = stateRepository.save(state);
        return stateMapper.fromStateToStateResponse(state);
    }
}
