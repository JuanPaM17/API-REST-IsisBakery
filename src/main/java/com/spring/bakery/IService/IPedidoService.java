package com.spring.bakery.IService;

import com.spring.bakery.modeloDTO.PedidoDTO;
import com.spring.bakery.modeloDTO.UsuarioDTO;

import java.util.ArrayList;

public interface IPedidoService {

    public PedidoDTO guardar(PedidoDTO PedidoDTO);

    public ArrayList<PedidoDTO> obtener();

    public PedidoDTO buscarId(int id);

    public PedidoDTO actualizar(PedidoDTO PedidoDTO);

    public void eliminar(int id);

}
