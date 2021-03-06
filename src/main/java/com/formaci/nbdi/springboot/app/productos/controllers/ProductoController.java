package com.formaci.nbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formaci.nbdi.springboot.app.commons.models.entity.Producto;
import com.formaci.nbdi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	//@GetMapping("/listar")
	@RequestMapping(method = RequestMethod.GET, value= "/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	//@GetMapping("/listar/{id}")
	@RequestMapping(method = RequestMethod.GET, value= "/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		//return productoService.findById(id);
		
		// Provocando un error
	/*	boolean ok = false;
		if(ok == false) {
			throw new Exception("No se puede cargar el producto");
		}*/
		
		//Realizar una pausa
		/*try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}*/
		return producto;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		return productoService.save(producto);
		
		
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editar(@RequestBody Producto produto, @PathVariable Long id) {
		Producto productoDb = productoService.findById(id);
		productoDb.setNombre(produto.getNombre());
		productoDb.setPrecio(produto.getPrecio());
		return productoService.save(productoDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		productoService.deleteById(id);
	}
	
}
