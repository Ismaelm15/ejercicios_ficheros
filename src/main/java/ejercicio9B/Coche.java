/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9B;


/**
 *
 * @author ismael
 */
public class Coche extends Vehiculo {

    public Coche() {
        String matricula="";
        this.setTipo(0);
        generarAleatorio();
        for (int i = 0; i < 3; i++) {
            char letra = (char) (rnd.nextInt(26) + 'A');

            matricula = matricula + letra;
        }

        this.setMatricula(Integer.toString(rnd.nextInt(500000)) + matricula);

    }

    public Coche(String matricula, String marca, String modelo, String color, double tarifa, boolean disponible) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.setTipo(0);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void generarAleatorio() {
        seed = rnd.nextInt(4);
        if (seed == 0) {

            this.setMarca("Ferrari");
            this.setModelo("Kangoo");
            this.setColor("Rojo");
            this.setTarifa(50);
            this.setDisponible(true);
        }
        if (seed == 1) {

            this.setMarca("Ford");
            this.setModelo("Tango");
            this.setColor("Azul");
            this.setTarifa(70);
            this.setDisponible(false);
        }
        if (seed == 2) {

            this.setMarca("Tesla");
            this.setModelo("XF1");
            this.setColor("Gris");
            this.setTarifa(100);
            this.setDisponible(true);
        }
        if (seed == 3) {

            this.setMarca("Kia");
            this.setModelo("Karens");
            this.setColor("Blanco");
            this.setTarifa(56.6);
            this.setDisponible(true);
        }
    }
}
