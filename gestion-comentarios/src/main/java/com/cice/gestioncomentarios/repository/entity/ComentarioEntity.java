package com.cice.gestioncomentarios.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comentario")
@Accessors(chain = true)
public class ComentarioEntity {

    @Id  //se importa la clase porque no esta anteriormente.
    @GeneratedValue
    private Long id;
    private Long idnoti;
    private String cuerpo;
    private String autor;
    private String fecha;

}
