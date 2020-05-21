package co.com.k4soft.moviemiento.model.businessexception;

public class VehiculoNoExisteException extends RuntimeException{
    public VehiculoNoExisteException(String mensaje){
        super(mensaje);
    }
}
