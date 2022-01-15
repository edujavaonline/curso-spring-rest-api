package br.com.uniongroup.custome.registration.api.mapper;

import br.com.uniongroup.custome.registration.api.controller.response.StateResponse;
import br.com.uniongroup.custome.registration.api.model.State;
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
}
