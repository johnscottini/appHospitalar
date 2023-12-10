package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public void insert(Address address) {
        addressRepository.save(address);
    }

    public Collection<Address> getList() {
        return (Collection<Address>) addressRepository.findAll();
    }
}
