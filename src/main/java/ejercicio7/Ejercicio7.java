/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ismael
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// Fichero a leer con datos de ejemplo
        String idFichero = "/home/ismael/NetBeansProjects/ejerciciosFicheros/src/main/java/ejercicio4/array.csv";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList<Vehiculo> lista = new ArrayList<>();
        System.out.println("Leyendo el fichero: " + idFichero);
        int nvehiculos=0;
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
                        lista.add(new Furgoneta(tokens[1], tokens[2], tokens[3], tokens[4],
                                Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6])));
                    } else {
                        lista.add(new Deportivo(tokens[1], tokens[2], tokens[3], tokens[4],
                                Double.parseDouble(tokens[5]), Boolean.parseBoolean(tokens[6])));
                    }
                    
                
nvehiculos++;
            } 
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }             
        Collections.sort(lista, (c1,c2)->c1.getMarca().compareTo(c2.getMarca()));
        for (Vehiculo vehiculo : lista) {
                    System.out.println(vehiculo.toString());
                }
                System.out.println(nvehiculos);
    }
}
