package com.consulta.backend.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LicenciaService {

    @Cacheable(value = "licenciaCache", key = "#cedula")
    public String consultarLicencia(String cedula, String placa) {
        try {
            String url = "https://consultaweb.ant.gob.ec/PortalWEB/paginas/clientes/clp_grid_citaciones.jsp?ps_tipo_identificacion=CED&ps_identificacion="
                    + cedula + "&ps_placa=" + placa;

            // Jsoup se usa para parsear HTML (ya que la ANT no devuelve JSON)
            Document doc = Jsoup.connect(url)
                    .timeout(10000)
                    .get();

            // Podrías parsear elementos concretos, pero por ahora retornamos el HTML como string
            return doc.outerHtml();

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"No se pudo consultar la información de la licencia\"}";
        }
    }
}
