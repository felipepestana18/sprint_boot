package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Usuario;
import com.example.demo.domain.Endereco;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.repositories.UsuarioRepository;


@SpringBootApplication
public class FelipepestanaApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	


	public static void main(String[] args) {
		SpringApplication.run(FelipepestanaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario = new Usuario(null,"Felipe", "felipepe-pe27@hotmail.com", "4525260");
		Usuario usuario2 = new Usuario(null,"Rafael", "rafelpe-pe27@hotmail.com", "4525260741");
		
		Endereco endereco = new Endereco(null, "122", "Frente", "São Jose do rio preto","SP", "12020202", usuario);
		Endereco endereco2 = new Endereco(null, "123", "Frente", "Mirassol","SP", "12020260", usuario);
		Endereco enderec3 = new Endereco(null, "142", "Esquerdo", "São Paulo", "SP", "300561550", usuario2);
		Endereco endereco4 = new Endereco(null, "125", "Lado", "Campinas","SP", "88494988989", usuario2);
		
		
		usuario.getEnderecos().addAll(Arrays.asList(endereco, endereco2));
		usuario2.getEnderecos().addAll(Arrays.asList(enderec3, endereco4));
	
		usuarioRepository.saveAll(Arrays.asList(usuario, usuario2));
		enderecoRepository.saveAll(Arrays.asList(endereco, endereco2, enderec3, endereco4));

		
	}

}
