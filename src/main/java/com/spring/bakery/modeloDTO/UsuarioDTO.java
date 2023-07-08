package com.spring.bakery.modeloDTO;

public class UsuarioDTO {

    private int id;
    private String nombre;
    private long cedula;
    private String apellido;
    private String fechaNacimiento;
    private long celular;
    private String correo;
    private String direccion;
    private String color;
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
