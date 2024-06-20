package com.example.lab9_20211688.beans;

public class UsuarioB {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String telefono;
    private int idRol;
    private LicenciaB licenciaB;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public LicenciaB getLicenciaB() {
        return licenciaB;
    }

    public void setLicenciaB(LicenciaB licenciaB) {
        this.licenciaB = licenciaB;
    }
}
