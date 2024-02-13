package com.marianadwarka.estudiante.service;

import com.marianadwarka.estudiante.dto.CursoTemaDTO;
import com.marianadwarka.estudiante.model.Curso;
import com.marianadwarka.estudiante.model.Tema;
import com.marianadwarka.estudiante.repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService{

    @Autowired
    private ICursoRepository cursoRepo;
    
    
    @Override
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public void saveCurso(Curso curso) {
        List<Tema> listaTemas = curso.getListaTemas();
        // Comprobar si la lista no es nula y no está vacía
        if (listaTemas != null && !listaTemas.isEmpty()) {
            for (Tema tema : listaTemas) {
                tema.setCurso(curso);
            }
        }
        cursoRepo.save(curso);
    }

    @Override
    public void deleteCurso(Long id) {
        
        cursoRepo.deleteById(id);
        
    }

    @Override
    public Curso findCurso(Long id) {
        return cursoRepo.findById(id).orElse(null);
    }

    @Override
    public void editCurso(Curso curso) {
        this.saveCurso(curso);
    }


    @Override
    public List<Curso> getCursosJava() {
        String palabra = "Java";
        String textoComparar;
        
        List<Curso> listaCursos = this.getCursos();
        List<Curso> listaCursosJava = new ArrayList<Curso>();
        
        for (Curso cur : listaCursos) {
            textoComparar = cur.getNombre();
            boolean contieneJava = textoComparar.contains(palabra);
            if (contieneJava == true) {
                listaCursosJava.add(cur);
            }
        }
    return listaCursosJava;
    }

    @Override
    public CursoTemaDTO temasPorCurso(Long id_curso) {
        
        CursoTemaDTO curTemDTO = new CursoTemaDTO ();
        Curso curso = this.findCurso(id_curso);
        curTemDTO.setNombreCurso(curso.getNombre());
        curTemDTO.setListaTemas(curso.getListaTemas());
        
        return curTemDTO;
        
    }

    @Override
    public void insertTema(Long id_curso, Tema tema) {
        Curso curso = cursoRepo.findById(id_curso).orElse(null);
        List<Tema> listaTemas = curso.getListaTemas();
        listaTemas.add(tema);
        curso.setListaTemas(listaTemas);
        tema.setCurso(curso);
        cursoRepo.save(curso);
    }

    
}