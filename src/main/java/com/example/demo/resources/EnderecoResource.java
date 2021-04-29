package com.example.demo.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Endereco;
import com.example.demo.domain.Usuario;
import com.example.demo.resources.exception.ObjectNotFoundException;
import com.example.demo.resources.exception.Response;
import com.example.demo.services.EnderecoService;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;
	@Autowired
	private UsuarioService serviceUsuario;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)

	public ResponseEntity<?> find(@PathVariable Integer id) {
		Endereco obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @PathVariable("id") Integer id, @RequestBody Endereco obj,
			BindingResult bindingResult) {
		try {
			Usuario usu = serviceUsuario.buscar(id);
			if(usu == null) {
				return ResponseEntity.badRequest().body(new Response("Objeto Não Encontrado", 400));
			}
			obj.setUsuario(usu);
			obj = service.insert(obj);
			return ResponseEntity.ok().body(new Response("Salvo Com Sucesso", 201));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(new Response("Erro de validação", 400));
		}

	}
}
