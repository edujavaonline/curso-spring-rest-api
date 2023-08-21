package br.com.uniongroup.customer.registration.api.repository;

import br.com.uniongroup.customer.registration.api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
