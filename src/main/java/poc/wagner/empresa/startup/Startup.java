package poc.wagner.empresa.startup;

import lombok.Data;
import poc.wagner.empresa.dadosDaEmpresa.DadosDaEmpresa;
import poc.wagner.tipoDeMentor.TipoDeMentor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "startup")
public class Startup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "startup_id")
    Long id;
    @OneToOne
    @JoinColumn(name = "dados_da_empresa_id")
    DadosDaEmpresa dadosDaEmpresa;
    @OneToMany
    @JoinTable(name = "startup_tipo_de_mentor")
    List<TipoDeMentor> tiposDeMentores;
    @Column(name = "esta_buscando_investimento")
    Boolean estaBuscandoInvestimento;
}
