package com.spring.bakery.iService;

import com.spring.bakery.modeloDTO.EstadoPedidoDTO;
import com.spring.bakery.modeloDTO.UsuarioDTO;

import java.util.ArrayList;

public interface IEstadoPedidoService {

    public EstadoPedidoDTO guardar(UsuarioDTO EstadoPedidoUsuarioDTO);

    public ArrayList<EstadoPedidoDTO> obtener();

    public EstadoPedidoDTO buscarId(int id);

    public EstadoPedidoDTO actualizar(EstadoPedidoDTO EstadoPedidoDTO);

    public void eliminar(int id);

}
