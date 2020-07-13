package br.com.andrea.autorizacao.service;

import br.com.andrea.autorizacao.model.Procedimento;
import br.com.andrea.autorizacao.model.Sexo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProcedimentoService {

    List<Procedimento> findAll(Pageable pageable);

    Optional<Procedimento> findById(Long id);

    Procedimento save(Procedimento evento);

    void deleteById(Long id);

    List<Procedimento> findByProcedimento(Long procedimento, Pageable pageable);

    List<Procedimento> findBySexo(Sexo sexo, Pageable pageable);

    Page<Procedimento> findByProcedimenoAndIdadeAndSexo(Long procedimento, int idade, Sexo sexo, Pageable pageable);

}
