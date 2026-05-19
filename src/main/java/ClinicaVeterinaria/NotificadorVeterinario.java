package ClinicaVeterinaria;

import ClinicaVeterinaria.StatusAtendimento.Cancelado;

public class NotificadorVeterinario implements AtendimentoObserver {

    public void atualizar(Atendimento a) {
        if (a.getEstado() instanceof Cancelado) {
            System.out.println("Veterinário avisado: O atendimento de " + a.getAnimal().getNome() + " foi cancelado.");
        }
    }

}
