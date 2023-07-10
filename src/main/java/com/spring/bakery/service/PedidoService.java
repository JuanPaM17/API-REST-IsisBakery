package com.spring.bakery.service;

import com.spring.bakery.exception.ResourceNoFound;
import com.spring.bakery.iRepository.IEstadoPedidoRepository;
import com.spring.bakery.iRepository.IPedidoRepository;
import com.spring.bakery.iRepository.IUsuarioRepository;
import com.spring.bakery.iService.IEstadoPedidoService;
import com.spring.bakery.iService.IPedidoService;
import com.spring.bakery.modelo.Pedido;
import com.spring.bakery.modelo.TipoUsuario;
import com.spring.bakery.modeloDTO.PedidoDTO;
import com.spring.bakery.modeloDTO.TipoUsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service

public class PedidoService implements IPedidoService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IPedidoRepository iPedidoRepository;

    @Autowired
    private IEstadoPedidoRepository iEstadoPedidoRepository;

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public PedidoDTO guardar(PedidoDTO pedidoDTO,int id_estado_pedido,int id_cliente) {
        Pedido pedido = mapearClase(pedidoDTO);
        pedido.setCliente(iUsuarioRepository.findById(id_cliente).orElseThrow(()->
                new ResourceNoFound("Usuario","id",id_cliente)));
        pedido.setEstadoPedido(iEstadoPedidoRepository.findById(id_estado_pedido).orElseThrow(
                ()-> new ResourceNoFound("Estado Pedido","ID", id_estado_pedido)
        ));
        return mapearDTO(iPedidoRepository.save(pedido));
    }

    @Override
    public ArrayList<PedidoDTO> obtener() {
        return (ArrayList<PedidoDTO>) iPedidoRepository.findAll().stream().map(pedido->mapearDTO(pedido)).collect(Collectors.toList()) ;
    }

    @Override
    public PedidoDTO buscarId(int id) {
        return mapearDTO(iPedidoRepository.findById(id).orElseThrow(()->new ResourceNoFound("Pedido","Id",id)));
    }

    @Override
    public PedidoDTO actualizar(PedidoDTO pedidoDTO) {
        Pedido pedido = iPedidoRepository.findById(pedidoDTO.getId()).orElseThrow(()->new ResourceNoFound("Pedido","Id",pedidoDTO.getId()));
        pedido = mapearClase(pedidoDTO);
        return mapearDTO(iPedidoRepository.save(pedido));
    }

    @Override
    public void eliminar(int id) {
        iPedidoRepository.delete(
                iPedidoRepository.findById(id).orElseThrow(()->
                        new ResourceNoFound("Pedido","ID",id)));
    }
    private PedidoDTO mapearDTO(Pedido pedido){
        return modelMapper.map(pedido,PedidoDTO.class);
    }

    private Pedido mapearClase(PedidoDTO pedidoDTO){
        return modelMapper.map(pedidoDTO,Pedido.class);
    }

}
