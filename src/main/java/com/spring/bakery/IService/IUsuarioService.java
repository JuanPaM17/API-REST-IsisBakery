package com.spring.bakery.IService;

import com.spring.bakery.modelo.Usuario;
import com.spring.bakery.modeloDTO.UsuarioDTO;

import java.util.ArrayList;

public interface IUsuarioService {

    public UsuarioDTO guardar(UsuarioDTO usuarioDTO);

    public ArrayList<UsuarioDTO> obtener();

    public UsuarioDTO buscarId(int id);

    public UsuarioDTO actualizar(UsuarioDTO usuarioDTO);

    public void eliminar(int id);

}
