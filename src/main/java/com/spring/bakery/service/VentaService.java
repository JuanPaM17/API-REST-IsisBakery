package com.spring.bakery.service;

import com.spring.bakery.exception.ResourceNoFound;
import com.spring.bakery.iRepository.IVentaRepository;
import com.spring.bakery.iService.IVentaService;
import com.spring.bakery.modelo.Usuario;
import com.spring.bakery.modelo.Venta;
import com.spring.bakery.modeloDTO.UsuarioDTO;
import com.spring.bakery.modeloDTO.VentaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IVentaRepository iVentaRepository;

    @Override
    public VentaDTO guardar(VentaDTO ventaDTO) {
        return mapearDTO(iVentaRepository.save(mapearClase(ventaDTO)));
    }

    @Override
    public ArrayList<VentaDTO> obtener() {
        ArrayList<Venta> listaVentas = (ArrayList<Venta>) iVentaRepository.findAll();
        return (ArrayList<VentaDTO>) listaVentas.stream().map(venta -> mapearDTO(venta)).collect(Collectors.toList());
    }

    @Override
    public VentaDTO buscarId(int id) {
        Venta venta = iVentaRepository.findById(id).orElseThrow(()-> new ResourceNoFound("Venta","id",id));
        return mapearDTO(venta);
    }

    @Override
    public VentaDTO actualizar(VentaDTO ventaDTO) {
        Venta venta = iVentaRepository.findById(ventaDTO.getId()).orElseThrow(()-> new ResourceNoFound("Venta","id",ventaDTO.getId()));
        venta = mapearClase(ventaDTO);
        return mapearDTO(iVentaRepository.save(venta));
    }

    @Override
    public void eliminar(int id) {
        Venta venta = iVentaRepository.findById(id).orElseThrow(()-> new ResourceNoFound("Venta","id",id));
        iVentaRepository.delete(venta);
    }

    private VentaDTO mapearDTO(Venta venta){
        return modelMapper.map(venta,VentaDTO.class);
    }

    private Venta mapearClase(VentaDTO ventaDTO){
        return modelMapper.map(ventaDTO,Venta.class);
    }


}
