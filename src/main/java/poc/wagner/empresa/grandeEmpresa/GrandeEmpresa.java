package poc.wagner.empresa.grandeEmpresa;

import lombok.Data;
import poc.wagner.empresa.dadosDaEmpresa.DadosDaEmpresa;

import javax.persistence.*;

@Entity
@Data
@Table(name = "grande_empresa")
public class GrandeEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grande_empresa_id")
    Long id;
    @OneToOne
    @JoinColumn(name = "dados_da_empresa_id")
    DadosDaEmpresa dadosDaEmpresa;
}
