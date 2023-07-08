package com.spring.bakery.IService;

import com.spring.bakery.modeloDTO.DetallePedidoDTO;
import com.spring.bakery.modeloDTO.UsuarioDTO;

import java.util.ArrayList;

public interface IDetallePedidoService {

    public DetallePedidoDTO guardar(DetallePedidoDTO DetallePedidoDTO);

    public ArrayList<DetallePedidoDTO> obtener();

    public DetallePedidoDTO buscarId(int id);

    public DetallePedidoDTO actualizar(DetallePedidoDTO DetallePedidoDTO);

    public void eliminar(int id);

}