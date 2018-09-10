package poc.wagner.empresa.dadosDaEmpresa;

import lombok.Data;

@Data
public class DadosDaEmpresaDTO {
    Boolean empresaFoiConstituida;
    String descricaoDoNegocio;
    String endereco;
    String nome;
    String nomeDoSocio;
    String email;
}
