package com.spring.bakery.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "tbldetalle_pedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(name="cantidad",nullable = false)
    private int cantidad;

    @Column(name="subtotal",nullable = false)
    private float subTotal;


}
