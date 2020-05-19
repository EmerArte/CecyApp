package com.example.cecyapp.clases;

//esta clase se nuestra clase "padre"
public class Persona {
    private  int id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String correo;
    private String celular;
    private  int edad;

    public Persona(int id, String nombres, String apellidos, String direccion, String correo, String celular, int edad) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.correo=correo;
        this.celular = celular;
        this.edad = edad;
    }
    public  Persona(){
        id=0;
        nombres="";
        apellidos="";
        direccion="";
        correo="";
        celular="";
        edad=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
