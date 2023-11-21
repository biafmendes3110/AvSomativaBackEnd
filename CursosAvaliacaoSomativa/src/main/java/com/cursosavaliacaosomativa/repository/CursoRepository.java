package com.cursosavaliacaosomativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursosavaliacaosomativa.entity.Curso;

public interface CursoRepository extends JpaRepository <Curso, Long>  {

}
