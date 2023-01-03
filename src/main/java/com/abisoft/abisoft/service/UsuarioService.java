package com.abisoft.abisoft.service;

import com.abisoft.abisoft.domain.Usuario;
import com.abisoft.abisoft.dto.ResponseWs;
import com.abisoft.abisoft.dto.UsuarioDTO;

public interface UsuarioService extends ICRUD<Usuario>{
    
    Usuario findByIdUser( String identificacionUsuario);
    
    ResponseWs registroUsuario(UsuarioDTO per);

}
