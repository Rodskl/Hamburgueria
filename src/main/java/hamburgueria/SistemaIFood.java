package hamburgueria;

public class SistemaIFood {
    
    public String despacharMotoqueiro(String coordenadas, String token) {
        if (coordenadas == null || token == null) {
            return "Erro de integracao";
        }
        if (coordenadas.trim().isEmpty() || token.trim().isEmpty()) {
            return "Dados incompletos";
        }
        return "Motoqueiro a caminho de " + coordenadas + " [Token: " + token + "]";
    }
}