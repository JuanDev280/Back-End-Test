package com.back.service;

import com.back.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.back.dao.UsuarioDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listUsers() {
        return (List<Usuario>) usuarioDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Usuario user) {
        usuarioDAO.save(user);
    }

    @Override
    @Transactional
    public void remove(Usuario user) {
        usuarioDAO.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findUser(Usuario user) {
        return usuarioDAO.findById(user.getId_user()).orElse(null);
    } 

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }

    
}
