package co.com.k4soft.moviemiento.model;


import co.com.k4soft.moviemiento.model.businessexception.BusinessException;
import co.com.k4soft.moviemiento.model.util.Validator;

public class Tarifa {

    public static final String VALOR_PRECIO_REQUERIDO = "El precio no puede ser cero";
    public static final String NOMBRE_TARIFA_NO_PUEDE_SER_VACIO ="El nombre de tarifa no puede ser vacio" ;
    public static final String ID_TARIFA_YA_EXISTE_EN_EL_SISTEMA = "El id de tarifa ya existe en el sistema";
    public static final String ID_TARIFA_DEBE_SER_OBLIGATORIO = "El id de tarifa debe ser obligatorio";

    private Integer id;
    private String nombre;
    private double precio;


    public static class TarifaBuilder {


        private Integer id;
        private String nombre;
        private double precio;



        public TarifaBuilder setId(Integer id) {
            this.id = id;
            return this;
        }



        public TarifaBuilder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }


        public TarifaBuilder setPrecio(double precio) {
            this.precio = precio;
            return this;
        }

        public Tarifa build() throws BusinessException {
            Tarifa tarifa = new Tarifa();
            tarifa.id = id;
            Validator.validarValorCero(precio,VALOR_PRECIO_REQUERIDO);
            tarifa.precio = precio;
            Validator.validarCadenaVacia(nombre,NOMBRE_TARIFA_NO_PUEDE_SER_VACIO);
            tarifa.nombre = nombre;
            Validator.validarObjetoNulo(id,ID_TARIFA_DEBE_SER_OBLIGATORIO);
            Validator.validarValorCero(id,ID_TARIFA_DEBE_SER_OBLIGATORIO);
            tarifa.id = id;
            return tarifa;
        }


    }


    private Tarifa() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }


}
