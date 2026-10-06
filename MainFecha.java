import java.util.Scanner;

public class MainFecha {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la fecha inicial");
        System.out.print("Mes: ");
        int mes = entrada.nextInt();
        System.out.print("Día: ");
        int dia = entrada.nextInt();
        System.out.print("Año: ");
        int año = entrada.nextInt();

        Fecha f1 = new Fecha(mes, dia, año);

        System.out.println();
        System.out.print("Fecha registrada: ");
        f1.mostrarFecha();

        System.out.println("\nIngrese los nuevos valores de la fecha");
        System.out.print("Nuevo mes: ");
        int nuevoMes = entrada.nextInt();
        f1.setMes(nuevoMes);

        System.out.print("Nuevo día: ");
        int nuevoDia = entrada.nextInt();
        f1.setDia(nuevoDia);

        System.out.print("Nuevo año: ");
        int nuevoAño = entrada.nextInt();
        f1.setAño(nuevoAño);

        System.out.println();
        System.out.print("Fecha actualizada: ");
        f1.mostrarFecha();

        entrada.close();
    }
}