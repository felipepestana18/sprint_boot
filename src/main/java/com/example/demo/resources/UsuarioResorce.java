package com.example.demo.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Usuario;
import com.example.demo.resources.exception.ObjectNotFoundException;
import com.example.demo.resources.exception.Response;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResorce {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Usuario obj = service.buscar(id);
		if (obj == null) {
			return ResponseEntity.badRequest().body(new Response("Objeto Não Encontrado", 400));
		}

		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody Usuario obj, BindingResult bindingResult) {

		try {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(new Response("Dados Cadastro com  Sucesso", 201));
		} catch ( Exception ex) {
			return  ResponseEntity.badRequest().body(new Response("Erro de validação", 400));
		} 

	}
}
