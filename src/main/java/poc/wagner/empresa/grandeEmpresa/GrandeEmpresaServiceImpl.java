package poc.wagner.empresa.grandeEmpresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.wagner.empresa.dadosDaEmpresa.DadosDaEmpresa;
import poc.wagner.empresa.dadosDaEmpresa.DadosDaEmpresaService;

@Service
public class GrandeEmpresaServiceImpl implements GrandeEmpresaService {

    @Autowired
    GrandeEmpresaRepository repository;

    @Autowired
    DadosDaEmpresaService dadosDaEmpresaService;

    @Override
    public GrandeEmpresa insere(GrandeEmpresaDTO grandeEmpresaDTO) {
        GrandeEmpresa grandeEmpresa = new GrandeEmpresa();
        DadosDaEmpresa dadosDaEmpresa = dadosDaEmpresaService.insere(grandeEmpresaDTO.getDadosDaEmpresaDTO());

        grandeEmpresa.setDadosDaEmpresa(dadosDaEmpresa);
        return repository.save(grandeEmpresa);
    }
}
