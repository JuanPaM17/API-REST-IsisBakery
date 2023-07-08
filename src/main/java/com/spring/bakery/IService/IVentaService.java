package com.spring.bakery.IService;

import com.spring.bakery.modeloDTO.UsuarioDTO;
import com.spring.bakery.modeloDTO.VentaDTO;

import java.util.ArrayList;

public interface IVentaService {

    public VentaDTO guardar(VentaDTO VentaDTO);

    public ArrayList<VentaDTO> obtener();

    public VentaDTO buscarId(int id);

    public VentaDTO actualizar(VentaDTO VentaDTO);

    public void eliminar(int id);

}
