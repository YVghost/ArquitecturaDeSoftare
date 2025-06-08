package com.consulta.backend.controller;

import com.consulta.service.LicenciaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/licencia")
@CrossOrigin(origins = "*")
public class LicenciaController {

    private final LicenciaService licenciaService;

    public LicenciaController(LicenciaService licenciaService) {
        this.licenciaService = licenciaService;
    }

    @GetMapping
    public String getLicencia(@RequestParam String cedula, @RequestParam String placa) {
        return licenciaService.consultarLicencia(cedula, placa);
    }
}
