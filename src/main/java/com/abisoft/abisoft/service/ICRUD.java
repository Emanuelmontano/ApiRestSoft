package com.abisoft.abisoft.service;

import java.util.List;

public interface ICRUD<T> {

	T crear(T t);
	
	T editar(T t);

	void eliminar(Object id);

	T listarPorId(Object id);

	List<T> listar();
}
