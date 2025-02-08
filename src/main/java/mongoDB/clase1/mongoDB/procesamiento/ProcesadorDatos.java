package mongoDB.clase1.mongoDB.procesamiento;

import java.util.List;

public class ProcesadorDatos implements IProcesadorDatos {
    @Override
    public double calcularPromedioNotas(List<Double> notas) {
        return notas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }
}