package com.spring.bakery.IRepository;

import com.spring.bakery.modelo.Producto;
import com.spring.bakery.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Integer> {

}
