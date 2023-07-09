package com.spring.bakery.service;

import com.spring.bakery.exception.ResourceNoFound;
import com.spring.bakery.iRepository.IEstadoUsuarioRepository;
import com.spring.bakery.iService.IEstadoUsuarioService;
import com.spring.bakery.modelo.EstadoUsuario;
import com.spring.bakery.modeloDTO.EstadoUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class EstadoUsuarioService implements IEstadoUsuarioService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IEstadoUsuarioRepository iEstadoUsuarioRepository;

    @Override
    public EstadoUsuarioDTO guardar(EstadoUsuarioDTO estadoUsuarioDTO) {
        return mapearDTO(iEstadoUsuarioRepository.save(mapearClase(estadoUsuarioDTO)));
    }

    @Override
    public ArrayList<EstadoUsuarioDTO> obtener() {
        return (ArrayList<EstadoUsuarioDTO>) iEstadoUsuarioRepository.findAll().stream().map(estadoUsuario->mapearDTO(estadoUsuario)).collect(Collectors.toList());
    }

    @Override
    public EstadoUsuarioDTO buscarId(int id) {
        return mapearDTO(iEstadoUsuarioRepository.findById(id).orElseThrow(()-> new ResourceNoFound("Estado Usuario","ID",id))) ;
    }

    @Override
    public EstadoUsuarioDTO actualizar(EstadoUsuarioDTO estadoUsuarioDTO) {
        EstadoUsuario estadoUsuario = iEstadoUsuarioRepository.findById(estadoUsuarioDTO.getId()).orElseThrow(()-> new ResourceNoFound("Estado Usuario","ID",estadoUsuarioDTO.getId()));
        estadoUsuario = mapearClase(estadoUsuarioDTO);
        return mapearDTO(iEstadoUsuarioRepository.save(estadoUsuario));
    }

    @Override
    public void eliminar(int id) {
        iEstadoUsuarioRepository.delete(iEstadoUsuarioRepository.findById(id).orElseThrow(()-> new ResourceNoFound("Estado Usuario","ID",id)));
    }

    private EstadoUsuarioDTO mapearDTO(EstadoUsuario estadoUsuario){
        return modelMapper.map(estadoUsuario,EstadoUsuarioDTO.class);
    }

    private EstadoUsuario mapearClase(EstadoUsuarioDTO estadoUsuarioDTO){
        return modelMapper.map(estadoUsuarioDTO,EstadoUsuario.class);
    }


}
