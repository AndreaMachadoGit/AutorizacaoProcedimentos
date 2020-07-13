package br.com.andrea.autorizacao.mapper;

import br.com.andrea.autorizacao.dto.ProcedimentoDTO;
import br.com.andrea.autorizacao.model.Procedimento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcedimentoMapper {

    ProcedimentoMapper INSTANCE = Mappers.getMapper( ProcedimentoMapper.class );

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "procedimento", target = "procedimento"),
            @Mapping(source = "idade", target = "idade"),
            @Mapping(source = "sexo", target = "sexo"),
            @Mapping(source = "permitido", target = "permitido")
    })
    ProcedimentoDTO map(Procedimento procedimento);

    List<ProcedimentoDTO> map(List<Procedimento> procedimentos);

}
