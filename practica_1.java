import java.util.Scanner;

public class Practica_1{
    public static void main(String[] args) {
       System.out.println("Calculadora");
       Scanner scan = new Scanner(System.in);
       System.out.println("Ingresa el primer número:");
       double num1 = scan.nextDouble();
       System.out.println("Ingresa el segundo número:");
       double num2 = scan.nextDouble();
       double resultado;
       System.out.println("Seleccione la operacion: ");
       System.out.println("1- Suma");
       System.out.println("2- Resta");
       System.out.println("3- Multiplicacion");
       System.out.println("4- Division");
       System.out.println("5- Potencia");
       System.out.println("6- Raíz");
       System.out.println("7- Módulo");
       int opcion = scan.nextInt();

        switch (opcion) {

            case 1:
                System.out.println("Suma: \n");
                resultado = num1 + num2;
                System.out.println("El resultado de la suma es : \n" + resultado);
                break;

            case 2:

                System.out.println("Resta: \n");
                resultado = num1 - num2;
                System.out.println("El resultado de la resta es : \n" + resultado);
                break;

            case 3:

                System.out.println("Multiplicacion: \n");
                resultado = num1 * num2;
                System.out.println("El resultado de la multiplicación es: " + resultado);
                break;

            case 4:

                System.out.println("Division: \n");
                if(num2 == 0){
                    System.out.println("No es posible dividir entre 0");
                } else {
                    resultado = num1 / num2;
                    System.out.println("El resultado de dividir " + num1 + "/" + num2 + " es " + resultado);
                }
                break;

            case 5:

                System.out.println("Potencia: \n");
                resultado = Math.pow(num1, num2);
                System.out.printf("El número %f elevado a la potencia %f es: %f\n", num1, num2, resultado);
                break;

            case 6:

                System.out.println("Raiz: \n");
                if (num2 == 0) {
                    System.out.println("El índice de la raíz no puede ser 0");
                } else if (num1 < 0) {
                    System.out.println("No es posible tener raíces de números negativos");
                } else {
                    resultado = Math.pow(num1, 1.0 / num2);
                    System.out.println("Resultado: " + resultado);
                }
                break;

            case 7:

            System.out.println("Modulo: \n");
            if (num2 == 0) {
                System.out.println("No se puede calcular el módulo con divisor 0");
            } else {
                resultado = num1 % num2;
                System.out.println("El residuo de " + num1 + " % " + num2 + " es: " + resultado);
                }
            break;

            default:
                System.out.println("Se debe elegir un número del 1 al 7");
                break;
        }
            scan.close();
        }
    }