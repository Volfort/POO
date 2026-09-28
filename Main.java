import java.util.Scanner; 

public class Main { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        Sistema hospital = new Sistema();
        hospital.nombreHospital = "Hospital La Raza";

        System.out.println("Registro de médicos: ");
        System.out.print("¿Cuántos médicos vas a registrar?: ");
        int numMedicos = Integer.parseInt(sc.nextLine()); 

        for (int i = 0; i < numMedicos; i++) {
            System.out.println("\nDatos del Médico " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();
            System.out.print("Cédula: ");
            int cedula = Integer.parseInt(sc.nextLine());

            Medico m = new Medico(nombre, especialidad, cedula);
            hospital.registroMedico(m);
        }

        System.out.println("\nRegistro de enfermeros: ");
        System.out.print("¿Cuántos enfermeros vas a registrar? ");
        int numEnfermeros = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numEnfermeros; i++) {
            System.out.println("\nDatos del Enfermero " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();
            System.out.print("Cédula: ");
            int cedula = Integer.parseInt(sc.nextLine());

            Enfermero e = new Enfermero(nombre, especialidad, cedula);
            hospital.registroEnfermero(e);
        }

        System.out.println("\nRegistro de pacientes: ");
        System.out.print("¿Cuántos pacientes vas a registrar? ");
        int numPacientes = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numPacientes; i++) {
            System.out.println("\nDatos del Paciente " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = sc.nextLine();
            System.out.print("Especialidad que requiere: ");
            String especialidad = sc.nextLine();

            Paciente p = new Paciente(nombre, apellidos, especialidad);
            p.registroEnSistema();
            p.solicitarConsulta();
            hospital.registroPaciente(p);
        }
        sc.close();

        System.out.println(("\n-----------------------------"));
        System.out.println("Hospital: "+ hospital.nombreHospital);

        System.out.println("\nAsignación a médicos: ");
        for (int i = 0; i < hospital.listaMedicos.size(); i++) { 
            Medico m = hospital.listaMedicos.get(i);
            int pacientesEnEspera = hospital.listaPacientes.size();
            int pacientesAsignados = 0;

            for (int j = 0; j < pacientesEnEspera; j++) {
                int antes = hospital.listaPacientes.size();
                hospital.asignarPaciente(m); 
                
                if (antes > hospital.listaPacientes.size()) {
                    pacientesAsignados++;
                }

                if (antes == hospital.listaPacientes.size()) {
                    break; 
                }
            } 
                if (pacientesAsignados == 0) {
                    System.out.println("No hay pacientes en espera o está lleno para el médico: " + m.nombre);
                }
        }

        System.out.println("\nAsignación médica: ");
        for (int i = 0; i < hospital.listaMedicos.size(); i++) {
            Medico m = hospital.listaMedicos.get(i);
            
            m.verListaPacientes();
            
            while (m.listaPacientes.size() > 0) { 
                Paciente pacienteAtendido = m.solicitarPaciente(); 
                pacienteAtendido.verTratamiento(); 
                Paciente pacienteTratado = m.darTratamiento(); 
                hospital.registroPaciente(pacienteTratado); 
            }
        }
        System.out.println("\nAsignación a enfermeros:");
        for (int i = 0; i < hospital.listaEnfermeros.size(); i++) {
            Enfermero e = hospital.listaEnfermeros.get(i);
            int pacientesEnEspera = hospital.listaPacientes.size();
            int pacientesAsignados = 0;

            for (int j = 0; j < pacientesEnEspera; j++) {
                int antes = hospital.listaPacientes.size();
                hospital.asignarPaciente(e); 

                if (antes > hospital.listaPacientes.size()) {
                pacientesAsignados++;
                }

                if (antes == hospital.listaPacientes.size()) { 
                    break;
                }
                }
        
            if (pacientesAsignados == 0) {
            System.out.println("No hay pacientes en espera o está lleno para el enfermero: " + e.nombre);
            }
            
        }

        System.out.println("\nTratamiento de enfermeros: ");
        for (int i = 0; i < hospital.listaEnfermeros.size(); i++) {
            Enfermero e = hospital.listaEnfermeros.get(i);
            
            e.verListaPacientes();
            
            while (e.listaPacientes.size() > 0) {
                Paciente pacienteCurado = e.darTratamiento(); 
                hospital.agregarPacienteCurado(pacienteCurado);
            }
        }
        
        System.out.println("\nTotal de pacientes curados archivados: " + hospital.listaCurados.size());
    }
    
}