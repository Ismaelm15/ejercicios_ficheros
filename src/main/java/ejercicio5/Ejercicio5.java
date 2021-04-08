/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ismae
 */
public class Ejercicio5 {
     public static void main(String[] args) {

        // Fichero a leer con datos de ejemplo
        String idFichero = "./src/main/java/ejercicio1/array.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String[] numeros;
        String linea;
        int resultado=0;
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) { 
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
              
                tokens = linea.split(";");
                numeros=linea.split("\t");
                for(int i=0; i<numeros.length;i++){
                resultado+=Integer.parseInt(numeros[i]);
                
                }
                for (String string : tokens) {

                    System.out.print(string + "\t");
                }
                System.out.println();
                
            }
            System.out.println("El resultado es "+resultado);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
