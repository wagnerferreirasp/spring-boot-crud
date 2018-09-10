package poc.wagner.empresa.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.wagner.empresa.dadosDaEmpresa.DadosDaEmpresa;
import poc.wagner.empresa.dadosDaEmpresa.DadosDaEmpresaService;
import poc.wagner.tipoDeMentor.TipoDeMentor;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class StartupServiceImpl implements StartupService {
    @Autowired
    StartupRepository repository;

    @Autowired
    DadosDaEmpresaService dadosDaEmpresaService;

    @Autowired
    EntityManager entityManager;

    @Override
    public Startup insere(StartupDTO startupDTO) {
        Startup startup = new Startup();
        DadosDaEmpresa dadosDaEmpresa = dadosDaEmpresaService.insere(startupDTO.getDadosDaEmpresaDTO());
        startup.setDadosDaEmpresa(dadosDaEmpresa);

        List<TipoDeMentor> tiposDeMentores = new ArrayList<>();
        for (Long id : startupDTO.getIdsTiposDeMentores()) {
            tiposDeMentores.add(entityManager.getReference(TipoDeMentor.class, id));
        }

        startup.setTiposDeMentores(tiposDeMentores);
        startup.setEstaBuscandoInvestimento(startupDTO.getEstaBuscandoInvestimento());

        return repository.save(startup);
    }
}
