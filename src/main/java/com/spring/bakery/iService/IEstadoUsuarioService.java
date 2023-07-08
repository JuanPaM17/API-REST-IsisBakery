package com.spring.bakery.iService;

import com.spring.bakery.modeloDTO.EstadoUsuarioDTO;

import java.util.ArrayList;

public interface IEstadoUsuarioService {

    public EstadoUsuarioDTO guardar(EstadoUsuarioDTO EstadoUsuarioDTO);

    public ArrayList<EstadoUsuarioDTO> obtener();

    public EstadoUsuarioDTO buscarId(int id);

    public EstadoUsuarioDTO actualizar(EstadoUsuarioDTO EstadoUsuarioDTO);

    public void eliminar(int id);

}
