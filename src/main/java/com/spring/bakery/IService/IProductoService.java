package com.spring.bakery.IService;

import com.spring.bakery.modeloDTO.ProductoDTO;
import com.spring.bakery.modeloDTO.UsuarioDTO;

import java.util.ArrayList;

public interface IProductoService {

    public ProductoDTO guardar(ProductoDTO ProductoDTO);

    public ArrayList<ProductoDTO> obtener();

    public ProductoDTO buscarId(int id);

    public ProductoDTO actualizar(ProductoDTO ProductoDTO);

    public void eliminar(int id);

}
