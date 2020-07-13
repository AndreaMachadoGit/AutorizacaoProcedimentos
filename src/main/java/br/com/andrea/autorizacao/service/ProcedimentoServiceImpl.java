package br.com.andrea.autorizacao.service;

import br.com.andrea.autorizacao.model.Procedimento;
import br.com.andrea.autorizacao.model.Sexo;
import br.com.andrea.autorizacao.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedimentoServiceImpl implements ProcedimentoService {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

     @Override
    public List<Procedimento> findAll(Pageable pageable) {
         return this.procedimentoRepository.findAll(pageable).getContent();
    }

    @Override
    public Optional<Procedimento> findById(Long id) {
         return procedimentoRepository.findById(id);
    }

    @Override
    public Procedimento save(Procedimento procedimento) {
        return this.procedimentoRepository.save(procedimento);
    }

    @Override
    public void deleteById(Long id) {
         this.procedimentoRepository.deleteById(id);
    }

    @Override
    public List<Procedimento> findByProcedimento(Long procedimento, Pageable pageable) {
        return this.procedimentoRepository.findByProcedimento(procedimento,pageable);
    }

    @Override
    public Page<Procedimento> findByProcedimenoAndIdadeAndSexo(Long procedimento, int idade, Sexo sexo, Pageable pageable) {
        return this.procedimentoRepository.findByProcedimentoAndIdadeAndSexo(procedimento, idade, sexo,pageable);
    }

    @Override
    public List<Procedimento> findBySexo(Sexo sexo, Pageable pageable) {
        return this.procedimentoRepository.findBySexo(sexo,pageable);
    }

}
