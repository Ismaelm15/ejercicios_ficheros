/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author ismael
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        String idFichero = "./src/main/java/ejercicio3/50lineas.txt";
        int tmp = 0, mayusminus;
        char buffer;

        Random rnd = new Random();
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            do {
                mayusminus = rnd.nextInt(2);
                if (mayusminus == 0) {
                    buffer = (char)(rnd.nextInt(26) + 'A');
                } else {
                    buffer=(char)(rnd.nextInt(26) + 'a');
                }
                flujo.write(buffer);
                if (buffer == 'x' || buffer == 'X') {
                    flujo.newLine();
                    tmp++;
                }
            } while (tmp < 51);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
