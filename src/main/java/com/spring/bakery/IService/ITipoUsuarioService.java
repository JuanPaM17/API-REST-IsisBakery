package com.spring.bakery.IService;

import com.spring.bakery.modeloDTO.TipoUsuarioDTO;
import com.spring.bakery.modeloDTO.UsuarioDTO;

import java.util.ArrayList;

public interface ITipoUsuarioService {

    public TipoUsuarioDTO guardar(TipoUsuarioDTO TipoUsuarioDTO);

    public ArrayList<TipoUsuarioDTO> obtener();

    public TipoUsuarioDTO buscarId(int id);

    public TipoUsuarioDTO actualizar(TipoUsuarioDTO TipoUsuarioDTO);

    public void eliminar(int id);

}
