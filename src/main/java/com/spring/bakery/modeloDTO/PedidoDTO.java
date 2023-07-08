package com.spring.bakery.modeloDTO;

public class PedidoDTO {

    private int id;

    private float total;

    private String fechaRecogida;

    private String horaRegocida;

    private String nombreRecoge;

    private long telefonoContacto;

    public PedidoDTO() {
    }

    public PedidoDTO(int id, float total, String fechaRecogida, String horaRegocida, String nombreRecoge, long telefonoContacto) {
        this.id = id;
        this.total = total;
        this.fechaRecogida = fechaRecogida;
        this.horaRegocida = horaRegocida;
        this.nombreRecoge = nombreRecoge;
        this.telefonoContacto = telefonoContacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(String fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }

    public String getHoraRegocida() {
        return horaRegocida;
    }

    public void setHoraRegocida(String horaRegocida) {
        this.horaRegocida = horaRegocida;
    }

    public String getNombreRecoge() {
        return nombreRecoge;
    }

    public void setNombreRecoge(String nombreRecoge) {
        this.nombreRecoge = nombreRecoge;
    }

    public long getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(long telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", total=" + total +
                ", fechaRecogida='" + fechaRecogida + '\'' +
                ", horaRegocida='" + horaRegocida + '\'' +
                ", nombreRecoge='" + nombreRecoge + '\'' +
                ", telefonoContacto=" + telefonoContacto +
                '}';
    }
}
