package co.com.k4soft.moviemiento.service.impl;


import co.com.k4soft.moviemiento.command.VehiculoCommand;
import co.com.k4soft.moviemiento.dto.TarifaDTO;
import co.com.k4soft.moviemiento.entity.MovimientoEntity;
import co.com.k4soft.moviemiento.fabrica.MovimientoFabrica;
import co.com.k4soft.moviemiento.model.Movimiento;
import co.com.k4soft.moviemiento.model.businessexception.BusinessException;
import co.com.k4soft.moviemiento.model.businessexception.TarifaNoExisteException;
import co.com.k4soft.moviemiento.model.businessexception.VehiculoNoExisteException;
import co.com.k4soft.moviemiento.model.businessexception.VehiculoRegistradoException;
import co.com.k4soft.moviemiento.repository.MovimientoRepository;
import co.com.k4soft.moviemiento.restclient.TarifaRestClient;
import co.com.k4soft.moviemiento.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private static final String TARIFA_NO_EXISTE ="la tarifa no existe";
    private static final String VEHICULO_REGISTRADO ="El vehìculo ya se encuentra registrado";
    private static final String VEHICULO_INGRESADO_EXITODAMENTE ="El vehiculo se ha registrado exitodamente";
    private static final String VEHICULO_NO_SE_ENCUENTRA_REGISTRADO ="El vehìculo no se encuentra registrado";

    @Autowired
    private TarifaRestClient tarifaService;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private MovimientoFabrica movimientoFabrica;

    @Override
    public String registrarSalida(VehiculoCommand vehiculoCommand) {
        validarTarifa(vehiculoCommand.getIdTarifa());
        validarVehiculoRegistrado(vehiculoCommand.getPlaca());
        MovimientoEntity movimientoEntity = new MovimientoEntity();
        movimientoEntity.setPlaca(vehiculoCommand.getPlaca());
        movimientoEntity.setIdTarifa(vehiculoCommand.getIdTarifa());
        movimientoEntity.setFinalizado(false);
        movimientoEntity.setFechaIngreso(new Date());
        movimientoRepository.save(movimientoEntity);


        return VEHICULO_INGRESADO_EXITODAMENTE;
    }

    @Override
    public Movimiento registrarSalida(String placa) throws BusinessException {
        MovimientoEntity movimientoEntity = movimientoRepository.findByPlacaAndFinalizado(placa, false);
        validarVehiculoNoExiste(movimientoEntity);
        movimientoEntity.setFechaSalida(new Date());
        movimientoEntity.setFinalizado(true);
        movimientoRepository.save(movimientoEntity);
        TarifaDTO tarifaDTO = tarifaService.findById(movimientoEntity.getIdTarifa());
        return movimientoFabrica.entityToModel(movimientoEntity,tarifaDTO);
    }

    private void validarVehiculoNoExiste(MovimientoEntity movimientoEntity) {
        if(movimientoEntity == null){
            throw new VehiculoNoExisteException(VEHICULO_NO_SE_ENCUENTRA_REGISTRADO);
        }
    }

    private void validarVehiculoRegistrado(String placa) {
        if(movimientoRepository.findByPlacaAndFinalizado(placa, false) != null){
            throw new VehiculoRegistradoException(VEHICULO_REGISTRADO);
        }
    }

    private void validarTarifa(int idTarifa) {
        if(tarifaService.findById(idTarifa) == null){
            throw new TarifaNoExisteException(TARIFA_NO_EXISTE);
        }

    }
}
