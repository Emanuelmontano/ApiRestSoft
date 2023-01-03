package com.abisoft.abisoft.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.abisoft.abisoft.domain.Usuario;
import com.abisoft.abisoft.dto.ResponseWs;
import com.abisoft.abisoft.dto.UsuarioDTO;
import com.abisoft.abisoft.facade.UsuarioDAO;
import com.abisoft.abisoft.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO dao;

	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Override
	public Usuario crear(Usuario t) {
		return dao.save(t);
	}

	@Override
	public Usuario editar(Usuario t) {
		return dao.save(t);
	}

	@Override
	public Usuario listarPorId(Object id) {
		return dao.findById((Integer) id).get();
	}

	@Override
	public Usuario findByIdUser(String identificacionUsuario) {
		return dao.findByIdUser(identificacionUsuario);
	}

	@Override
	public void eliminar(Object id) {
		dao.deleteById((Integer) id);
	}

	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Override
	public ResponseWs registroUsuario(UsuarioDTO user) {
		ResponseWs rpta = new ResponseWs();

		if (user.getFechaNacimiento().compareTo(user.getFechaInscripcion()) > 1) {
			rpta.setCode(HttpStatus.BAD_REQUEST);
			rpta.setMensaje("La fecha de Inscripción es mayor que la fecha de nacimiento");
			return rpta;
		}

		Long edad = edad(user.getFechaNacimiento());
		if (edad >=18) {
			rpta.setCode(HttpStatus.BAD_REQUEST);
			rpta.setMensaje("EL usuario debe ser mayor de edad");
			return rpta;
		}
		if (edad != user.getEdad()) {
			rpta.setCode(HttpStatus.BAD_REQUEST);
			rpta.setMensaje("La edad ingresada no coincide con la fecha de nacimiento");
			return rpta;
		}
		Long anioCosto= edad(user.getFechaInscripcion());
		Long costoAnio = 100 * anioCosto;
		if (costoAnio <= user.getCosto()) {
			rpta.setCode(HttpStatus.BAD_REQUEST);
			rpta.setMensaje("El costo es proporcional a la fecha de Inscripción o mayor a : "+costoAnio);
			return rpta;
		}
		

		Usuario usuario = crear(new Usuario(user.getNombre(), user.getApellido(), user.getIdentificacionUsuario(),
				user.getEdad(), user.getFechaNacimiento(), user.getFechaInscripcion(), user.getCosto()));

		if (usuario == null) {
			rpta.setCode(HttpStatus.BAD_REQUEST);
			rpta.setMensaje("ID NO ENCONTRADO");
			return rpta;
		}

		rpta.setCode(HttpStatus.OK);
		rpta.setMensaje("Se creo el usuario: " + usuario.getId());
		return rpta;
	}
	
	private Long edad(Date fecha) {
		LocalDate fech = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ChronoUnit.YEARS.between(fech, LocalDate.now());
	}

}
