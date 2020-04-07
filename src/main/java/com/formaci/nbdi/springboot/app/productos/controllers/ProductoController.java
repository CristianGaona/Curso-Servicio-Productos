package com.formaci.nbdi.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formaci.nbdi.springboot.app.productos.models.entity.Producto;
import com.formaci.nbdi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	//@GetMapping("/listar")
	@RequestMapping(method = RequestMethod.GET, value= "/listar")
	public List<Producto> listar(){
		return productoService.findAll();
	}
	
	//@GetMapping("/listar/{id}")
	@RequestMapping(method = RequestMethod.GET, value= "/listar/{id}")
	public Producto detalle(@PathVariable Long id) {
		return productoService.findById(id);
	}
}
