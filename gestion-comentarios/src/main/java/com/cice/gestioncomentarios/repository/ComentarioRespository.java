package com.cice.gestioncomentarios.repository;

import com.cice.gestioncomentarios.repository.entity.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComentarioRespository extends JpaRepository<ComentarioEntity, Long> {
    Optional<ComentarioEntity> findById();
    // Extiende desde JPARepository, tipo de entidad maneja comentario entity tipo long que maneja

}
