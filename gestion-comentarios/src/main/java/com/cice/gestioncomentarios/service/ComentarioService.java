package com.cice.gestioncomentarios.service;

import com.cice.gestioncomentarios.controller.dto.ComentarioDTO;

import java.util.List;

/**
 * Interface de servicio controla metodos de logica de integraciòn(negocio) para el resource Comentarios
 */
public interface ComentarioService {

    /**
     * Método crea o inserta un comentario en nuestra BBDD H2 recibido en el RESOURCE
     *
     * @param comentario   que se debe almacenar en BBDD
     * @return ComentarioDTO devuelto tras la inserción generando ID automatico y unico en BBDD
     */
    ComentarioDTO creaComentario(ComentarioDTO comentario);

    /**
     * Metodo que realiza busqueda y devuelve el objeto  comentario en bbdd segun ID pasado si existe
     * @param id del comentario a buscar
     * @return comentarioDTO
     */

    ComentarioDTO buscarComentarioById(Long id);


    /**
     * Metodo para recuperar desde BBDD todos los comentarios
     * @return List<ComentarioDTO>
     */

    List<ComentarioDTO> getAllComentarios();

    /**
     * Metodo que sirve para eliminar una registro de comentario en BBDD en base a un ID ingresado
     * @param Id
     * @return
     */
    //ComentarioDTO eliminarComentarioById (Long Id);

    void eliminarComentarioById (Long Id);

    }
