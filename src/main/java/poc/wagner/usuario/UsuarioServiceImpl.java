package poc.wagner.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import poc.wagner.exception.BusinessException;
import poc.wagner.Role;
import poc.wagner.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public void cria(UsuarioDTO usuarioDTO) throws BusinessException {
        if (repository.findByEmail(usuarioDTO.getEmail()) != null) {
            throw new BusinessException("Já existe outro usuário com este e-mail.");
        }

        Role role = roleRepository.findByNome("USER");

        Usuario usuarioNovo = new Usuario.UsuarioBuilder()
                .email(usuarioDTO.getEmail())
                .nome(usuarioDTO.getNome())
                .senha(passwordEncoder.encode(usuarioDTO.getSenha()))
                .roles(new HashSet<>(Arrays.asList(role)))
                .build();

        repository.save(usuarioNovo);
    }

    @Override
    public void salva(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public List<Usuario> listaTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> selecionaPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Usuario selecionaPorEmail(String email) {
        return repository.findByEmail(email);
    }
}
