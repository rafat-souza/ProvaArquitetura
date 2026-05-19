package ClinicaVeterinaria;

import ClinicaVeterinaria.StatusAtendimento.EmAtendimento;

public class NotificadorTutor implements AtendimentoObserver {

    public void atualizar(Atendimento a) {
        if (a.getEstado() instanceof EmAtendimento) {
            System.out.println("Tutor " + a.getTutor().getNome() + " avisado: O atendimento de " + a.getAnimal().getNome() + " começou.");
        }
    }

}
