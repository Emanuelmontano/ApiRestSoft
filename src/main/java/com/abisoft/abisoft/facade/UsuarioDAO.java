package com.abisoft.abisoft.facade;

import com.abisoft.abisoft.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{
    
    @Query(value = "SELECT s FROM Usuario s WHERE s.identificacion = :identificacionUsuario")
    Usuario findByIdUser(@Param ("identificacion")  String   identificacionUsuario);
}
