/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ismael
 *
 * Implementa un programa que vaya escribiendo líneas de texto en un archivo. El
 * archivo se llamará “teclado.txt” y se creará en la raíz del proyecto. El
 * programa irá solicitando líneas de texto al usuario (cada línea termina con
 * un salto de línea , ‘\n’) y las irá escribiendo en el fichero. Cuando en una
 * nueva línea el usuario introduzca el texto “EOF”, el programa terminará y esa
 * línea no se escribirá en el fichero. Controla las posibles excepciones que
 * pudieran ocurrir.
 *
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        String idFichero = "./src/main/java/ejercicio2/teclado.txt";
        String buffer;
        String separador[];
        Scanner scn = new Scanner(System.in);
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            do {
                buffer = scn.nextLine();
                if (!buffer.equals("EOF")){//para que no escriba el EOF
                flujo.write(buffer);
                flujo.newLine();
                }
            } while (!buffer.equals("EOF"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
