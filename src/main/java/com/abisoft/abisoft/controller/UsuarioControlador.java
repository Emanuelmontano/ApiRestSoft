package com.abisoft.abisoft.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abisoft.abisoft.domain.Usuario;
import com.abisoft.abisoft.dto.ResponseWs;
import com.abisoft.abisoft.dto.UsuarioDTO;
import com.abisoft.abisoft.exception.ModeloNotFoundException;
import com.abisoft.abisoft.exception.MyResourceNotFoundException;
import com.abisoft.abisoft.service.UsuarioService;

@RestController
@RequestMapping("prestamo")
public class UsuarioControlador {

    @Autowired
    private UsuarioService service;

    @GetMapping()
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> list = service.listar();
        return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@RequestBody UsuarioDTO per) {
    	ResponseWs rpta = new ResponseWs();
    	try {
			rpta = service.registroUsuario(per);
		} catch (Exception e) {
			throw new ModeloNotFoundException(e.getMessage());
		}
    	return ResponseEntity.status(rpta.getCode()).body(rpta.getMensaje());
    }

    @GetMapping(value = "/{id}")
    public Usuario listarPorId(@PathVariable("id") Integer id) {
    	Usuario user;
        try {
        	user = service.listarPorId(id);
        } catch (Exception e) {
            throw new MyResourceNotFoundException("ID NO ENCONTRADO ", e);
        }
        return user;
    }

}

