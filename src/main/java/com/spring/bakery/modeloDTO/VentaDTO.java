package com.spring.bakery.modeloDTO;

public class VentaDTO {

    private int id;

    private long nit;

    private String fechaGeneracion;

    public VentaDTO(int id, long nit, String fechaGeneracion) {
        this.id = id;
        this.nit = nit;
        this.fechaGeneracion = fechaGeneracion;
    }

    public VentaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", nit=" + nit +
                ", fechaGeneracion='" + fechaGeneracion + '\'' +
                '}';
    }
}
