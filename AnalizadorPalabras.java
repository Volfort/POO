import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AnalizadorPalabras {
    
    public String oracion;
    public Map<String, Integer> frecuencias;

    public AnalizadorPalabras(String nuevaOracion) {
        this.oracion = nuevaOracion;
        this.frecuencias = new HashMap<>(); 
    }

    public void contarPalabras() {
        if (this.oracion == null || this.oracion.trim().isEmpty()) {
            return;
        }

        String limpio = this.oracion.toLowerCase();
        limpio = limpio.replaceAll("[^a-záéíóúüñ0-9\\s]", "");
        
        String[] tokens = limpio.split("\\s+");

        for (String palabra : tokens) {
            if (!palabra.isEmpty()) {
                if (this.frecuencias.containsKey(palabra)) {
                    int contador = this.frecuencias.get(palabra);
                    this.frecuencias.put(palabra, contador + 1);
                } else {
                    this.frecuencias.put(palabra, 1);
                }
            }
        }
    }

    public int obtenerNumeroDuplicadas() {
        int duplicados = 0;
        for (String llave : this.frecuencias.keySet()) {
            if (this.frecuencias.get(llave) > 1) {
                duplicados++;
            }
        }
        return duplicados;
    }

    public void mostrarDuplicadas() {
        Collection<String> claves = new TreeSet<>();

        for (String palabra : this.frecuencias.keySet()) {
            if (this.frecuencias.get(palabra) > 1) {
                claves.add(palabra);
            }
        }

        if (claves.isEmpty()) {
            System.out.println("No hay palabras duplicadas.");
        } else {
            System.out.println("Palabras duplicadas:");
            for (String palabra : claves) {
                System.out.println(palabra + ": " + this.frecuencias.get(palabra));
            }
        }
    }
}