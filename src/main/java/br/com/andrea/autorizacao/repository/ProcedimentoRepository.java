package br.com.andrea.autorizacao.repository;

import br.com.andrea.autorizacao.model.Procedimento;
import br.com.andrea.autorizacao.model.Sexo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedimentoRepository extends CrudRepository<Procedimento, Long> {

    Page<Procedimento> findAll(Pageable pageable);

    List<Procedimento> findByProcedimento(Long procedimento, Pageable pageable);

    List<Procedimento> findBySexo(Sexo sexo, Pageable pageable);

    Page<Procedimento> findByProcedimentoAndIdadeAndSexo(Long procedimento, int idade, Sexo sexo, Pageable pageable);


}
