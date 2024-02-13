package com.marianadwarka.estudiante.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Tema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Tema;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn (name = "id_curso", referencedColumnName = "id_curso")
    @JsonIgnore //importante agregar para evitar errores de formato en la response
    private Curso curso;

    public Tema() {
    }


    public Tema(Long id_Tema, String nombre, String descripcion, Curso curso) {
        this.id_Tema = id_Tema;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.curso = curso;
    }
    
    
  
}
