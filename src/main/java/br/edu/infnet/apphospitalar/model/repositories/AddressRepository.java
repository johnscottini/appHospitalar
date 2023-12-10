package br.edu.infnet.apphospitalar.model.repositories;

import br.edu.infnet.apphospitalar.model.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
