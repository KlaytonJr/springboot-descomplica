package com.example.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.Estudante;
import com.example.api.service.EstudanteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/estudantes")
@AllArgsConstructor
public class EstudanteController {

    private EstudanteService estudanteService;

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id) {
        return estudanteService.buscarEstudantePorId(id);
    }

    @GetMapping
    public List<Estudante> buscarTodosEstudantes() {
        return estudanteService.buscarTodosEstudantes();
    }

    @PostMapping
    public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante) {
        return estudanteService.cadastrarEstudante(estudante);
    }

    @PutMapping
    public ResponseEntity<Estudante> atualizarEstudante(@RequestBody Estudante estudante) {
        return estudanteService.atualizarEstudante(estudante);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> removerEstudante(@PathVariable Long id) {
        return estudanteService.removerEstudante(id);
    }

}
