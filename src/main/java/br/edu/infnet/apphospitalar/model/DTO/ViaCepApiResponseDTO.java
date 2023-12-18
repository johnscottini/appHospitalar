package br.edu.infnet.apphospitalar.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViaCepApiResponseDTO {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
