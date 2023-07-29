package com.catalisa.biblioteca.repository;

import com.catalisa.biblioteca.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
