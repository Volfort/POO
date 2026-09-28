import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Enfermero {
    String nombre;
    int cedula;
    String especialidad;
    int noPacientes;
    ArrayList<Paciente> listaPacientes;

    public Enfermero(String nombre, String especialidad, int cedula) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cedula = cedula;
        this.noPacientes = 0;
        this.listaPacientes = new ArrayList<Paciente>();
    }

    public void registroEnSistema(Paciente p){
        if(p != null && this.noPacientes < 3){
            this.listaPacientes.add(p);
            this.noPacientes++;
        }else{
            System.out.println("No se encontro al paciente o la lista está llena");
        }
    }

    public Paciente darTratamiento(){
        if(this.listaPacientes.isEmpty()){
            System.out.println("Ya no hay pacientes");
            return null;
        }else{
            Paciente p = this.listaPacientes.get(0);
            p.estado = 'A';
            System.out.println("Dando tratamiendo a: " + p.nombre);
            p.verTratamiento();
            
            this.listaPacientes.remove(0);
            this.noPacientes--;
            
            return p;
        }
    }   

    public void verListaPacientes(){

        System.out.println("\nLista de pacientes ordenada del enfermero :"+this.nombre);

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
