/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poop11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *  Clase principal que contiene el método main para ejecutar el programa.
 * @author poo08alu21
 */
public class POOP11 {

    /**
     * Método principal que inicia la ejecución del programa.
     *
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Verifica la existencia y crea el archivo "archivo.txt" si no existe
        System.out.println("###### File #####");
        File archivo = new File("archivo.txt");
        System.out.println("Archivo existe: " + archivo.exists());
        if(!archivo.exists()){
            try{
            boolean seCreo = archivo.createNewFile();
                System.out.println("Se creo un archivo: " +seCreo);
                System.out.println("Archivo existe: " +archivo.exists());
            } catch (IOException ex){
                System.out.println("ex.getMessage()");
            }
        } 
        // Realiza operaciones de lectura y escritura de archivos
        System.out.println("##### FileWriter ######");
        try {
            // Lee una cadena desde la entrada estándar
            System.out.println("### Lectura desde teclado ###");
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); //desde mi teclado se va a depositar en un buffer
            System.out.println("Escriba el texto para el archivo");
            String texto = br.readLine();
            System.out.println("El usuario escribio: "+ texto);

            // Escribe en el archivo "archivo.txt"
            System.out.println("### Escritura del archivo ###");
            FileWriter fw = new FileWriter("archivo.txt");
            BufferedWriter bw = new BufferedWriter(fw); // se crea el file writer
            PrintWriter impresoraDeArchivos = new PrintWriter(bw); //se necesita una impresora de archivos
            impresoraDeArchivos.println(texto); //obtiene la cadena que el usuario creo
            impresoraDeArchivos.close();
            
            // Lee el contenido del archivo "archivo.txt"
            System.out.println("### Lectura del archivo ###");
            FileReader fr = new FileReader("archivo.txt");
            br = new BufferedReader(fr); 
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            while (linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();

            // Tokeniza una cadena usando StringTokenizer
            System.out.println("##### StringTokenizer ######");
            String alumno = "Hector Juan,Jimenez,Maya,423049031,20,8.3";
            System.out.println("Cadena a tokenizar: " + alumno);
            StringTokenizer tokenizador = new StringTokenizer(alumno, ",");
            while(tokenizador.hasMoreTokens()){
                System.out.println(tokenizador.nextToken());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
    
        // Realiza una actividad extra: escribe y lee un archivo "alumno.csv"
        System.out.println("##### Actividad extra ####");
        try {
            
            System.out.println("### Escritura del archivo ###");
            // Escribe en el archivo "alumno.csv"
            FileWriter fw = new FileWriter("alumno.csv");
            BufferedWriter bw = new BufferedWriter(fw); // se crea el file writer
            PrintWriter impresoraDeArchivos = new PrintWriter(bw); //se necesita una impresora de archivos
            impresoraDeArchivos.println("Rodrigo,Sanchez,20,5576900431, Atizapan");
            impresoraDeArchivos.println("Paola,Ramirez,21,5512980657, Tlalnepantla");
            impresoraDeArchivos.println("Sandra,Gutierrez,19,5532097865, Cuautitlan");
            impresoraDeArchivos.println("Luis,Trujillo,18,5567432389, Benito Juarez");
            impresoraDeArchivos.println("Marisol,Mendez,22,432345432, Coyoacan");
            impresoraDeArchivos.println("Viviana,Vasquez,20,5532096745, Atizapan");
            impresoraDeArchivos.println("Rosalia,Huerta,19,551678094533, Iztapalapa");
            impresoraDeArchivos.println("Carlotta,Juarez,21,5545634509, Xochimilco");
            impresoraDeArchivos.println("Nadia,Torres,22,5521098765, Iztacalco");
            impresoraDeArchivos.println("Carlos,Valderrama,19,5523098745, Iztapalapa");
            
            impresoraDeArchivos.close();
            
            // Lee el contenido del archivo "alumno.csv"
            System.out.println("### Lectura del archivo ###");
            FileReader fr = new FileReader("alumno.csv");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("El texto del archivo es: ");
            String linea = br.readLine();
            while (linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        // Crea y manipula un array de objetos Alumno
        Alumno[] alumnos = new Alumno[10];
        alumnos[0] = new Alumno("Juan", "Perez", "Gomez", "123456", 20);
        // Inicializa los demás alumnos de manera similar

        // Escribir en un archivo *.csv
        escribirCSV(alumnos, "alumnos.csv");

        // Leer el archivo de texto creado y crear un nuevo arreglo/lista
        List<Alumno> alumnosLeidos = leerCSV("alumnos.csv");

        // Imprimir la información de los alumnos leídos
        for (Alumno alumno : alumnosLeidos) {
            System.out.println("Nombre: " + alumno.nombre +
                    ", Apellido Paterno: " + alumno.apellidoPaterno +
                    ", Apellido Materno: " + alumno.apellidoMaterno +
                    ", Número de Cuenta: " + alumno.numCuenta +
                    ", Edad: " + alumno.edad);
        }
    }

    /**
     * Método para escribir en un archivo CSV.
     * @param alumnos El array de objetos Alumno a escribir en el archivo.
     * @param nombreArchivo El nombre del archivo CSV.
     */
    private static void escribirCSV(Alumno[] alumnos, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Alumno alumno : alumnos) {
                if (alumno != null){
                   writer.println(alumno.nombre + "," +
                        alumno.apellidoPaterno + "," +
                        alumno.apellidoMaterno + "," +
                        alumno.numCuenta + "," +
                        alumno.edad);
                }   
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
     * Método para leer un archivo CSV y crear una lista de objetos Alumno.
     * @param nombreArchivo El nombre del archivo CSV a leer.
     * @return Una lista de objetos Alumno creados a partir del archivo CSV.
     */
    private static List<Alumno> leerCSV(String nombreArchivo) {
        List<Alumno> alumnos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                String nombre = tokenizer.nextToken();
                String apellidoPaterno = tokenizer.nextToken();
                String apellidoMaterno = tokenizer.nextToken();
                String numeroCuenta = tokenizer.nextToken();
                int edad = Integer.parseInt(tokenizer.nextToken());

                Alumno alumno = new Alumno(nombre, apellidoPaterno, apellidoMaterno, numeroCuenta, edad);
                alumnos.add(alumno);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return alumnos;
    }
}
