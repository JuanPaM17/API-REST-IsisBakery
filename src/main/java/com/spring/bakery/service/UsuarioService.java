package com.spring.bakery.service;

import com.spring.bakery.exception.ResourceNoFound;
import com.spring.bakery.iRepository.IEstadoUsuarioRepository;
import com.spring.bakery.iRepository.ITipoUsuarioRepository;
import com.spring.bakery.iRepository.IUsuarioRepository;
import com.spring.bakery.iService.IUsuarioService;
import com.spring.bakery.modelo.Usuario;
import com.spring.bakery.modeloDTO.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service

public class UsuarioService implements IUsuarioService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    private IEstadoUsuarioRepository iEstadoUsuarioRepository;

    @Autowired
    private ITipoUsuarioRepository iTipoUsuarioRepository;

    @Override
    public UsuarioDTO guardar(UsuarioDTO usuarioDTO, int id_estado_usuario, int id_tipo_usuario) {
        Usuario usuario = mapearClase(usuarioDTO);
        try {
            usuario.setEstadoUsuario(iEstadoUsuarioRepository.findById(id_estado_usuario).orElseThrow(()->
                    new ResourceNoFound("Estado Usuario","Id",id_estado_usuario)));
            usuario.setTipoUsuario(iTipoUsuarioRepository.findById(id_tipo_usuario).orElseThrow(()->
                    new ResourceNoFound("Tipo Usuario","ID",id_tipo_usuario)
            ));
            return mapearDTO(iUsuarioRepository.save(usuario));
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ArrayList<UsuarioDTO> obtener() {
        ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) iUsuarioRepository.findAll();
        return (ArrayList<UsuarioDTO>) listaUsuarios.stream().map(usuario ->
                mapearDTO(usuario)
        ).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO buscarId(int id) {
        Usuario usuario = iUsuarioRepository.findById(id).orElseThrow(()-> new ResourceNoFound("Usuario","id",id));
        return mapearDTO(usuario);
    }

    @Override
    public UsuarioDTO actualizar(UsuarioDTO usuarioDTO) {
        Usuario usuario = iUsuarioRepository.findById(usuarioDTO.getId()).orElseThrow(()-> new ResourceNoFound("Usuario","id",usuarioDTO.getId()));
        usuario = mapearClase(usuarioDTO);
        return mapearDTO(iUsuarioRepository.save(usuario));
    }

    @Override
    public void eliminar(int id) {
        Usuario usuario = iUsuarioRepository.findById(id).orElseThrow(()-> new ResourceNoFound("Usuario","id",id));
        iUsuarioRepository.delete(usuario);
    }

    private UsuarioDTO mapearDTO(Usuario usuario){
        return modelMapper.map(usuario,UsuarioDTO.class);
    }

    private Usuario mapearClase(UsuarioDTO usuarioDTO){
        return modelMapper.map(usuarioDTO,Usuario.class);
    }


}
