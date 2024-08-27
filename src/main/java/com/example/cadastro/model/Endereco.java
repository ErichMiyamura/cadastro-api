package com.example.cadastro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CEP é obrigatório")
    private String cep;

    @NotBlank(message = "Logradouro é obrigatório")
    private String logradouro;

    private String complemento;

    @NotBlank(message = "Bairro é obrigatório")
    private String bairro;

    @NotBlank(message = "Localidade é obrigatória")
    private String localidade;

    @NotBlank(message = "UF é obrigatório")
    private String uf;

}
