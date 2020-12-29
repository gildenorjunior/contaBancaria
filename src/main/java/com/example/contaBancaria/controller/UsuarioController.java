package com.example.contaBancaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contaBancaria.model.UsuarioModel;
import com.example.contaBancaria.repository.UsuarioRepository;

@RestController
@RequestMapping ("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;

	//MÉTODO GET QUE BUSCA TODOS USUARIOS
		@GetMapping
		public ResponseEntity<List<UsuarioModel>> getAll(){
			return ResponseEntity.ok(repository.findAll());
		}
				
		//MÉTODO GET QUE BUSCA O USUARIO PELO ID
		@GetMapping("/{id}")
		public ResponseEntity<UsuarioModel> getById(@PathVariable Long id){
			return repository.findById(id)
					.map(resp-> ResponseEntity.ok(resp))
							.orElse(ResponseEntity.notFound().build());
		}
		
		//MÉTODO POST QUE CRIA UM NOVO USUARIO
		@PostMapping
		public ResponseEntity<UsuarioModel> post(@Valid @RequestBody UsuarioModel usuario){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
		}
		
		//MÉTODO PUT QUE ATUALIZA AS INFORMAÇÕES DE UM USUARIO
		@PutMapping
		public ResponseEntity<UsuarioModel> put(@Valid @RequestBody UsuarioModel usuario){
			return ResponseEntity.ok(repository.save(usuario));
		}
		
		//MÉTODO DELETE QUE APAGA UM USUARIO
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			repository.deleteById(id);
		}
}
