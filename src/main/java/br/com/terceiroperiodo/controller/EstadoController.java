package br.com.terceiroperiodo.controller;

import br.com.terceiroperiodo.model.Estado;
import br.com.terceiroperiodo.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estado")

public class EstadoController {

    @Autowired
    EstadoService estadoService;

    @PostMapping()
    public ResponseEntity<Estado> salvarEstado(@RequestBody Estado estado){

        Estado response = estadoService.salvar(estado);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
     public ResponseEntity<Estado>buscarPorId(@PathVariable Long id){

         Optional<Estado> response = estadoService.buscarPorId(id);
         if (response.isPresent()) {
             return ResponseEntity.ok(response.get());
         }
        return ResponseEntity.notFound().build();
    }
}
