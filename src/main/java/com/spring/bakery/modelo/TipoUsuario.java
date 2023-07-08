package com.spring.bakery.modelo;
import jakarta.persistence.*;

@Entity
@Table(name="tbltipo_usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    public TipoUsuario() {
    }

    public TipoUsuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EstadoPedido{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
