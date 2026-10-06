import java.util.Scanner;

public class MainEmpleado {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Datos del primer empleado");
        System.out.print("Nombre: ");
        String nombre1 = entrada.nextLine();
        System.out.print("Apellido: ");
        String apellido1 = entrada.nextLine();
        System.out.print("Salario mensual: ");
        double salario1 = Double.parseDouble(entrada.nextLine());

        Empleado e1 = new Empleado(nombre1, apellido1, salario1);

        System.out.println("\nDatos del segundo empleado");
        System.out.print("Nombre: ");
        String nombre2 = entrada.nextLine();
        System.out.print("Apellido: ");
        String apellido2 = entrada.nextLine();
        System.out.print("Salario mensual: ");
        double salario2 = Double.parseDouble(entrada.nextLine());

        Empleado e2 = new Empleado(nombre2, apellido2, salario2);

        System.out.println("Salario anual de " + e1.getNombre() + " " + e1.getApellido() + ": $" + e1.getSalarioAnual());
        System.out.println("Salario anual de " + e2.getNombre() + " " + e2.getApellido() + ": $" + e2.getSalarioAnual());

        e1.setSalarioMensual(e1.getSalarioMensual() * 1.10);
        e2.setSalarioMensual(e2.getSalarioMensual() * 1.10);

        System.out.println("\n Con aumento del 10%: ");
        System.out.println("Nuevo salario anual de " + e1.getNombre() + " " + e1.getApellido() + ": $" + e1.getSalarioAnual());
        System.out.println("Nuevo salario anual de " + e2.getNombre() + " " + e2.getApellido() + ": $" + e2.getSalarioAnual());

        entrada.close();
    }
}