import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarArchivoNotasMedias {
    public static void main(String[] args) {
        // Ruta para los archivos, actualizar si es necesario
        String archivoEntrada = "C:\\Users\\Jorge\\OneDrive\\Escritorio\\CICLO\\AD\\Archivos\\alumnosNotas.txt";
        String archivoSalida = "C:\\Users\\Jorge\\OneDrive\\Escritorio\\CICLO\\AD\\Archivos\\alumnosMedias.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length >= 2) {
                    String nombreAlumno = partes[0];
                    double notaMedia = calcularNotaMedia(partes);

                    bw.write(nombreAlumno + ":" + notaMedia + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calcularNotaMedia(String[] notas) {
        double suma = 0.0;
        for (int i = 1; i < notas.length; i++) {
            suma += Double.parseDouble(notas[i]);
        }
        return suma / (notas.length - 1);
    }
}


