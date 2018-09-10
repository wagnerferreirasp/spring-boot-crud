package poc.wagner.empresa.grandeEmpresa;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import poc.wagner.empresa.dadosDaEmpresa.DadosDaEmpresaDTO;

@Data
public class GrandeEmpresaDTO {
    @JsonProperty("dadosDaEmpresa")
    DadosDaEmpresaDTO dadosDaEmpresaDTO;
}
