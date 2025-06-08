package com.consulta.backend.controller;

import com.consulta.service.VehiculoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehiculo")
@CrossOrigin(origins = "*")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public String getVehiculo(@RequestParam String placa) {
        return vehiculoService.consultarVehiculo(placa);
    }
}
