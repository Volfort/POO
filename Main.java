import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingresa la oración a analizar: ");
        String texto = scanner.nextLine();
        
        AnalizadorPalabras analizador = new AnalizadorPalabras(texto);
        
        analizador.contarPalabras();
        
        int cantidadDuplicadas = analizador.obtenerNumeroDuplicadas();
        
        System.out.println("\nTotal de palabras diferentes que se duplicaron: " + cantidadDuplicadas);
        
        analizador.mostrarDuplicadas();
        
        scanner.close();
    }
}