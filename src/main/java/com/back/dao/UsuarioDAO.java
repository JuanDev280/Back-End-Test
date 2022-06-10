package com.back.dao;

import com.back.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{
    Usuario findByUsername(String username);
}
