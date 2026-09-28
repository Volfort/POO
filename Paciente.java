
public class Paciente {
    String nombre;
    String apellidos; 
    String especialidadAtencion;
    char estado;

    public Paciente(String nombre, String apellidos, String especialidadAtencion){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidadAtencion = especialidadAtencion;
        this.estado = 'E';
    }

    public void verTratamiento(){
        String descripcion = "";
        
        if (this.estado == 'E') {
            descripcion = "En espera";
        } else if (this.estado == 'R') {
            descripcion = "Registrado";
        } else if (this.estado == 'C') {
            descripcion = "En consulta";
        } else if (this.estado == 'T') {
            descripcion = "En tratamiento";
        } else if (this.estado == 'A') {
            descripcion = "Curado";
        }
        System.out.println("El nombre del paciente es: " + this.nombre + " " + this.apellidos + " y su tratamiento actual es: " + descripcion);
    }

    public void registroEnSistema(){
        this.estado = 'R';
        System.out.println("paciente registrado");
    }

    public void solicitarConsulta(){
        this.estado = 'E';
    }
}