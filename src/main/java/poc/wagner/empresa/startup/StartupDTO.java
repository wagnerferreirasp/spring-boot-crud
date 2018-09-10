package poc.wagner.empresa.startup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import poc.wagner.empresa.dadosDaEmpresa.DadosDaEmpresaDTO;

import java.util.List;

@Data
public class StartupDTO {
    @JsonProperty("dadosDaEmpresa")
    DadosDaEmpresaDTO dadosDaEmpresaDTO;
    List<Long> idsTiposDeMentores;
    Boolean estaBuscandoInvestimento;
}
