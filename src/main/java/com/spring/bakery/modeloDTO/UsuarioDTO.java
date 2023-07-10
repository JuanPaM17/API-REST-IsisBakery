package com.spring.bakery.modeloDTO;

import jakarta.validation.constraints.*;

public class UsuarioDTO {

    private int id;
    @NotEmpty
    @Size(min=5,message = "El nombre debe tener almenos 5 Caracteres")
    private String nombre;
    @NotEmpty
    @Size(min=10,message = "La cedula debe tener almenos 10 Caracteres")
    private long cedula;
    @NotEmpty
    @Size(min=5,message = "El apellido debe tener almenos 5 Caracteres")
    private String apellido;
    @NotEmpty
    @Size(min=9,message = "La fecha debe tener almenos 9 Caracteres")
    private String fechaNacimiento;
    @NotEmpty
    @Size(min=10,message = "El numero debe tener almenos 10 Caracteres")
    private long celular;
    @NotEmpty
    @Size(min=5,message = "El correo debe tener almenos 5 Caracteres")
    private String correo;
    @NotEmpty
    @Size(min=5,message = "La direccion debe tener almenos 5 Caracteres")
    private String direccion;
    @NotEmpty
    @Size(min=5,message = "El color debe tener almenos 5 Caracteres")
    private String color;
    @NotEmpty
    @Size(min=5,message = "La contraseña debe tener almenos 5 Caracteres")
    private String contrasena;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String nombre, long cedula, String apellido, String fechaNacimiento, long celular, String correo, String direccion, String color, String contrasena, EstadoUsuarioDTO estadoUsuario, TipoUsuarioDTO tipoUsuario) {
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
                '}';
    }
}
