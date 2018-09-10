package poc.wagner.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import poc.wagner.empresa.grandeEmpresa.GrandeEmpresaDTO;
import poc.wagner.empresa.grandeEmpresa.GrandeEmpresaService;
import poc.wagner.empresa.startup.StartupDTO;
import poc.wagner.empresa.startup.StartupService;
import poc.wagner.tipoDeMentor.TipoDeMentorRepository;

@Controller
public class EmpresaController {

    @Autowired
    TipoDeMentorRepository tipoDeMentorRepository;

    @Autowired
    GrandeEmpresaService grandeEmpresaService;

    @Autowired
    StartupService startupService;


    @GetMapping("/cadastroDeGrandeEmpresa")
    public String cadastroDeGrandeEmpresa() {
        return "cadastroDeGrandeEmpresa";
    }

    @GetMapping("/cadastroDeStartup")
    public String cadastroDeStartup(Model model) {
        model.addAttribute("tiposDeMentores", tipoDeMentorRepository.findAll());
        return "cadastroDeStartup";
    }

    @PostMapping("/cadastraGrandeEmpresa")
    public ResponseEntity<String> cadastraGrandeEmpresa(@RequestBody GrandeEmpresaDTO grandeEmpresaDTO) {
        grandeEmpresaService.insere(grandeEmpresaDTO);
        return ResponseEntity.ok("Empresa cadastrada com sucesso!");
    }

    @PostMapping("/cadastraStartup")
    public ResponseEntity<String> cadastraStartup(@RequestBody StartupDTO startupDTO) {
        startupService.insere(startupDTO);
        return ResponseEntity.ok("Empresa cadastrada com sucesso!");
    }
}
