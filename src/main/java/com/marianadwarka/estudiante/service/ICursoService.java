package com.marianadwarka.estudiante.service;

import com.marianadwarka.estudiante.dto.CursoTemaDTO;
import com.marianadwarka.estudiante.model.Curso;
import com.marianadwarka.estudiante.model.Tema;
import java.util.List;

public interface ICursoService {
    
    
    public List<Curso> getCursos();

  
    public void saveCurso(Curso curso);

   
    public void deleteCurso(Long id);

    
    public Curso findCurso(Long id);
    

    public void editCurso(Curso curso);


    public List<Curso> getCursosJava();
    
    
    public CursoTemaDTO temasPorCurso(Long id_curso);
    
    
    public void insertTema(Long id_curso, Tema tema);
    
    
    
    
}