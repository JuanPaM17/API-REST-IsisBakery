package com.spring.bakery.IRepository;

import com.spring.bakery.modelo.Usuario;
import com.spring.bakery.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Integer> {

}
