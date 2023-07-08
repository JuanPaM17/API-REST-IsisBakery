package com.spring.bakery.IRepository;

import com.spring.bakery.modelo.Pedido;
import com.spring.bakery.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido,Integer> {

}
