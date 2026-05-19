package ClinicaVeterinaria.StatusAtendimento;

import ClinicaVeterinaria.Atendimento;
import ClinicaVeterinaria.EstadoAtendimento;

public class Cancelado implements EstadoAtendimento {

    public void iniciar(Atendimento a) {
        System.out.println("Erro: Atendimento cancelado.");
    }
    public void finalizar(Atendimento a) {
        System.out.println("Erro: Atendimento cancelado.");
    }
    public void cancelar(Atendimento a) {
        System.out.println("Erro: Atendimento já foi cancelado.");
    }

}
