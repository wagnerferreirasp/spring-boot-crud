package poc.wagner.empresa.dadosDaEmpresa;

import lombok.Data;
import poc.wagner.empresa.socio.Socio;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dados_da_empresa")
public class DadosDaEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dados_da_empresa_id")
    Long id;
    @Column(name = "nome")
    String nome;
    @Column(name = "empresa_foi_constituida")
    Boolean empresaFoiConstituida;
    @Column(name = "descricao_do_negocio")
    String descricaoDoNegocio;
    @Column(name = "endereco")
    String endereco;
    @Column(name = "email")
    String email;
    @OneToOne
    @JoinColumn(name = "socio_id")
    Socio socio;
}
