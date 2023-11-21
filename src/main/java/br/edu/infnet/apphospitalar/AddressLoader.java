package br.edu.infnet.apphospitalar;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.service.AddressService;
import br.edu.infnet.apphospitalar.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class AddressLoader implements ApplicationRunner {
    @Autowired
    private AddressService addressService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/addresses.txt");
        BufferedReader reader = new BufferedReader(file);

        String line = reader.readLine();
        String[] fields = null;

        while(line != null) {
            fields = line.split(";");
            Address address = new Address();
            address.setStreet(fields[0]);
            address.setCity(fields[1]);
            address.setNumber(fields[2]);
            address.setState(fields[3]);
            address.setPostalCode(fields[4]);
            address.setId(fields[5]);

            addressService.insert(address);
            line = reader.readLine();
        }

        for(Address a : addressService.getList()) {
            System.out.println("Address: "+ a);
        }

    }
}
