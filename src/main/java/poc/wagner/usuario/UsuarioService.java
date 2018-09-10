package poc.wagner.usuario;

import poc.wagner.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    void cria(UsuarioDTO usuarioDTO) throws BusinessException;
    void salva(Usuario usuario) throws BusinessException;
    List<Usuario> listaTodos();
    Optional<Usuario> selecionaPorId(Long id);
    Usuario selecionaPorEmail(String email);
}
