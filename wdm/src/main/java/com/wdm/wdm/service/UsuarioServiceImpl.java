package com.wdm.wdm.service;

import com.wdm.wdm.entity.Usuario;
import com.wdm.wdm.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioServiceInterface {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }
}
