package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Endereco;
//import com.example.demo.domain.enums.TipoUsuario;
//import com.example.demo.dto.EnderecoDTO;
import com.example.demo.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	public Endereco buscar(Integer id) {

		Optional<Endereco> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Endereco insert(Endereco obj) {

		obj.setId(null);
		return repo.save(obj);
	}

}
