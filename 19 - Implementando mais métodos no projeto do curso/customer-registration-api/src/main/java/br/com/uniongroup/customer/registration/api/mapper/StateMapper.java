package br.com.uniongroup.customer.registration.api.mapper;

import br.com.uniongroup.customer.registration.api.controller.request.StateRequest;
import br.com.uniongroup.customer.registration.api.controller.response.StateResponse;
import br.com.uniongroup.customer.registration.api.model.State;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StateMapper {

    @Autowired
    private ModelMapper mapper;

    public StateResponse fromStateToStateResponse(State state) {
        return mapper.map(state, StateResponse.class);
    }

    public List<StateResponse> fromListStateToListStateResponse(List<State> states) {
        return states.stream()
                .map(state -> fromStateToStateResponse(state))
                .collect(Collectors.toList());
    }

    public State fromStateRequestToState(StateRequest stateRequest) {
        return mapper.map(stateRequest, State.class);
    }

    public void fromStateRequestToState(StateRequest stateRequest, State state) {
        mapper.map(stateRequest, state);
    }
}
