package com.lucas.biblioteca.service;

import com.lucas.biblioteca.model.Emprestimo;
import com.lucas.biblioteca.model.Livro;
import com.lucas.biblioteca.model.Usuario;
import com.lucas.biblioteca.repository.EmprestimoRepository;
import com.lucas.biblioteca.repository.LivroRepository;
import com.lucas.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository,
                             LivroRepository livroRepository,
                             UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Emprestimo> listar() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo realizarEmprestimo(Long usuarioId, Long livroId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (livro.getQuantidade() <= 0) {
            throw new RuntimeException("Livro indisponível");
        }

        livro.setQuantidade(livro.getQuantidade() - 1);
        livroRepository.save(livro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setStatus("EMPRESTADO");

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolverLivro(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        if ("DEVOLVIDO".equals(emprestimo.getStatus())) {
            throw new RuntimeException("Este livro já foi devolvido");
        }

        Livro livro = emprestimo.getLivro();
        livro.setQuantidade(livro.getQuantidade() + 1);
        livroRepository.save(livro);

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setStatus("DEVOLVIDO");

        return emprestimoRepository.save(emprestimo);
    }
}