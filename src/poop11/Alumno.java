/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop11;

/**
 *
 * @author lilian
 */
public class Alumno {
    String nombre, apellidoMaterno, apellidoPaterno, numCuenta;
    int edad;

    public Alumno() {
    }

    public Alumno(String nombre, String apellidoMaterno, String apellidoPaterno, String numCuenta, int edad) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.numCuenta = numCuenta;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno + ", numCuenta=" + numCuenta + ", edad=" + edad + '}';
    }
  
}

