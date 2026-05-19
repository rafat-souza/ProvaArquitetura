package ClinicaVeterinaria.StatusAtendimento;

import ClinicaVeterinaria.Atendimento;
import ClinicaVeterinaria.EstadoAtendimento;

public class Agendado implements EstadoAtendimento {

    public void iniciar(Atendimento a) {
        a.setEstado(new EmAtendimento());
        System.out.println("Atendimento iniciado.");
    }
    public void finalizar(Atendimento a) {
        System.out.println("Erro: Não é possível finalizar um atendimento agendado sem iniciar.");
    }
    public void cancelar(Atendimento a) {
        a.setEstado(new Cancelado());
        System.out.println("Atendimento cancelado.");
    }

}
