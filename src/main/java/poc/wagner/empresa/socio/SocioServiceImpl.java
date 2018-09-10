package poc.wagner.empresa.socio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocioServiceImpl implements SocioService {
    @Autowired
    SocioRepository repository;

    @Override
    public Socio insere(SocioDTO socioDTO) {
        Socio socio = new Socio();
        socio.setNome(socioDTO.getNome());
        return repository.save(socio);
    }
}
