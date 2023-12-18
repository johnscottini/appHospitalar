package br.edu.infnet.apphospitalar.model.clients;

import br.edu.infnet.apphospitalar.model.DTO.ViaCepApiResponseDTO;
import br.edu.infnet.apphospitalar.model.domain.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "AddressClient")
public interface IAddressClient {

    @GetMapping(value = "/{postalCode}/json")
    ViaCepApiResponseDTO searchPostalCode(@PathVariable String postalCode);
}
