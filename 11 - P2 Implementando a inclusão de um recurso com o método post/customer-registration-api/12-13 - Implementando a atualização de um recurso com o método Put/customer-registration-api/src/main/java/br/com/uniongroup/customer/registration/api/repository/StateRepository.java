package br.com.uniongroup.customer.registration.api.repository;

import br.com.uniongroup.customer.registration.api.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
