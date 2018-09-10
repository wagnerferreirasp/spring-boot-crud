package poc.wagner.empresa.grandeEmpresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandeEmpresaRepository extends JpaRepository<GrandeEmpresa, Long> {
}
