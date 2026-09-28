import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Medico {
    String nombre;
    String especialidad;
    int cedula;
    int noPacientes;
    ArrayList<Paciente> listaPacientes;

    public Medico(String nombre, String especialidad, int cedula) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cedula = cedula;
        this.noPacientes = 0;
        this.listaPacientes = new ArrayList<Paciente>(); 
    }

    public void registroEnSistema(Paciente p){
        if(p != null && this.noPacientes < 10){
            this.listaPacientes.add(p);
            this.noPacientes++;
        }else{
            System.out.println("No se encontro al paciente o la lista está llena");
        }
    }

    public Paciente solicitarPaciente(){
        if(this.listaPacientes.isEmpty()){
            System.out.println("Ya no hay pacientes");
            return null;
        }
        
        Paciente pacienteTurno = this.listaPacientes.get(0);

        if (pacienteTurno.estado == 'C') {
            System.out.println("El médico " + this.nombre + " ya está ocupado con " + pacienteTurno.nombre);
            return null;
        }else{
            darConsulta(pacienteTurno);
            
            return pacienteTurno;
        }
    }

    public void darConsulta(Paciente p){
        if(p != null){
            p.estado = 'C';
        }else{
            System.out.println("No se encontro al paciente");
        }
    }

    public Paciente darTratamiento(){
        if(this.listaPacientes.isEmpty()){
            System.out.println("Ya no hay pacientes");
            return null;
        } 
        
        Paciente p = this.listaPacientes.get(0); 
        
        if (p.estado != 'C') {
            System.out.println("El paciente no está en consulta.");
            return null;
        }

        p.estado = 'T';
        System.out.println("El médico indicó tratamiento a: " + p.nombre);
        
        this.listaPacientes.remove(0); 
        this.noPacientes--; 
        
        return p;
    }

    public void verListaPacientes() {
        System.out.println("\nLista de pacientes ordenada del médico :"+this.nombre);

        if (this.listaPacientes.isEmpty()) {
        System.out.println("No hay pacientes que mostrar");
        return; 
        }

        Map<String, Integer> mapa = new HashMap<>();

        for (int i = 0; i < this.listaPacientes.size(); i++) {
            Paciente p = this.listaPacientes.get(i);
            
            String infoPaciente = p.apellidos + " " + p.nombre + " - Especialidad: " + p.especialidadAtencion + " (" + i + ")";
            
            mapa.put(infoPaciente, 1); 
        }

        Set<String> llaves = mapa.keySet();
        TreeSet<String> llavesOrd = new TreeSet<>(llaves); 

        ArrayList<String> listaAscendente = new ArrayList<>();
        for (String llave : llavesOrd) {
            listaAscendente.add(llave);
        }
        
        for (int i = listaAscendente.size() - 1; i >= 0; i--) {
            System.out.println(listaAscendente.get(i));
        }
    }
}
