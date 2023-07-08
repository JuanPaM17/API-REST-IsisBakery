package com.spring.bakery.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "tblpedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario cliente;

    @Column(name = "total",nullable = false)
    private float total;

    @Column(name = "fecha_recogida",nullable = false)
    private String fechaRecogida;

    @Column(name = "hora_recogida",nullable = false)
    private String horaRegocida;

    @Column(name = "nombre_recoge",nullable = false)
    private String nombreRecoge;

    @Column(name = "telefono_contacto",nullable = false)
    private long telefonoContacto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estadoPedido_id", nullable = false)
    private EstadoPedido estadoPedido;

    public Pedido() {
    }

    public Pedido(int id, Usuario cliente, float total, String fechaRecogida, String horaRegocida, String nombreRecoge, long telefonoContacto, EstadoPedido estadoPedido) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.fechaRecogida = fechaRecogida;
        this.horaRegocida = horaRegocida;
        this.nombreRecoge = nombreRecoge;
        this.telefonoContacto = telefonoContacto;
        this.estadoPedido = estadoPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
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

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", total=" + total +
                ", fechaRecogida='" + fechaRecogida + '\'' +
                ", horaRegocida='" + horaRegocida + '\'' +
                ", nombreRecoge='" + nombreRecoge + '\'' +
                ", telefonoContacto=" + telefonoContacto +
                ", estadoPedido=" + estadoPedido +
                '}';
    }
}
