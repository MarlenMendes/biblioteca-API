package com.catalisa.biblioteca.service;

import com.catalisa.biblioteca.model.LivroModel;
import com.catalisa.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public List<LivroModel> buscarTodos(){
        return livroRepository.findAll();
    }

    public Optional<LivroModel> buscarPorId(Long id){
        return livroRepository.findById(id);
    }

    public LivroModel cadastrar(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public LivroModel alterar(Long id, LivroModel livroModel) {
        LivroModel livro = buscarPorId(id).get();

        if (livroModel.getAutor() != null){
            livro.setAutor(livroModel.getAutor());
        }
        if (livroModel.getNome() != null){
            livro.setNome(livroModel.getNome());
        }
        if (livroModel.getDataLancamento() != null){
            livro.setDataLancamento(livroModel.getDataLancamento());
        }
        if (livro.getCodigo() != null){
            livro.setCodigo(livroModel.getCodigo());
        }

        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
