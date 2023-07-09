package com.spring.bakery.service;

import com.spring.bakery.exception.ResourceNoFound;
import com.spring.bakery.iRepository.IEstadoPedidoRepository;
import com.spring.bakery.iService.IEstadoPedidoService;
import com.spring.bakery.modelo.EstadoPedido;
import com.spring.bakery.modelo.Pedido;
import com.spring.bakery.modeloDTO.EstadoPedidoDTO;
import com.spring.bakery.modeloDTO.PedidoDTO;
import com.spring.bakery.modeloDTO.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class EstadoPedidoService implements IEstadoPedidoService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IEstadoPedidoRepository iEstadoPedidoRepository;
    @Override
    public EstadoPedidoDTO guardar(EstadoPedidoDTO estadoPedidoUsuarioDTO) {
        return mapearDTO(iEstadoPedidoRepository.save(mapearClase(estadoPedidoUsuarioDTO)));
    }

    @Override
    public ArrayList<EstadoPedidoDTO> obtener() {
        ArrayList<EstadoPedido> listaPedidos = (ArrayList<EstadoPedido>) iEstadoPedidoRepository.findAll();
        return (ArrayList<EstadoPedidoDTO>) listaPedidos.stream().map(estadoPedido -> mapearDTO(estadoPedido)).collect(Collectors.toList());
    }

    @Override
    public EstadoPedidoDTO buscarId(int id) {
        return mapearDTO(iEstadoPedidoRepository.findById(id).orElseThrow(()->new ResourceNoFound("Estado Pedido","id",id)));
    }

    @Override
    public EstadoPedidoDTO actualizar(EstadoPedidoDTO estadoPedidoDTO) {
        EstadoPedido estadoPedido = iEstadoPedidoRepository.findById(estadoPedidoDTO.getId()).orElseThrow(()->new ResourceNoFound("Estado","ID",estadoPedidoDTO.getId()));
        estadoPedido = mapearClase(estadoPedidoDTO);
        return mapearDTO(iEstadoPedidoRepository.save(estadoPedido));
    }

    @Override
    public void eliminar(int id) {
        iEstadoPedidoRepository.delete(iEstadoPedidoRepository.findById(id).orElseThrow(()->new ResourceNoFound("Estado Pedido","id",id)));
    }

    private EstadoPedidoDTO mapearDTO(EstadoPedido estadoPedido){
        return modelMapper.map(estadoPedido,EstadoPedidoDTO.class);
    }

    private EstadoPedido mapearClase(EstadoPedidoDTO estadoPedidoDTO){
        return modelMapper.map(estadoPedidoDTO,EstadoPedido.class);
    }

}
