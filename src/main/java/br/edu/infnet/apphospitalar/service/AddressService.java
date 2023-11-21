package br.edu.infnet.apphospitalar.service;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressService {

    private Map<String, Address> map = new HashMap<String, Address>();

    public void insert(Address address) {
        map.put(address.getId(), address);
    }

    public Collection<Address> getList() {
        return map.values();
    }
}
