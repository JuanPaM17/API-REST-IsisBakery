package com.spring.bakery.iRepository;

import com.spring.bakery.modelo.EstadoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoUsuarioRepository extends JpaRepository<EstadoUsuario,Integer> {

}
