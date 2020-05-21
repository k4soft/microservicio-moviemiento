package co.com.k4soft.moviemiento.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table( name = "movimiento")
@NoArgsConstructor
public class MovimientoEntity {

    @Id
    @GeneratedValue
    @Column(name="idMovimiento")
    private Integer idMovimiento;
    @Column(name="placa")
    private String placa;
    @Column(name="idTarifa")
    private Integer idTarifa;
    @Column(name="finalizado")
    private boolean finalizado;
    @Column(name="fechaIngreso")
    private Date fechaIngreso;
    @Column(name="fechaSalida")
    private Date fechaSalida;

}
