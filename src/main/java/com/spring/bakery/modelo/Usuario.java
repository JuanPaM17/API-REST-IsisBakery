package com.spring.bakery.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tblusuario",uniqueConstraints = @UniqueConstraint(columnNames = {"cedula","celular","correo"}))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "", nullable = false)
    private String nombre;
    @Column(name = "cedula", nullable = false)
    private long cedula;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "fecha_nacimiento", nullable = false)
    private String fechaNacimiento;
    @Column(name = "celular", nullable = false)
    private long celular;
    @Column(name = "correo", nullable = false)
    private String correo;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estadoUsuario_id", nullable = false)
    private EstadoUsuario estadoUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoUsuario_id", nullable = false)
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(int id, String nombre, long cedula, String apellido, String fechaNacimiento, long celular, String correo, String direccion, String color, String contrasena, EstadoUsuario estadoUsuario, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.color = color;
        this.contrasena = contrasena;
        this.estadoUsuario = estadoUsuario;
        this.tipoUsuario = tipoUsuario;
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

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", celular=" + celular +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", color='" + color + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", estadoUsuario=" + estadoUsuario +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
