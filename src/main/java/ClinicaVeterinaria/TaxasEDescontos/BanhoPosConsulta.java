package ClinicaVeterinaria.TaxasEDescontos;

import ClinicaVeterinaria.ServicoDecorator;
import ClinicaVeterinaria.ServicoVeterinario;

public class BanhoPosConsulta extends ServicoDecorator {

    public BanhoPosConsulta(ServicoVeterinario servico) {
        super(servico);
    }
    public double getValor() {
        return servicoEncapsulado.getValor() + 40.0;
    }
    public String getDescricao() {
        return servicoEncapsulado.getDescricao() + " (+Banho)";
    }

}
