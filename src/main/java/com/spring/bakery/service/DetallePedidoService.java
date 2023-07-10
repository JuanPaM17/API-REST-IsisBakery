package com.spring.bakery.service;

import com.spring.bakery.exception.ResourceNoFound;
import com.spring.bakery.iRepository.IDetallePedidoRepository;
import com.spring.bakery.iRepository.IPedidoRepository;
import com.spring.bakery.iRepository.IProductoRepository;
import com.spring.bakery.iService.IDetallePedidoService;
import com.spring.bakery.modelo.DetallePedido;
import com.spring.bakery.modelo.Pedido;
import com.spring.bakery.modelo.Usuario;
import com.spring.bakery.modeloDTO.DetallePedidoDTO;
import com.spring.bakery.modeloDTO.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class DetallePedidoService implements IDetallePedidoService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDetallePedidoRepository iDetallePedidoRepository;

    @Autowired
    private IProductoRepository iProductoRepository;

    @Autowired
    private IPedidoRepository iPedidoService;

    @Override
    public DetallePedidoDTO guardar(DetallePedidoDTO detallePedidoDTO,int id_pedido,int id_producto) {
        DetallePedido detallePedido = mapearClase(detallePedidoDTO);
        detallePedido.setPedido(iPedidoService.findById(id_pedido).orElseThrow(
                ()-> new ResourceNoFound("Pedido","ID",id_pedido)
        ));
        detallePedido.setProducto(iProductoRepository.findById(id_producto).orElseThrow(
                ()-> new ResourceNoFound("Producto","ID",id_producto)
        ));
        return mapearDTO(iDetallePedidoRepository.save(detallePedido));
    }

    @Override
    public ArrayList<DetallePedidoDTO> obtener() {
        return (ArrayList<DetallePedidoDTO>) iDetallePedidoRepository.findAll().stream().map(
                detallePedido -> mapearDTO(detallePedido)
        ).collect(Collectors.toList());
    }

    @Override
    public DetallePedidoDTO buscarId(int id) {
        return mapearDTO(iDetallePedidoRepository.findById(id).
                orElseThrow(()->new ResourceNoFound("Detalle Pedido","Id",id)));
    }

    @Override
    public DetallePedidoDTO actualizar(DetallePedidoDTO DetallePedidoDTO) {
        DetallePedido detallePedido = iDetallePedidoRepository.findById(DetallePedidoDTO.getId()).
                orElseThrow(()->new ResourceNoFound("Detalle Pedido","Id",DetallePedidoDTO.getId()));
        detallePedido = mapearClase(DetallePedidoDTO);
        return mapearDTO(iDetallePedidoRepository.save(detallePedido));
    }

    @Override
    public void eliminar(int id) {
    iDetallePedidoRepository.delete(iDetallePedidoRepository.findById(id).
            orElseThrow(()->new ResourceNoFound("Detalle Pedido","Id",id)));
    }
    private DetallePedidoDTO mapearDTO(DetallePedido detallePedido){
        return modelMapper.map(detallePedido,DetallePedidoDTO.class);
    }

    private DetallePedido mapearClase(DetallePedidoDTO detallePedidoDTO){
        return modelMapper.map(detallePedidoDTO,DetallePedido.class);
    }

}
