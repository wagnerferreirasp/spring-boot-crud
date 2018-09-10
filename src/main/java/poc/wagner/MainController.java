package poc.wagner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import poc.wagner.exception.BusinessException;
import poc.wagner.usuario.Usuario;
import poc.wagner.usuario.UsuarioDTO;
import poc.wagner.usuario.UsuarioService;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        Usuario usuarioLogado = usuarioService.selecionaPorEmail(principal.getName());
        model.addAttribute("usuarioLogado", usuarioLogado);
        return "home";
    }

    @GetMapping("/login")
    public String paginaDeLogin() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.cria(usuarioDTO);
        } catch (BusinessException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
            redirectAttributes.addFlashAttribute("warning", true);
            return "redirect:/signup";
        }
        redirectAttributes.addFlashAttribute("mensagem","Usuário criado com sucesso!");
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/login";
    }
}

