package co.com.k4soft.moviemiento.restclient;

import co.com.k4soft.moviemiento.dto.TarifaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="servicio.tarifas", url="localhost:8081/tipo-tarifa")
public interface TarifaRestClient {

    @GetMapping("/v1/{id}/tarifa")
    TarifaDTO findById(@PathVariable Integer id);


}
