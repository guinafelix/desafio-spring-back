package com.profectum.desafio.services.cursos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Curso.CriarCursoDto;
import com.profectum.desafio.dto.Oferta.CriarOfertaDto;
import com.profectum.desafio.models.Curso;
import com.profectum.desafio.models.Oferta;
import com.profectum.desafio.repository.CursoRepository;
import com.profectum.desafio.services.ofertas.CriarOferta;

@Service
public class CriarCurso {
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	CriarOferta criarOfertaService;
	
	public void execute(CriarCursoDto dto) {
		Curso curso = new Curso(dto);
		
		List<Oferta> ofertas = new ArrayList<>();
		
		List<CriarOfertaDto> listaDeOfertas = dto.getofertas();
		
		Curso updatedCurso = cursoRepository.save(curso);

		for (CriarOfertaDto criarOfertaDto : listaDeOfertas) {
		    Oferta oferta = criarOfertaService.execute(criarOfertaDto, updatedCurso); 
		    ofertas.add(oferta);
		}
		
		updatedCurso.setOfertas(ofertas);
		
		curso = cursoRepository.save(updatedCurso);
	}
}
