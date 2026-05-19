package ClinicaVeterinaria;

import ClinicaVeterinaria.StatusAtendimento.Finalizado;

public class NotificadorRecepcao implements AtendimentoObserver {

    public void atualizar(Atendimento a) {
        if (a.getEstado() instanceof Finalizado) {
            System.out.println("Recepção avisada: Atendimento de " + a.getAnimal().getNome() + " concluído. Valor: R$" + a.getServico().getValor());
        }
    }

}
