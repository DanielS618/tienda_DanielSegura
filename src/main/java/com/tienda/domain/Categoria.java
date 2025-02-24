package com.tienda.domain;
import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Data  //generar por dejabo los set y get
@Entity
@Table(name = "categoria") //aqui va el nombre de la tabla con la que voy a hacer relacion
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Categoria")
    private Long idCategoria; //Esto es id_categoria
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    public Categoria(){       
    }
    public Categoria(String descripcion,String rutaImagen, boolean activo)
    {   
        this.descripcion = descripcion;
        this.activo = activo;
        this.rutaImagen = rutaImagen;
    }
}
