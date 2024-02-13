package com.marianadwarka.estudiante.controller;

import com.marianadwarka.estudiante.dto.CursoTemaDTO;
import com.marianadwarka.estudiante.model.Curso;
import com.marianadwarka.estudiante.model.Tema;
import com.marianadwarka.estudiante.service.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    
    @Autowired
    private ICursoService cursoServ;
    
    //1-crear un nuevo curso
    @PostMapping ("/cursos/crear")
    public String crearCurso(@RequestBody Curso curso) {
        cursoServ.saveCurso(curso);
        return "Curso creado correctamente";
    }
    
    //extra-insertar tema
    @PutMapping("/curso/insertartema/{id_curso}")
    public String insertarTema(@PathVariable Long id_curso,
                               @RequestBody Tema tema) {
        cursoServ.insertTema(id_curso, tema);
        return "Tema asignado correctamente";   
    }
    
    //extra-traer curso por ID
    @GetMapping ("/curso/traer/{id_curso}")
    public Curso traerCurso (@PathVariable Long id_curso) {
        return cursoServ.findCurso(id_curso);
    }
    
    
    //3- obtener todos los cursos
    @GetMapping ("/cursos/traer")
    public List<Curso> traerCursos () {
        return cursoServ.getCursos();
    }
    
    //4-Obtener los temas de un determinado curso
    @GetMapping ("/cursos/temas/{id_curso}")
    public CursoTemaDTO temasPorCurso (@PathVariable Long id_curso) {
        return cursoServ.temasPorCurso(id_curso);
    }
    
    //5-Obtener todos los cursos que tengan como nombre la palabra "Java
    @GetMapping ("/cursos/java")
    public List<Curso> getCursosJava () {
        return cursoServ.getCursosJava();
    }
    
    //6- Modificar los datos de un curso
    @PutMapping("/curso/edit")
    public String editCurso(@RequestBody Curso curso) {
        cursoServ.editCurso(curso);
        return "Curso editado correctamente";
    }
    

    
}

