package ClinicaVeterinaria.StatusAtendimento;

import ClinicaVeterinaria.Atendimento;
import ClinicaVeterinaria.EstadoAtendimento;

public class Finalizado implements EstadoAtendimento {

    public void iniciar(Atendimento a) {
        System.out.println("Erro: Atendimento já foi finalizado.");
    }
    public void finalizar(Atendimento a) {
        System.out.println("Erro: Atendimento já foi finalizado.");
    }
    public void cancelar(Atendimento a) {
        System.out.println("Erro: Atendimento finalizado não pode ser cancelado.");
    }

}
