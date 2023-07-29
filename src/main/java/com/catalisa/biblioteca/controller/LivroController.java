package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.LivroModel;
import com.catalisa.biblioteca.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Biblioteca API")
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping(path = "/livros")
    @Operation(summary = "Busca todos os livros", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"))
    public List<LivroModel> buscaTodosLivros(){
        return livroService.buscarTodos();
    }

    @GetMapping(path = "/livros/{id}")
    @Operation(summary = "Busca livro específico", method = "GET")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Busca criado com sucesso"))
    public Optional<LivroModel> buscaLivroPorId(@PathVariable Long id){
        return livroService.buscarPorId(id);
    }

    @PostMapping(path = "/livros")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria um novo livro", method = "POST")
    @ApiResponses(value = @ApiResponse(responseCode = "201", description = "Livro criado com sucesso"))
    public LivroModel cadastrarNovoLivro(@RequestBody LivroModel livroModel){
        return livroService.cadastrar(livroModel);
    }

    @PutMapping(path = "/livros/{id}")
    @Operation(summary = "Atualiza um livro", method = "PUT")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso"))
    public LivroModel alterarLivro(@PathVariable Long id, @RequestBody LivroModel livroModel){
        return livroService.alterar(id, livroModel);
    }

    @DeleteMapping(path = "/livros/{id}")
    @Operation(summary = "Deleta um livro ", method = "DELETE")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Livro deletado com sucesso"))
    public void deletarLivro(@PathVariable Long id){
        livroService.deletar(id);
    }


}
