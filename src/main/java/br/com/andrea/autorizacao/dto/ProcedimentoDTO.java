package br.com.andrea.autorizacao.dto;

import br.com.andrea.autorizacao.model.Sexo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcedimentoDTO {

    private Long id;
    private Long procedimento;
    private int idade;
    private Sexo sexo;
    private boolean permitido;

}
