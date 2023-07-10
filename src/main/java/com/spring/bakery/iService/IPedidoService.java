package com.spring.bakery.iService;

import com.spring.bakery.modeloDTO.PedidoDTO;

import java.util.ArrayList;

public interface IPedidoService {

    public PedidoDTO guardar(PedidoDTO PedidoDTO,int id_estado_pedido,int id_cliente);

    public ArrayList<PedidoDTO> obtener();

    public PedidoDTO buscarId(int id);

    public PedidoDTO actualizar(PedidoDTO PedidoDTO);

    public void eliminar(int id);

}
