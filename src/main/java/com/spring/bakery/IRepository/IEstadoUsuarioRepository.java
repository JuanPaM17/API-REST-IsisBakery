package com.spring.bakery.IRepository;

import com.spring.bakery.modelo.EstadoUsuario;
import com.spring.bakery.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoUsuarioRepository extends JpaRepository<EstadoUsuario,Integer> {

}
