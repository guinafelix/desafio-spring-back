package com.profectum.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.dto.Curso.CriarCursoDto;
import com.profectum.desafio.services.cursos.CriarCurso;
import com.profectum.desafio.services.cursos.ListarCursos;

@RestController
@RequestMapping(value="/api")
public class CursoController {
	@Autowired
	ListarCursos listarCursosService;
	
	@Autowired
	ListarCursoPorId ListarCursoPorIdService;
	
	@Autowired
	CriarCurso criarCursoService;
	
	@PostMapping("/curso")
	public Curso add(@RequestBody CriarCursoDto dto) {
		return criarCursoService.execute(dto);
	}
}