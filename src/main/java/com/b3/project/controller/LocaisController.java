package com.b3.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b3.project.model.LocaisForm;
import com.b3.project.model.LocaisFormUpdate;
import com.b3.project.model.LocaisModel;
import com.b3.project.service.LocaisServiceImpl;


@RestController
@RequestMapping("/locais")
public class LocaisController {

	@Autowired
	private LocaisServiceImpl service;
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<LocaisModel> criarLocal(@Valid @RequestBody LocaisForm locaisForm) {
	LocaisModel Local = service.create(locaisForm);
	return ResponseEntity.status(HttpStatus.CREATED).body(Local);
		
	}
	
	@GetMapping("/todos-locais") 
	public ResponseEntity<List<LocaisModel>> ListarLocais(){
		List<LocaisModel> list = service.getAll();  
		return ResponseEntity.ok().body(list); 	
		 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LocaisModel> BuscarLocal(@PathVariable Long id) {
		LocaisModel local = service.getById(id);
		return ResponseEntity.ok().body(local); 		
	}
	 
	@GetMapping("/busca-nome")
	@ResponseBody
	public ResponseEntity<List<LocaisModel>> buscarPorNome( @RequestParam(name = "nome") String nome){
		List<LocaisModel> local = service.getNome(nome);
		return ResponseEntity.ok().body(local);
		
	} 
	
	@PutMapping("/{id}")
	public ResponseEntity<LocaisModel> Atualizar(@PathVariable @Valid Long id, @RequestBody LocaisFormUpdate form) {
		LocaisModel local = service.update(id, form);
		return ResponseEntity.status(HttpStatus.OK).body(local); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
