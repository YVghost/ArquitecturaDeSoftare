package com.consulta.backend.controller;

import com.consulta.service.RucCheckService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contribuyente")
@CrossOrigin(origins = "*")  // Habilita CORS para desarrollo local
public class ContribuyenteController {

    private final RucCheckService rucCheckService;

    public ContribuyenteController(RucCheckService rucCheckService) {
        this.rucCheckService = rucCheckService;
    }

    @GetMapping
    public String getContribuyente(@RequestParam String ruc) {
        return rucCheckService.consultarContribuyente(ruc);
    }
}
