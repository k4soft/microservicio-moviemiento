package co.com.k4soft.moviemiento.model.businessexception;

public class TarifaNoExisteException extends RuntimeException {
    public TarifaNoExisteException(String mensaje) {
        super(mensaje);
    }
}
