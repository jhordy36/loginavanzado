package com.example.oma.loginavanzado;

public class usuario {
    int id;
    String nombre,telefono,correo,contraseña;

    public usuario() {
    }

    public usuario(String nombre, String telefono, String correo, String contraseña) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public boolean isNull(){
        if(nombre.equals("")&&correo.equals("")&&contraseña.equals("")&&telefono.equals("")){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
