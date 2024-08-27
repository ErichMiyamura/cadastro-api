package com.example.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastro.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
