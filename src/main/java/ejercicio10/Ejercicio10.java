/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import ejercicio9B.Coche;
import ejercicio9B.Deportivo;
import ejercicio9B.Furgoneta;
import ejercicio9B.Vehiculo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author ismae
 */
public class Ejercicio10 {
//Imprime por pantalla todos los coches blancos, distintos, ordenador por matrícula.
//Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles.
//Saber la cantidad de vehículos de una marca cualquiera.
//Comprueba si hay algún Peugeot negro disponible en la lista. Si no tienes Peugeot entre tus marcas usa otra.

    public static void main(String[] args) {
        String idFichero1 = "./src/main/java/ejercicio9B/vehiculos0.csv";
        String idFichero2 = "./src/main/java/ejercicio9B/vehiculos1.csv";
        String idFichero3 = "./src/main/java/ejercicio9B/vehiculos2.csv";
        ArrayList<Vehiculo> lista = new ArrayList<>();
        copiarFicheros(idFichero1, "./src/main/java/ejercicio10/copias");
        copiarFicheros(idFichero2, "./src/main/java/ejercicio10/copias");
        copiarFicheros(idFichero3, "./src/main/java/ejercicio10/copias");
        listarDirectorio("./src/main/java/ejercicio10/copias");//hay alguna manera de que me devuelva esta funcion los nombres?
        leerFichero("./src/main/java/ejercicio10/copias/vehiculo0.csv", lista);
        leerFichero("./src/main/java/ejercicio10/copias/vehiculo1.csv", lista);
        leerFichero("./src/main/java/ejercicio10/copias/vehiculo2.csv", lista);
        for (Vehiculo vehiculo : lista) {
            System.out.println(vehiculo.toString());
        }
        borrarElemento(idFichero1);
        borrarElemento(idFichero2);
        borrarElemento(idFichero3);
        listarDirectorio("./src/main/java/ejercicio9B");
          System.out.println("¿Existe "+idFichero1+" ? "
                + Files.exists(Paths.get(idFichero2)));
          System.out.println("¿Existe "+idFichero2+" ? "
                + Files.exists(Paths.get(idFichero2)));
          System.out.println("¿Existe "+idFichero3+" ? "
                + Files.exists(Paths.get(idFichero3)));
//            HashSet<Vehiculo> listaB1 =lista.stream().
            
        
    }

    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);
        try {
            Files.copy(origen, destino);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");
            System.out.println(e.toString());
        }
    }

    public static void listarDirectorio(String ruta) {

        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }

    public static void leerFichero(String idFichero, ArrayList<Vehiculo> lista) {
        String[] tokens;
        String linea;
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
                    lista.add(new Furgoneta(tokens[1], tokens[2], tokens[3], tokens[4],
                            Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6])));
                } else {
                    lista.add(new Deportivo(tokens[1], tokens[2], tokens[3], tokens[4],
                            Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
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

    public static void borrarElemento(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.delete(file);
        } catch (NoSuchFileException nsfe) {
            System.out.println("No se puede borrar " + ruta + " porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No se puede borrar el directorio porque no está vacío");
        } catch (IOException e) {
            System.out.println("Problema borrando el elemento " + ruta);
        }
    }

}
