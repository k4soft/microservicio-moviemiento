package co.com.k4soft.moviemiento.service;

import co.com.k4soft.moviemiento.command.VehiculoCommand;
import co.com.k4soft.moviemiento.model.Movimiento;
import co.com.k4soft.moviemiento.model.businessexception.BusinessException;

public interface MovimientoService {

    String registrarSalida(VehiculoCommand vehiculoCommand);

    Movimiento registrarSalida(String placa) throws BusinessException;
}
