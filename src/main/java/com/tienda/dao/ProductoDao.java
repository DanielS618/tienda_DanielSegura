package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao {
    
   List<Producto> findByExistencias(int existencias);

    List<Producto> findByExistenciasAndPrecio(int existencias, double precio);

    //Ejemplo de método utilizando Métodos de Query
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value = "SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery = true,
            value = "SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    @Query(nativeQuery = true,
            value = "SELECT p.* FROM producto p " + "JOIN venta v ON p.id_producto = v.id_producto "
            + "JOIN factura f ON v.id_factura = f.id_factura " + "WHERE p.id_categoria = :idCategoria "
            + "GROUP BY p.id_producto " + "ORDER BY SUM(v.cantidad) DESC " + "LIMIT 1")
    public Producto findMostSoldProductByCategory(@Param("idCategoria") int idCategoria);

}
