import java.util.Scanner;

public class Palindromo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;

        System.out.print("Programa para determinar si un número de 5 digitos es un palidromo o no.\n");
        System.out.print("Favor de ingresar un número entero positivo de 5 dígitos: ");
        num = scanner.nextInt();

        while (num < 10000 || num > 99999) {
            System.out.println("Error: el número debe tener 5 dígitos.");
            System.out.print("Ingresa el nuevo número: ");
            num = scanner.nextInt();
        }

        if (esPalindromo(num)) {
            System.out.println(num + " es un palíndromo.");
        } else {
            System.out.println(num + " no es un palíndromo.");
        }
        
        scanner.close();
    }

    public static boolean esPalindromo(int num) {
        if (num / 10000 == num % 10 && (num / 1000) % 10 == (num / 10) % 10) {
            return true;
        } else {
            return false;
        }
    }
}
}