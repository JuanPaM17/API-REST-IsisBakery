package com.spring.bakery.iService;

import com.spring.bakery.modeloDTO.VentaDTO;

import java.util.ArrayList;

public interface IVentaService {

    public VentaDTO guardar(VentaDTO VentaDTO,int id_pedido,int id_vendedor);

    public ArrayList<VentaDTO> obtener();

    public VentaDTO buscarId(int id);

    public VentaDTO actualizar(VentaDTO VentaDTO);

    public void eliminar(int id);

}
