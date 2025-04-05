package doichejunior.service.impl;

import doichejunior.model.Usuario;
import doichejunior.repository.UsuarioRepository;
import doichejunior.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super();
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findById(Long id) {

        Optional<Usuario> user = usuarioRepository.findById(id);
        return user.orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario create(Usuario userToCreate) {

        return usuarioRepository.save(userToCreate);

    }

    @Override
    public void update(Long id, Usuario usuario) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()) {
            usuarioRepository.save(usuario);
        }
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }


	@Override
    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }


}





