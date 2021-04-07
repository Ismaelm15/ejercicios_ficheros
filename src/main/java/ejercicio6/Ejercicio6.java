/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ismae
 */
public class Ejercicio6 {

    public static void main(String[] args) {

        // Fichero a leer con datos de ejemplo
        String idFichero = "./src/main/java/ejercicio3/50lineas.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        int contadorLinea = 0;
        boolean salir = false;
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                contadorLinea++;
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == 'j' || linea.charAt(i) == 'J') {
                        if (linea.charAt(i + 1) == 'v' || linea.charAt(i + 1) == 'V') {
                            System.out.println("Se ha encontrado una coincidencia en la linea " + contadorLinea + " en la posicion " + i);
                            salir = true;
                        }
                    }
                }
 
                System.out.println(linea);
                System.out.println();
                
                if (salir) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
