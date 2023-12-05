import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarArchivoNotasMedias {
    public static void main(String[] args) {
        //Ruta para los archivos, actualizar si es necesario
        String archivoEntrada = "C:\\Users\\Jorge\\OneDrive\\Escritorio\\CICLO\\AD\\Archivos\\alumnosNotas.txt";
        String archivoSalida = "C:\\Users\\Jorge\\OneDrive\\Escritorio\\CICLO\\AD\\Archivos\\alumnosMedias.txt";
        //Abro los archivos con BufferedReader y BufferedWriter para leer y escribir en el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {
            String linea;
            //Un bucle while para leer el archivo linea por linea
            while ((linea = br.readLine()) != null) {
                //Divido cada linea
                String[] partes = linea.split(":");
                //Verifico si la linea contiene al menos dos partes
                if (partes.length >= 2) {
                    //Obtengo el nombre del alumno de la primera parte
                    String nombreAlumno = partes[0];
                    //Llamo a calcularNotaMedia
                    double notaMedia = calcularNotaMedia(partes);

                    bw.write(nombreAlumno + ":" + notaMedia + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Un método auxiliar para calcular la media
    private static double calcularNotaMedia(String[] notas) {
        double suma = 0.0;
        for (int i = 1; i < notas.length; i++) {
            //Convierto cada nota a double y la suma
            suma += Double.parseDouble(notas[i]);
        }
        return suma / (notas.length - 1);
    }
}
