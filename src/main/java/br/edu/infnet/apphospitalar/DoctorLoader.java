package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.domain.Doctor;
import br.edu.infnet.apphospitalar.model.service.AddressService;
import br.edu.infnet.apphospitalar.model.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Order(3)
@Component
public class DoctorLoader implements ApplicationRunner {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AddressService addressService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/doctors.txt");
        BufferedReader reader = new BufferedReader(file);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String line = reader.readLine();
        String[] fields = null;

        while(line != null) {

            fields = line.split(";");

            Doctor doctor = new Doctor();
            doctor.setFullName(fields[0]);
            doctor.setEmail(fields[1]);
            doctor.setCpf(fields[2]);
            doctor.setBirthDate(LocalDate.parse(fields[3], formatter));
            doctor.setSpecialty(fields[4]);
            doctor.setCrm(fields[5]);
            Address existingAddress = addressService.searchPostalCode(fields[6]);
            if (existingAddress != null) {
                doctor.setAddress(existingAddress);
            } else {
                doctor.setAddress(new Address(fields[6]));
            }

            doctorService.insert(doctor);
            line = reader.readLine();
        }

        for(Doctor d : doctorService.getList()) {
            System.out.println("Doctor: "+ d);
        }

    }
}
