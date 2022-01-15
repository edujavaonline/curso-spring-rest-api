package br.com.uniongroup.custome.registration.api.repository;

import br.com.uniongroup.custome.registration.api.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
