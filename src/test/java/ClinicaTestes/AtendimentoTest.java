package ClinicaTestes;

import ClinicaVeterinaria.*;
import ClinicaVeterinaria.StatusAtendimento.Agendado;
import ClinicaVeterinaria.StatusAtendimento.EmAtendimento;
import ClinicaVeterinaria.StatusAtendimento.Finalizado;
import ClinicaVeterinaria.TaxasEDescontos.BanhoPosConsulta;
import ClinicaVeterinaria.TaxasEDescontos.DescontoAnimalAdotado;
import ClinicaVeterinaria.TaxasEDescontos.TaxaAtendimentoDomiciliar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtendimentoTest {

    private Tutor tutor;
    private Animal animal;

    @BeforeEach
    void setUp() {
        tutor = new Tutor("João");
        animal = new Animal("Rex", tutor);
    }

    @Test
    void deveCalcularValorCorretoSemDecorators() {
        ServicoVeterinario servico = new Consulta();
        assertEquals(100.0, servico.getValor());
    }

    @Test
    void deveCalcularValorCorretoComMultiplosDecorators() {
        ServicoVeterinario servico = new Consulta();
        servico = new TaxaAtendimentoDomiciliar(servico);
        servico = new BanhoPosConsulta(servico);
        servico = new DescontoAnimalAdotado(servico);

        assertEquals(152.0, servico.getValor(), 0.001);

        String descricao = servico.getDescricao();
        assertTrue(descricao.contains("Consulta Básica"));
        assertTrue(descricao.contains("+Domiciliar"));
        assertTrue(descricao.contains("+Banho"));
        assertTrue(descricao.contains("-20%"));
    }

    @Test
    void deveEvoluirEstadoDeAgendadoParaEmAtendimentoEFinalizado() {
        Atendimento atendimento = new Atendimento(animal, new Consulta());
        assertTrue(atendimento.getEstado() instanceof Agendado);

        atendimento.iniciar();
        assertTrue(atendimento.getEstado() instanceof EmAtendimento);

        atendimento.finalizar();
        assertTrue(atendimento.getEstado() instanceof Finalizado);
    }

    @Test
    void naoDevePermitirCancelarAtendimentoEmAndamento() {
        Atendimento atendimento = new Atendimento(animal, new Consulta());
        atendimento.iniciar();
        assertTrue(atendimento.getEstado() instanceof EmAtendimento);

        atendimento.cancelar();
        assertTrue(atendimento.getEstado() instanceof EmAtendimento);
    }

    @Test
    void deveNotificarObserversAoMudarDeEstado() {
        Atendimento atendimento = new Atendimento(animal, new Consulta());

        class TestObserverSpy implements AtendimentoObserver {
            int chamadas = 0;
            public void atualizar(Atendimento a) {
                chamadas++;
            }
        }

        TestObserverSpy spy = new TestObserverSpy();
        atendimento.adicionarObserver(spy);

        assertEquals(0, spy.chamadas);

        atendimento.iniciar();
        assertEquals(1, spy.chamadas);

        atendimento.finalizar();
        assertEquals(2, spy.chamadas);
    }

}
