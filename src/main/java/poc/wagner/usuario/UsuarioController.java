package poc.wagner.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc.wagner.exception.BusinessException;

import java.security.Principal;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<String> criaUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            usuarioService.cria(usuarioDTO);
        } catch (BusinessException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.getMessage());
        }
        return ResponseEntity.ok("Usuário criado com sucesso!");
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object> selecionaPorId(@PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioService.selecionaPorId(id);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
