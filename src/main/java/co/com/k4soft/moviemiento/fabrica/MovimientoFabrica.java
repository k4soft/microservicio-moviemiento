package co.com.k4soft.moviemiento.fabrica;



import co.com.k4soft.moviemiento.dto.TarifaDTO;
import co.com.k4soft.moviemiento.entity.MovimientoEntity;
import co.com.k4soft.moviemiento.model.Movimiento;
import co.com.k4soft.moviemiento.model.Tarifa;
import co.com.k4soft.moviemiento.model.businessexception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class MovimientoFabrica {

    public Movimiento entityToModel(MovimientoEntity movimientoEntity, TarifaDTO tarifaDTO) throws BusinessException {
        Tarifa tarifa = new Tarifa.TarifaBuilder()
                .setId(tarifaDTO.getId()).setNombre(tarifaDTO.getNombre()).setPrecio(tarifaDTO.getPrecio()).build();
        Movimiento movimiento = new Movimiento.MovimientoBuilder()
                .setIdMoviento(movimientoEntity.getIdMovimiento())
                .setFechaIngreso(movimientoEntity.getFechaIngreso())
                .setFechaSalida(movimientoEntity.getFechaSalida())
                .setPlaca(movimientoEntity.getPlaca())
                .setTarifa(tarifa)
                .build();
        return movimiento;



    }


}
