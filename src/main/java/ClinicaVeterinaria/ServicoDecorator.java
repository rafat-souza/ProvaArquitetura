package ClinicaVeterinaria;

public abstract class ServicoDecorator implements ServicoVeterinario {

    protected ServicoVeterinario servicoEncapsulado;

    public ServicoDecorator(ServicoVeterinario servico) {
        this.servicoEncapsulado = servico;
    }

}
