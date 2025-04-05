package doichejunior.service;

import doichejunior.model.Usuario;

public interface UsuarioService {

    Iterable<Usuario> findAll();

    Usuario findById(Long id);

    Usuario create(Usuario userToCreate);

    void update(Long id, Usuario usuario);

    void delete(Long id);








}
