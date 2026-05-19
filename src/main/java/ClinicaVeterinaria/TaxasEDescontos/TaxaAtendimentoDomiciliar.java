package ClinicaVeterinaria.TaxasEDescontos;

import ClinicaVeterinaria.ServicoDecorator;
import ClinicaVeterinaria.ServicoVeterinario;

public class TaxaAtendimentoDomiciliar extends ServicoDecorator {

    public TaxaAtendimentoDomiciliar(ServicoVeterinario servico) {
        super(servico);
    }
    public double getValor() {
        return servicoEncapsulado.getValor() + 50.0;
    }
    public String getDescricao() {
        return servicoEncapsulado.getDescricao() + " (+Domiciliar)";
    }

}
