package co.com.k4soft.moviemiento.model.util;



import co.com.k4soft.moviemiento.model.businessexception.BusinessException;

import java.util.Date;

public class Validator {

    public static void validarFechaNula(Date fecha, String mensaje) throws BusinessException {
        if(fecha == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarPlacaNula(String placa, String mensaje) throws BusinessException {
        if(placa == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarPlacaVacia(String placa, String mensaje) throws BusinessException {
        if("".equals(placa)){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarObjetoNulo(Object object, String mensaje) throws BusinessException {
        if(object == null){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarValorCero(double valor, String mensaje) throws BusinessException {
        if(valor == 0){
            throw new BusinessException(mensaje);
        }
    }

    public static void validarCadenaVacia(String cadena, String mensaje) throws BusinessException {
        if(cadena == null || "".equals(cadena)){
            throw new BusinessException(mensaje);
        }
    }
}
