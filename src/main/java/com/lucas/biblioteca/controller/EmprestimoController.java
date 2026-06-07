package com.lucas.biblioteca.controller;

import com.lucas.biblioteca.dto.EmprestimoRequest;
import com.lucas.biblioteca.model.Emprestimo;
import com.lucas.biblioteca.service.EmprestimoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Emprestimo> listar() {
        return service.listar();
    }

    @PostMapping
    public Emprestimo emprestar(@RequestBody EmprestimoRequest request) {
        return service.realizarEmprestimo(
                request.getUsuarioId(),
                request.getLivroId()
        );
    }

    @PutMapping("/{id}/devolver")
    public Emprestimo devolver(@PathVariable Long id) {
        return service.devolverLivro(id);
    }
}