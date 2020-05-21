package co.com.k4soft.moviemiento.controller;


import co.com.k4soft.moviemiento.command.VehiculoCommand;
import co.com.k4soft.moviemiento.model.Movimiento;
import co.com.k4soft.moviemiento.model.businessexception.BusinessException;
import co.com.k4soft.moviemiento.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moviento")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/vehiculo")
    public String registrarIngreso(@RequestBody VehiculoCommand vehiculoCommand){
        return movimientoService.registrarSalida(vehiculoCommand);
    }

    @GetMapping("/{placa}/vehiculo")
    public Movimiento registrarSalida(@PathVariable String placa) throws BusinessException {
           return movimientoService.registrarSalida(placa);
    }

}
