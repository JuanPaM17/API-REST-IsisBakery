package com.spring.bakery.IRepository;

import com.spring.bakery.modelo.TipoUsuario;
import com.spring.bakery.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario,Integer> {

}
