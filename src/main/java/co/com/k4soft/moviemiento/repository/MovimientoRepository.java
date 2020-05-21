package co.com.k4soft.moviemiento.repository;


import co.com.k4soft.moviemiento.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Integer> {

    MovimientoEntity findByPlacaAndFinalizado(String placa, boolean b);
}
