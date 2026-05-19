package ClinicaVeterinaria.StatusAtendimento;

import ClinicaVeterinaria.Atendimento;
import ClinicaVeterinaria.EstadoAtendimento;

public class EmAtendimento implements EstadoAtendimento {

    public void iniciar(Atendimento a) {
        System.out.println("Erro: Atendimento já está em andamento.");
    }
    public void finalizar(Atendimento a) {
        a.setEstado(new Finalizado());
        System.out.println("Atendimento finalizado com sucesso.");
    }
    public void cancelar(Atendimento a) {
        System.out.println("Erro: Não é possível cancelar um atendimento em andamento. Finalize-o.");
    }

}
