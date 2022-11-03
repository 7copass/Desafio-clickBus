package com.b3.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocaisFormUpdate {
	
	private String nome;
	private String cidade;
	private String estado;
}
