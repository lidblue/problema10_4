package code.codeprob4;

import java.io.*;

public class CodeProb4 {

    public static void main(String[] args) throws Exception {
        try {
            BufferedReader f;
            f = new BufferedReader(new FileReader("C:\\carta.txt"));
            int contCar = 0; // contador de caracteres
            int contPal = 0; // contador de palabras
            int contLinea = 0; // contador de líneas

            // leemos del flujo asociado usando el método int read()
            int c = f.read(); // leemos un carácter

            while (c != -1) { // mientras no hayamos procesado todo el fichero
                if ((char) c == ' ') { // suponemos solo un espacio entre palabras
                    System.out.printf("Se ha encontrado el caracter: %c \n", (char) c);
                    contCar++; //un carácter más
                    contPal++; //una palabra más
                } else {
                    if ((char) c == '\n') { // encontramos una línea
                        contPal++; // una palabra más
                        contLinea++; // una línea más
                    } else {
                        contCar++; // es otro caracter
                        System.out.printf("Se ha encontrado el caracter: %c \n", (char) c);
                    }
                }
                c = f.read(); // volvemos a leer
            }
            f.close(); // cerramos el fichero, ha sido procesado entero

            if (contPal > 0) {
                contPal++;
            }

            if (contLinea > 0) { // la última línea no se ha contabilizado
                contLinea++;
            }
            System.out.println("La información del archivo de texto es la siguiente");
            System.out.println("Caracteres: " + (contCar - 1)); // contamos un caracter más
            System.out.println("Palabras: " + contPal);
            System.out.println("Lineas: " + contLinea);
        } catch (EOFException eof) {
            System.out.println("Error");
        }
    }
}
