package poc.wagner.empresa.dadosDaEmpresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.wagner.empresa.socio.Socio;
import poc.wagner.empresa.socio.SocioDTO;
import poc.wagner.empresa.socio.SocioService;

@Service
public class DadosDaEmpresaServiceImpl implements DadosDaEmpresaService {

    @Autowired
    SocioService socioService;

    @Autowired
    DadosDaEmpresaRepository dadosDaEmpresaRepository;

    @Override
    public DadosDaEmpresa insere(DadosDaEmpresaDTO dadosDaEmpresaDTO) {
        DadosDaEmpresa dadosDaEmpresa = new DadosDaEmpresa();
        dadosDaEmpresa.setDescricaoDoNegocio(dadosDaEmpresaDTO.getDescricaoDoNegocio());
        dadosDaEmpresa.setEmpresaFoiConstituida(dadosDaEmpresaDTO.getEmpresaFoiConstituida());
        dadosDaEmpresa.setEndereco(dadosDaEmpresaDTO.getEndereco());
        dadosDaEmpresa.setNome(dadosDaEmpresaDTO.getNome());
        dadosDaEmpresa.setEmail(dadosDaEmpresaDTO.getEmail());

        SocioDTO socioDTO = new SocioDTO();
        socioDTO.setNome(dadosDaEmpresaDTO.getNomeDoSocio());
        Socio socio = socioService.insere(socioDTO);
        dadosDaEmpresa.setSocio(socio);
        return dadosDaEmpresaRepository.save(dadosDaEmpresa);
    }
}
