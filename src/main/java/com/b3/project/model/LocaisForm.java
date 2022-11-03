package com.b3.project.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocaisForm {

	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String nome;
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String cidade;
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String estado;
}
