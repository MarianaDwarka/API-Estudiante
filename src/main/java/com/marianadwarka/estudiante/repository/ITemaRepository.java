package com.marianadwarka.estudiante.repository;

import com.marianadwarka.estudiante.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITemaRepository extends JpaRepository<Tema,Long>{
    
}
