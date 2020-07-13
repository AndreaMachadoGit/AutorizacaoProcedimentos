package br.com.andrea.autorizacao.controller;

import br.com.andrea.autorizacao.dto.ProcedimentoDTO;
import br.com.andrea.autorizacao.mapper.ProcedimentoMapper;
import br.com.andrea.autorizacao.model.Procedimento;
import br.com.andrea.autorizacao.model.Sexo;
import br.com.andrea.controller.advice.ResourceNotFoundException;
import br.com.andrea.autorizacao.service.ProcedimentoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autorizador")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoService procedimentoService;
    List<ProcedimentoDTO> procedimentoDTO;

    @PostMapping("/cadastro/procedimento/{procedimento}/idade/{idade}/sexo/{sexo}/autoriza/{autoriza}")
    @ApiOperation("Cria um novo parâmetro para autorização de procedimento, parâmetro autoriza preencher com SIM ou NAO.")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Procedimento criado com sucesso.")})
    public ResponseEntity<Procedimento> create(@PathVariable("procedimento") Long codProcedimento,
                                               @PathVariable("idade") Integer idade,
                                               @PathVariable("sexo") Sexo sexo,
                                               @PathVariable("autoriza") String permitido) {
        Procedimento procedimento = new Procedimento();
        procedimento.setProcedimento(codProcedimento);
        procedimento.setIdade(idade);
        procedimento.setSexo(sexo);
        if (permitido.equals("SIM")) {
            procedimento.setPermitido(true);
        } else {
            procedimento.setPermitido(false);
        }

        return new ResponseEntity<Procedimento>(this.procedimentoService.save(procedimento), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation("Lista todos os parâmetros para autorização de procedimentos")
    public Iterable<ProcedimentoDTO> findAll(Pageable pageable) { //@PathParam("descricao") String descricao,
         return procedimentoDTO = ProcedimentoMapper.INSTANCE.map(this.procedimentoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca um parãmetro de autorização de procedimento pelo Id")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Procedimento não localizado"), @ApiResponse(code = 200, message = "Procedimento localizado")})
    public ResponseEntity<Procedimento> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Procedimento>(this.procedimentoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Procedimento")), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui um parâmetro de autorização de procedimento")
    public void delete(@PathVariable("id") Long id) {
        this.procedimentoService.deleteById(id);
    }

    @GetMapping("/bySexo/{sexo}")
    @ApiOperation("Busca uma lista de parãmetros de autorização de procedimentos por sexo do usuario (M, F)")
    public List<Procedimento> findBySexo(@PathVariable("sexo") Sexo sexo, Pageable pageable) {
        return this.procedimentoService.findBySexo(sexo,pageable);
    }

    @GetMapping("/procedimento/{procedimento}/idade/{idade}/sexo/{sexo}")
    @ApiOperation("Efetua a solicitação de autorização pelos parâmetros codigo do procedimento, idade e sexo.")
    public String findByProcedimentoAndIdadeAndSexo(
            @PathVariable("procedimento") Long codProcedimento,
            @PathVariable("idade") int idade,
            @PathVariable("sexo") Sexo sexo,
            Pageable pageable) {

        Page<Procedimento> procedimentos = procedimentoService.findByProcedimenoAndIdadeAndSexo(codProcedimento, idade, sexo, pageable);
        if (! procedimentos.isEmpty()) {
            boolean permitido = procedimentos.stream().map(procedimento -> procedimento.isPermitido()).findFirst().get();
            if (permitido) return "SIM";
            return "NAO";
        }
        return "NAO";
    }

}
