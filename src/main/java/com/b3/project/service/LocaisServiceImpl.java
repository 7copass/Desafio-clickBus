package com.b3.project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3.project.model.LocaisForm;
import com.b3.project.model.LocaisFormUpdate;
import com.b3.project.model.LocaisModel;
import com.b3.project.repository.LocaisRepository;

@Service
public class LocaisServiceImpl implements ILocais {

	@Autowired
	LocaisRepository repository;
	
	
	
	@Override
	public LocaisModel create(LocaisForm form) {
		
		LocaisModel local = new LocaisModel();
		local.setNome(form.getNome());
		local.setCidade(form.getCidade());
		local.setEstado(form.getEstado());
		local.setCriadoEm(LocalDateTime.now());		
		return repository.save(local);
	}



	@Override
	public List<LocaisModel> getAll() {
		return repository.findAll();
	}



	@SuppressWarnings("deprecation")
	@Override
	public LocaisModel getById(Long id) {
		Optional<LocaisModel> local = repository.findById(id);
		return local.orElseThrow(() -> new ObjectNotFoundException (
				"Objeto não encontrado! Id: " + id + ", Tipo: " + LocaisModel.class.getName(), null));
	}  


 
	@Override
	public LocaisModel update(Long id, LocaisFormUpdate updateForm) { 
		LocaisModel local = getById(id);
		local.setAtualizadoEm(LocalDateTime.now());
		local.setCidade(updateForm.getCidade());
		local.setEstado(updateForm.getEstado());
		local.setNome(updateForm.getNome());
		return repository.save(local);
	}



	@Override
	public void delete(Long id) {
		LocaisModel local = getById(id);
		 repository.delete(local);
		
	}



	@Override
	public  List<LocaisModel> getNome(String nome) { 
		return repository.findByNome(nome);
		
	} 



}
