package com.cursosavaliacaosomativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursosavaliacaosomativa.entity.Curso;
import com.cursosavaliacaosomativa.repository.CursoRepository;

@Service
public class CursoServices {
	private final CursoRepository cursoRepository;
	
	@Autowired
	public CursoServices (CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	public List<Curso> buscarTodosCursos(){
		return cursoRepository.findAll();
	}
	public Curso buscarCursoId(Long id) {
		Optional <Curso> Curso = cursoRepository.findById(id);
		return Curso.orElse(null);
	}
	public Curso salvaCurso (Curso curso) {
		return cursoRepository.save(curso);
	}
	public Curso alterarCurso(Long id, Curso alterarC) {
		Optional <Curso> existeCurso = cursoRepository.findById(id);
		if (existeCurso.isPresent()) {
			alterarC.setId(id);
			return cursoRepository.save(alterarC);
		}
		return null;

	}
	public boolean apagarCurso(Long id) {
		Optional <Curso> existeCurso = cursoRepository.findById(id);
		if (existeCurso.isPresent()) {
			cursoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}



