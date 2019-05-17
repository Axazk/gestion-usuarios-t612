package com.cice.gestioncomentarios.controller;

import com.cice.gestioncomentarios.controller.dto.ComentarioDTO;
import com.cice.gestioncomentarios.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase resource para comentarios de noticias.
 * se intenta al menos yo definir todos los metodos CRUD
 */

@RestController  // Aqui intenté poner Override mal muy mal
public class ComentariosResource {

    // SI usamos una interface que inyecte objetos usamos Autowired entonces metera bean
    @Autowired
    ComentarioService comentarioService;

    /**
     * Este método sirve para crear un recurso
     * Recibimos con un modelo de comentario, almacenaremos en BBDD y devolvemos respuesta el mismo objeto creado
     * con el ID o identificador único en BBDD
     * @param comentario DTO recibido para añadir en el sistema relacionado con la noticia
     * @return ResponseEntity<ComentarioDTO>
     */
    //@RequestMapping(path = "/comentarios", method = RequestMethod.POST)
    @RequestMapping(path = "/comentarios", method = RequestMethod.POST)
    public ResponseEntity<ComentarioDTO> crearComentario(@RequestBody ComentarioDTO comentario){
        ResponseEntity<ComentarioDTO> response = null;
        if (validateComentario(comentario)){
           // si recibimos el resultado  valido de la comprobacion si el dato no es vacío
            // almacenamos en una variable el resultado del metodo crea_comentario
            // preparamos la respuesta el mismo cuerpo añadido el ID en BBDD
            ComentarioDTO comentarioDTO = comentarioService.creaComentario(comentario);
            response = ResponseEntity.ok(comentarioDTO);
        }
        else {
            response = ResponseEntity.badRequest(comentario);
        }
        return response;
    }

    /**
     * Metodo para consultar o recuperar desde BBDD un recurso o comentario en base a un ID
     * @param id
     * @return
     */
    @RequestMapping(path = "comentarios/id", method = RequestMethod.GET)
    // public ResponseEntity<ComentarioDTO> getComentarioById(@RequestParam(name = "Id") Long id) {
    // en este caso se utiliza para la entrada @PathVariable
    public ResponseEntity<ComentarioDTO> getComentarioById(@PathVariable(name = "Id") Long id) {
        ResponseEntity<ComentarioDTO> response = null;

        ComentarioDTO comentarioDTO = comentarioService.buscarComentarioById();
        if (comentarioDTO != null){
            response = ResponseEntity.ok(comentarioDTO);
        }
        else {
            response = ResponseEntity.notFound().build();
        }

        return response;
    }

    /**
     *
     * @return
     */
    @RequestMapping(path= "/comentarios", method = RequestMethod.GET)
    public  ResponseEntity<List<ComentarioDTO>> getAllComentarios(){
            ResponseEntity<List<ComentarioDTO>> response = null;
        //desde aqui se llama al servicio.
        List<ComentarioDTO> allComentarios = comentarioService.getAllComentarios();
        response = ResponseEntity.ok(allComentarios);

        return response;
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(path = "/comentarios/(id)", method = RequestMethod.DELETE)
    public ResponseEntity eliminarComentarioById(@PathVariable(name = "id")Long id){
       ResponseEntity response = null;
       // Desde aqui se llama al metodo en el servicio
        comentarioService.eliminarComentarioById(id);
        return ResponseEntity.accepted().build();
    }

        private boolean validateComentario (ComentarioDTO comentario){
         // return (comentario.getCuerpo().isEmpty() false;
        // esta comprobacion no la tengo clara, puedo hacerla solo para el cuerpo y usar un if solamente.
            // otra opcion de condicional ternario
            //  return (comentario.getCuerpo().isEmpty() && comentario.getAutor().isEmpty()) ? true : false;
         return (comentario.getCuerpo().isEmpty() || comentario.getAutor().isEmpty()) ? false : true;
    }

    }

