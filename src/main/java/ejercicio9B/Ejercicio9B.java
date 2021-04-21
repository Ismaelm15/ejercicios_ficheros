/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9B;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ismael
 */
public class Ejercicio9B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String idFichero = "./src/main/java/ejercicio4/array.csv";
        String idFichero1 = "./src/main/java/ejercicio9B/vehiculos0.csv";
        String idFichero2 = "./src/main/java/ejercicio9B/vehiculos1.csv";
        String idFichero3 = "./src/main/java/ejercicio9B/vehiculos2.csv";
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList<Vehiculo> lista = new ArrayList<>();
        ArrayList<Vehiculo> lista1 = new ArrayList<>();
        ArrayList<Vehiculo> lista2 = new ArrayList<>();
        System.out.println("Leyendo el fichero: " + idFichero);
        int nvehiculos = 0;
        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(":");
                
                if ("0".equals(tokens[0])) {
                    lista.add(new Coche(tokens[1], tokens[2], tokens[3], tokens[4],
                            Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6])));
                } else if ("1".equals(tokens[0])) {
                    lista1.add(new Furgoneta(tokens[1], tokens[2], tokens[3], tokens[4],
                            Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6])));
                } else {
                    lista2.add(new Deportivo(tokens[1], tokens[2], tokens[3], tokens[4],
                            Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6])));
                }
                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Collections.sort(lista, (c1, c2) -> c1.getMarca().compareTo(c2.getMarca()));
        Collections.sort(lista1, (c1, c2) -> c1.getMarca().compareTo(c2.getMarca()));
        Collections.sort(lista2, (c1, c2) -> c1.getMarca().compareTo(c2.getMarca()));
        crearFichero(idFichero1);
        crearFichero(idFichero2);
        crearFichero(idFichero3);
        escribirFichero(idFichero1, lista);
        escribirFichero(idFichero2, lista1);
        escribirFichero(idFichero3, lista2);
    }
    
    public static void crearFichero(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.deleteIfExists(file);
            Files.createFile(file);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (IOException e) {
            System.out.println("Problema creando el archivo " + ruta);
            System.out.println("Probablemente la ruta esté mal escrita.");
        }
    }
    
    public static void escribirFichero(String idFichero, ArrayList<Vehiculo> v) {
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            flujo.write("Tipo:Matricula:Marca:Modelo:Color:Tarifa:Disponible");

            flujo.newLine();
            for (Vehiculo vehiculo : v) {

                flujo.write(vehiculo.toString());
                flujo.newLine();

            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
