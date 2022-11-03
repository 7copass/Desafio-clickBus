package com.b3.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.b3.project.model.LocaisModel;

@Repository
public interface LocaisRepository extends JpaRepository<LocaisModel, Long> {

	//@Query(value = "select u from Locais u where u.nome like %?1%")
	List<LocaisModel> findByNome(String nome); 
	
} 
