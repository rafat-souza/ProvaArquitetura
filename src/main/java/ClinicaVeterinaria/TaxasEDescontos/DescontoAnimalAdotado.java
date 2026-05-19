package ClinicaVeterinaria.TaxasEDescontos;

import ClinicaVeterinaria.ServicoDecorator;
import ClinicaVeterinaria.ServicoVeterinario;

public class DescontoAnimalAdotado extends ServicoDecorator {

    public DescontoAnimalAdotado(ServicoVeterinario servico) {
        super(servico);
    }
    public double getValor() {
        return servicoEncapsulado.getValor() * 0.8;
    }
    public String getDescricao() {
        return servicoEncapsulado.getDescricao() + " (-20% adoção)";
    }

}
