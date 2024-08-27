package com.example.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cadastro.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
