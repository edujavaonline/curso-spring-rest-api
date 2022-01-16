package br.com.uniongroup.custome.registration.api.repository;

import br.com.uniongroup.custome.registration.api.model.CustomerRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRegisterRepository extends JpaRepository<CustomerRegister, Long> {
}
