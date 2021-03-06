/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ismael
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "./src/main/java/ejercicio4/array.csv";

        ArrayList<Vehiculo> lista = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            lista.add(new Furgoneta());
            lista.add(new Coche());
            lista.add(new Deportivo());
        }

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            flujo.write("Tipo:Matricula:Marca:Modelo:Color:Tarifa:Disponible");
            flujo.newLine();
            for (Vehiculo vehiculo : lista) {

                flujo.write(vehiculo.toString());
                flujo.newLine();

            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
