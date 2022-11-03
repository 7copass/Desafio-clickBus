package com.b3.project.service;

import java.util.List;
import java.util.Optional;

import com.b3.project.model.LocaisForm;
import com.b3.project.model.LocaisFormUpdate;
import com.b3.project.model.LocaisModel;

public interface ILocais {

	LocaisModel create(LocaisForm form);
	
	List<LocaisModel> getAll();
	
	LocaisModel getById(Long id);
	
	List<LocaisModel> getNome(String nome);
	
	LocaisModel update(Long id, LocaisFormUpdate updateForm);
	
	void delete(Long id);
}
