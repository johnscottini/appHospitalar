package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.DTO.ViaCepApiResponseDTO;
import br.edu.infnet.apphospitalar.model.clients.IAddressClient;
import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private IAddressClient addressClient;
    public void insert(Address address) {
        Address existingAddress = addressRepository.findByPostalCode(address.getPostalCode());
        if (existingAddress == null) {
            addressRepository.save(address);
        }
    }

    public Collection<Address> getList() {
        return (Collection<Address>) addressRepository.findAll();
    }

    public Address searchPostalCode(String postalCode) {
        Address existingAddress = addressRepository.findByPostalCode(postalCode);
        if (existingAddress != null) {
            return existingAddress;
        } else {
            ViaCepApiResponseDTO viaCepApiResponseDTO = addressClient.searchPostalCode(postalCode);
            Address address = mapToAddress(viaCepApiResponseDTO);
            addressRepository.save(address);
            return address;
        }
    }

    private Address mapToAddress(ViaCepApiResponseDTO viaCepApiResponseDTO) {
        Address address = new Address();
        address.setStreet(viaCepApiResponseDTO.getLogradouro());
        address.setComplement(viaCepApiResponseDTO.getComplemento());
        address.setNeighborhood(viaCepApiResponseDTO.getBairro());
        address.setPostalCode(viaCepApiResponseDTO.getCep());
        address.setLocale(viaCepApiResponseDTO.getLocalidade());
        address.setState(viaCepApiResponseDTO.getUf());

        return address;
    }
}
