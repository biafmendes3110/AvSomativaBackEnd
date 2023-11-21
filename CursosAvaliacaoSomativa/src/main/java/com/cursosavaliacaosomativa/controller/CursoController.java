package com.cursosavaliacaosomativa.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.cursosavaliacaosomativa.entity.Curso;
import com.cursosavaliacaosomativa.services.CursoServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Curso", description = "API REST DE GERENCIAMENTO SE USUÁRIOS")
@RestController
@RequestMapping("/curso")
public class CursoController {
	private final CursoServices cursoServices;

	@Autowired
	public CursoController (CursoServices cursoServices) {
		this.cursoServices = cursoServices;
	}
	@GetMapping("/{id}")
	@Operation(summary = "Localiza o curso por ID")
	public ResponseEntity <Curso> buscaCursoIdControlId(@PathVariable Long id){
		Curso curso = cursoServices.buscarCursoId(id);
		if(curso!= null) {
			return ResponseEntity.ok(curso);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	@Operation(summary = "Apresenta todos os cursos")
	public ResponseEntity<List<Curso>> buscaTodosCursosControl() {
		List<Curso> Curso = cursoServices.buscarTodosCursos();

		return ResponseEntity.ok(Curso);
	}
	@PostMapping
	@Operation(summary = "Cadastra um curso")
	public ResponseEntity<Curso> salvaCursoControl(@RequestBody @Valid Curso Curso){
		Curso salvaCurso = cursoServices.salvaCurso(Curso);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCurso);

	}
	@PutMapping ("/{id}")
	@Operation(summary = "alterar curso por id ")
	public ResponseEntity<Curso> alterarCurso(@PathVariable Long id, @RequestBody @Valid Curso curso) {
		Curso alterarCurso = cursoServices.alterarCurso(id,curso);
		if (alterarCurso  != null) {
			return ResponseEntity.ok(alterarCurso);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	@Operation(summary = "Apagar o id selecionado")
	public ResponseEntity<String> apagaCursoControl(@PathVariable Long id) {
		boolean apagar = cursoServices.apagarCurso(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}


