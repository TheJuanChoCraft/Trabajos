import java.io.*;

public class LibreriaJuanSerpa {

    public static void crearArchivoTexto(String nombreArchivo, String contenido) {
        try {
            FileWriter escritor = new FileWriter(nombreArchivo + ".txt");
            escritor.write(contenido);
            escritor.close();
            System.out.println("El archivo " + nombreArchivo + ".txt ha sido creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo: " + e.getMessage());
        }
    }

    public static void copiarArchivo(String origen, String destino) {
        try (InputStream entrada = new FileInputStream(origen);
             OutputStream salida = new FileOutputStream(destino)) {
            
            byte[] buffer = new byte[1024];
            int longitud;
            
            while ((longitud = entrada.read(buffer)) > 0) {
                salida.write(buffer, 0, longitud);
            }
            
            System.out.println("El archivo ha sido copiado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al copiar el archivo: " + e.getMessage());
        }
    }

    public static void moverArchivo(String origen, String destino) {
        File archivoOrigen = new File(origen);
        File archivoDestino = new File(destino);
        
        if (archivoOrigen.exists()) {
            if (archivoOrigen.renameTo(archivoDestino)) {
                System.out.println("El archivo ha sido movido exitosamente.");
            } else {
                System.out.println("No se pudo mover el archivo.");
            }
        } else {
            System.out.println("El archivo de origen no existe.");
        }
    }

    public static void main(String[] args) {
        String nombreArchivo = "ejemplo";
        String contenido = "Este es un archivo de texto de ejemplo.";
        String rutaOrigen = "C:/Users/wwwba/OneDrive/Documentos/NetBeansProjects/LibreriaJuanSerpa/ejemplo.txt"; // Modifica estas rutas con las que desees
        String rutaDestino = "C:/Users/wwwba/OneDrive/Documentos/U/copia/ejemplo.txt";
        
        // Crear archivo
        crearArchivoTexto(nombreArchivo, contenido);
        
        // Copiar archivo
        copiarArchivo(rutaOrigen, rutaDestino);
        
        // Mover archivo
        moverArchivo(rutaOrigen, rutaDestino);
    }
}