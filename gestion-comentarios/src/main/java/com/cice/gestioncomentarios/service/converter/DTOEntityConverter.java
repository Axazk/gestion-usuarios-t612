package com.cice.gestioncomentarios.service.converter;

import com.cice.gestioncomentarios.controller.dto.ComentarioDTO;
import com.cice.gestioncomentarios.repository.entity.ComentarioEntity;
import lombok.experimental.Accessors;

public class DTOEntityConverter {

     public ComentarioEntity mapDTOToEntity(ComentarioDTO comentarioDTO){

         ComentarioEntity comentarioEntity = null;
                 comentarioEntity = new ComentarioEntity()
                 .setId(comentarioDTO.getId())
                         .setIdnoti(comentarioDTO.getIdnoti())
                         .setAutor(comentarioDTO.getAutor())
                         .setCuerpo(comentarioDTO.getCuerpo())
                         .setFecha(comentarioDTO.getFecha());

                 return comentarioEntity;


                // en este caso se puede utlizar los metodos set en lugar del constructor para ello
                 // para este caso se puede utlizar en el reporsitory la opcion @Accessors(chain = True)


     }
     public ComentarioDTO mapEntityToDTO (ComentarioEntity comentarioEntity){
         ComentarioDTO comentarioDTO = null;
         comentarioDTO = new ComentarioDTO()
                 .setId(comentarioEntity.getId())
                 .setIdnoti(comentarioEntity.getIdnoti())
                 .setAutor(comentarioEntity.getAutor())
                 .setCuerpo(comentarioEntity.getCuerpo())
                 .setFecha(comentarioEntity.getFecha());
         return comentarioDTO;
     }

}

