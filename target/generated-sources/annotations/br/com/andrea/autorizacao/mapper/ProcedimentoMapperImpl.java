package br.com.andrea.autorizacao.mapper;

import br.com.andrea.autorizacao.dto.ProcedimentoDTO;
import br.com.andrea.autorizacao.model.Procedimento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-12T12:37:06-0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_151 (Oracle Corporation)"
)
@Component
public class ProcedimentoMapperImpl implements ProcedimentoMapper {

    @Override
    public ProcedimentoDTO map(Procedimento procedimento) {
        if ( procedimento == null ) {
            return null;
        }

        ProcedimentoDTO procedimentoDTO = new ProcedimentoDTO();

        procedimentoDTO.setIdade( procedimento.getIdade() );
        procedimentoDTO.setPermitido( procedimento.isPermitido() );
        procedimentoDTO.setId( procedimento.getId() );
        procedimentoDTO.setProcedimento( procedimento.getProcedimento() );
        procedimentoDTO.setSexo( procedimento.getSexo() );

        return procedimentoDTO;
    }

    @Override
    public List<ProcedimentoDTO> map(List<Procedimento> procedimentos) {
        if ( procedimentos == null ) {
            return null;
        }

        List<ProcedimentoDTO> list = new ArrayList<ProcedimentoDTO>( procedimentos.size() );
        for ( Procedimento procedimento : procedimentos ) {
            list.add( map( procedimento ) );
        }

        return list;
    }
}
