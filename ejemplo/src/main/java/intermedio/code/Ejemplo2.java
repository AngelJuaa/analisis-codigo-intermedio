package intermedio.code;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo2 {
    

    public static void main(String[] args) {

        // Simulación de código intermedio (Tres Direcciones)
        List<String> codigoIntermedio = new ArrayList<>();

        codigoIntermedio.add("a = 5");
        codigoIntermedio.add("b = a + 3");
        codigoIntermedio.add("c = 2 * 4");
        codigoIntermedio.add("d = 10");
        codigoIntermedio.add("d = 20"); // Código muerto

        System.out.println("=== Código Intermedio Original ===");
        codigoIntermedio.forEach(System.out::println);

        List<String> codigoOptimizado = optimizar(codigoIntermedio);

        System.out.println("\n=== Código Intermedio Optimizado ===");
        codigoOptimizado.forEach(System.out::println);
    }

    public static List<String> optimizar(List<String> codigo) {

        List<String> optimizado = new ArrayList<>();

        for (String linea : codigo) {

            // 🔹 Propagación y Plegado de Constantes
            if (linea.equals("b = a + 3")) {
                optimizado.add("b = 8"); // a = 5 → 5 + 3 = 8
            }
            else if (linea.equals("c = 2 * 4")) {
                optimizado.add("c = 8"); // 2 * 4 resuelto en compilación
            }

            // 🔹 Eliminación de Código Muerto
            else if (linea.equals("d = 10")) {
                // Se omite porque luego se reasigna d = 20
                continue;
            }
            else {
                optimizado.add(linea);
            }
        }

        return optimizado;
    }
}
