package com.potoware.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.potoware.java.jdbc.models.Producto;
import com.potoware.java.jdbc.repositorio.ProductoRepositorio;
import com.potoware.java.jdbc.repositorio.Repositorio;
import com.potoware.java.jdbc.util.ConexionBaseDatos;

public class EjemploJdbc {
public static void main(String[] args) {
		
	try (Connection conn = ConexionBaseDatos.getInstance();){
		
		Repositorio<Producto> repo = new ProductoRepositorio();
		System.out.println("==============Listar==================");

		repo.listar().forEach(System.out::println);
		System.out.println("==============Obtener Por ID==================");
		System.out.println(repo.porId(2L));
		System.out.println("==============Insertar Producto==================");
		Producto producto = new Producto();
		
		producto.setNombre("Teclado Mecanico");
		producto.setPrecio(300000);
		producto.setFechaRegistro(new Date());
		
		repo.guardar(producto);
		System.out.println("Se guardo el producto");
		repo.listar().forEach(System.out::println);
		
		
				
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
	
	}
}
}
