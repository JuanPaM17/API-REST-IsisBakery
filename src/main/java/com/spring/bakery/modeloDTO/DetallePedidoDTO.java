package com.spring.bakery.modeloDTO;

public class DetallePedidoDTO {
    private int id;

    private int cantidad;

    private float subTotal;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(int id, int cantidad, float subTotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", subTotal=" + subTotal +
                '}';
    }
}
