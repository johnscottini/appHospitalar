package br.edu.infnet.apphospitalar.model.service;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.domain.Doctor;
import br.edu.infnet.apphospitalar.model.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AddressService addressService;
    public void insert(Doctor doctor) {
        String postalCode = doctor.getAddress().getPostalCode();
        Address address = addressService.searchPostalCode(postalCode);
        doctor.setAddress(address);
        doctorRepository.save(doctor);
    }

    public void insertWithoutAddressAPI(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Collection<Doctor> getList() {
        return (Collection<Doctor>) doctorRepository.findAll();
    }

    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
