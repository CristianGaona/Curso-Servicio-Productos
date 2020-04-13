package com.formaci.nbdi.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formaci.nbdi.springboot.app.commons.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

	
}
