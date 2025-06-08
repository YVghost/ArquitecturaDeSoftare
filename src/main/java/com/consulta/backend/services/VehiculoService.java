package com.consulta.backend.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VehiculoService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "vehiculoCache", key = "#placa")
    public String consultarVehiculo(String placa) {
        String url = "https://srienlinea.sri.gob.ec/sri-matriculacion-vehicular-recaudacion-servicio-internet/rest/BaseVehiculo/obtenerPorNumeroPlacaOPorNumeroCampvOPorNumeroCpn?numeroPlacaCampvCpn=" + placa;
        return restTemplate.getForObject(url, String.class);
    }
}
