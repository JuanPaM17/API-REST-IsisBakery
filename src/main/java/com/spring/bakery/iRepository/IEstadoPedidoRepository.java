package com.spring.bakery.iRepository;

import com.spring.bakery.modelo.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoPedidoRepository extends JpaRepository<EstadoPedido,Integer> {

}
