package com.cice.gestioncomentarios.service.imp;

import com.cice.gestioncomentarios.controller.dto.ComentarioDTO;
import com.cice.gestioncomentarios.repository.ComentarioRespository;
import com.cice.gestioncomentarios.repository.entity.ComentarioEntity;
import com.cice.gestioncomentarios.service.ComentarioService;
import com.cice.gestioncomentarios.service.converter.DTOEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    // al implementar la clase solicita insertar el metodo no definido

    @Autowired
    ComentarioRespository comentarioRepository;

    DTOEntityConverter mapper = new DTOEntityConverter();
    private List<ComentarioDTO> listComentarios;


    @Override
    public ComentarioDTO creaComentario(ComentarioDTO comentario) {
        ComentarioDTO reponseDto = null;
        // llamamos al reporsitory pasando una entity, con mapper pasamos la noticia y devuelve
        // la entity. que debemos transformar en DTO de retorno.
        ComentarioEntity comentarioEntity = comentarioRepository.save(mapper.mapDTOToEntity(comentario));
        reponseDto = mapper.mapEntityToDTO(comentarioEntity);
        //paso la respuesta desde DDBB to DTO es el retorno.
        return reponseDto;
    }

    @Override
    public ComentarioDTO buscarComentarioById(Long id) {
        ComentarioDTO responseDTO = null;
        Optional<ComentarioEntity> optionalComentarioEntity = comentarioRepository.findById();
        // aqui fue necerio importar la clase Optional
        if (optionalComentarioEntity.isPresent()) {
            if (optionalComentarioEntity.isPresent()) {
                responseDTO = mapper.mapEntityToDTO(optionalComentarioEntity.get());
            }
            return responseDTO;
        }


        @Override
        public List<ComentarioDTO> getAllComentarios () {
            List<ComentarioDTO> listaComentarios = Collections.EMPTY_LIST;
            listaComentarios = comentarioRepository
                    .findAll()
                    .stream()
                    .map(entity -> mapper.mapEntityToDTO(entity))
                    .collect(Collectors.toList());

            return listComentarios;

        }


        @Override
        public void eliminarComentarioById (Long id){
            comentarioRepository.deleteById(id);
        }
    }
}
