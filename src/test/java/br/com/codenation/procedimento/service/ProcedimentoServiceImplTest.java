package br.com.codenation.procedimento.service;


import br.com.andrea.autorizacao.repository.ProcedimentoRepository;
import br.com.andrea.autorizacao.service.ProcedimentoServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ProcedimentoServiceImplTest {


    @Mock
    private ProcedimentoRepository procedimentoRepository;

    @InjectMocks
    private ProcedimentoServiceImpl procedimentoServiceImpl;

    @Test
    public void testFindProcedimentosPermitidos() {
    }

    private void mockFindProcedimentoPermitidos() {
    }


}
