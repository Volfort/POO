
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sistema {
    String nombreHospital;
    
    int noMedicos;
    int noEnfermeros;
    int noPacientes;

    ArrayList<Medico> listaMedicos;
    ArrayList<Enfermero> listaEnfermeros;
    ArrayList<Paciente> listaPacientes;
    ArrayList<Paciente> listaCurados;

    public Sistema() {
        this.noMedicos = 0;
        this.noEnfermeros = 0;
        this.noPacientes = 0;
        this.listaMedicos = new ArrayList<Medico>();
        this.listaEnfermeros = new ArrayList<Enfermero>();
        this.listaPacientes = new ArrayList<Paciente>();
        this.listaCurados = new ArrayList<Paciente>();
    }

    public void registroMedico(Medico m){
        if(m != null){
            this.listaMedicos.add(m);
            this.noMedicos++;
        }else{
            System.out.println("No se pudo registrar al medico");
        }
    }

    public void registroEnfermero(Enfermero e){
        if(e != null){
            this.listaEnfermeros.add(e);
            this.noEnfermeros++;
        }else{
            System.out.println("No se pudo registrar al enfermero");
        }
    }

    public void registroPaciente(Paciente p){
        if(p != null){
            this.listaPacientes.add(p);
            this.noPacientes++;
        }else{
            System.out.println("No se pudo registrar al paciente");
        }
    }

    public void asignarPaciente(Medico m) {
        if (m == null){
            return;
        }

        for (int i = 0; i < this.listaPacientes.size(); i++) {
            Paciente p = this.listaPacientes.get(i);
            
            Map<String, Integer> mapaAux = new HashMap<String, Integer>();
            mapaAux.put(p.especialidadAtencion.toLowerCase(), 1);

            if (mapaAux.containsKey(m.especialidad.toLowerCase()) && m.noPacientes < 10 && p.estado == 'E') {
                m.registroEnSistema(p); 
                System.out.println("Paciente " + p.nombre + " asignado al médico " + m.nombre);
                this.listaPacientes.remove(i); 
                this.noPacientes--;
                return; 
            }
        }
    }   

    public void asignarPaciente(Enfermero e) {
        if (e == null){
            return;
        }
        
        for (int i = 0; i < this.listaPacientes.size(); i++) {
            Paciente p = this.listaPacientes.get(i);
            
            Map<String, Integer> mapaAux = new HashMap<String, Integer>();
            mapaAux.put(p.especialidadAtencion.toLowerCase(), 1);

            if (mapaAux.containsKey(e.especialidad.toLowerCase()) && e.noPacientes < 3 && p.estado == 'T') {
                e.registroEnSistema(p);
                System.out.println("Paciente " + p.nombre + " asignado al enfermero " + e.nombre);
                this.listaPacientes.remove(i);
                this.noPacientes--;
                return; 
            }
        }
    }

    public void agregarPacienteCurado(Paciente p) {
        if (p != null) {
            this.listaCurados.add(p);
            System.out.println("Paciente " + p.nombre + " ahora está curado");
        } else {
            System.out.println("No se pudo archivar al paciente");
        }
    }
}