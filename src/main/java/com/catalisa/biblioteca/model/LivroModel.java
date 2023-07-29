package com.catalisa.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_LIVROS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String autor;

    @Column(length = 10, nullable = false)
    private String dataLancamento;

    @Column(length = 20, nullable = false)
    private String codigo;
}
