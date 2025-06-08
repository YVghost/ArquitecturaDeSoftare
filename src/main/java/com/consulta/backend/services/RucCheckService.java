package com.consulta.backend.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RucCheckService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "contribuyenteCache", key = "#ruc")
    public String consultarContribuyente(String ruc) {
        String url = "https://srienlinea.sri.gob.ec/sri-catastro-sujeto-servicio-internet/rest/ConsolidadoContribuyente/obtenerPorNumerosRuc?ruc=" + ruc;
        return restTemplate.getForObject(url, String.class);
    }
}
