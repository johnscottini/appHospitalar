package br.edu.infnet.apphospitalar.model.controller;

import br.edu.infnet.apphospitalar.model.domain.Address;
import br.edu.infnet.apphospitalar.model.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {


    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/list")
    public List<Address> getList() {
        return (List<Address>) addressService.getList();
    }

    @PostMapping(value = "/insert")
    public void insert(@RequestBody Address address) {
        addressService.insert(address);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }

}
