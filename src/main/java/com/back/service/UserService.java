package com.back.service;

import com.back.domain.Usuario;
import java.util.List;

public interface UserService {
    
    public List<Usuario> listUsers();
    public void save(Usuario user);
    public void remove(Usuario user);
    public Usuario findUser(Usuario user);
    public Usuario findByUsername(String username);
    
}
