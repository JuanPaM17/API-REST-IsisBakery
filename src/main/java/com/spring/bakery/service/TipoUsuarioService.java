package com.spring.bakery.service;

import com.spring.bakery.exception.ResourceNoFound;
import com.spring.bakery.iRepository.ITipoUsuarioRepository;
import com.spring.bakery.iService.ITipoUsuarioService;
import com.spring.bakery.modelo.Producto;
import com.spring.bakery.modelo.TipoUsuario;
import com.spring.bakery.modeloDTO.ProductoDTO;
import com.spring.bakery.modeloDTO.TipoUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service

public class TipoUsuarioService implements ITipoUsuarioService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ITipoUsuarioRepository iTipoUsuarioRepository;

    @Override
    public TipoUsuarioDTO guardar(TipoUsuarioDTO TipoUsuarioDTO) {
        return mapearDTO(iTipoUsuarioRepository.save(mapearClase(TipoUsuarioDTO)));
    }

    @Override
    public ArrayList<TipoUsuarioDTO> obtener() {
        return (ArrayList<TipoUsuarioDTO>) iTipoUsuarioRepository.findAll().stream().map(
                tipoUsuario -> mapearDTO(tipoUsuario)
        ).collect(Collectors.toList());
    }

    @Override
    public TipoUsuarioDTO buscarId(int id) {
        return  mapearDTO(iTipoUsuarioRepository.findById(id).orElseThrow(()->
                new ResourceNoFound("Tipo Usuario","ID",id)
        ));
    }

    @Override
    public TipoUsuarioDTO actualizar(TipoUsuarioDTO TipoUsuarioDTO) {
        TipoUsuario tipoUsuario = iTipoUsuarioRepository.findById(TipoUsuarioDTO.getId()).orElseThrow(()->
                new ResourceNoFound("Tipo Usuario","ID",TipoUsuarioDTO.getId())
        );
        tipoUsuario = mapearClase(TipoUsuarioDTO);
        return mapearDTO(iTipoUsuarioRepository.save(tipoUsuario));
    }

    @Override
    public void eliminar(int id) {
        TipoUsuario tipoUsuario = iTipoUsuarioRepository.findById(id).orElseThrow(()->
                    new ResourceNoFound("Tipo Usuario","ID",id)
                );
        iTipoUsuarioRepository.delete(tipoUsuario);
    }

    private TipoUsuarioDTO mapearDTO(TipoUsuario tipoUsuario){
        return modelMapper.map(tipoUsuario,TipoUsuarioDTO.class);
    }

    private TipoUsuario mapearClase(TipoUsuarioDTO tipoUsuarioDTO){
        return modelMapper.map(tipoUsuarioDTO,TipoUsuario.class);
    }

}
