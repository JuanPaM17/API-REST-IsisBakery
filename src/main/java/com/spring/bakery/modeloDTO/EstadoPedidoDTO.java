package com.spring.bakery.modeloDTO;

public class EstadoPedidoDTO {

    private int id;

    private String nombre;

    public EstadoPedidoDTO() {
    }

    public EstadoPedidoDTO(int id, String nombre) {
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
