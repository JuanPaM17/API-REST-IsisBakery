package com.spring.bakery.modelo;


import jakarta.persistence.*;

@Entity
@Table(name = "tblventa",uniqueConstraints = @UniqueConstraint(columnNames = {"nit"}))
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Usuario vendedor;

    @Column(name = "nit",nullable = false)
    private long nit;

    @Column(name = "fecha_generacion",nullable = false)
    private String fechaGeneracion;

    public Venta(int id, Pedido pedido, Usuario vendedor, long nit, String fechaGeneracion) {
        this.id = id;
        this.pedido = pedido;
        this.vendedor = vendedor;
        this.nit = nit;
        this.fechaGeneracion = fechaGeneracion;
    }

    public Venta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
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
                ", pedido=" + pedido +
                ", vendedor=" + vendedor +
                ", nit=" + nit +
                ", fechaGeneracion='" + fechaGeneracion + '\'' +
                '}';
    }
}
