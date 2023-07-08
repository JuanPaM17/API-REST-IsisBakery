package com.spring.bakery.iService;

import com.spring.bakery.modeloDTO.TipoUsuarioDTO;

import java.util.ArrayList;

public interface ITipoUsuarioService {

    public TipoUsuarioDTO guardar(TipoUsuarioDTO TipoUsuarioDTO);

    public ArrayList<TipoUsuarioDTO> obtener();

    public TipoUsuarioDTO buscarId(int id);

    public TipoUsuarioDTO actualizar(TipoUsuarioDTO TipoUsuarioDTO);

    public void eliminar(int id);

}
