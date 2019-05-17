package com.cice.gestioncomentarios.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ComentarioDTO {

    private Long id;
    private Long idnoti;
    private String cuerpo;
    private String autor;
    private String fecha;

}
