package ClinicaVeterinaria;

import ClinicaVeterinaria.StatusAtendimento.Agendado;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {

    private Animal animal;
    private ServicoVeterinario servico;
    private EstadoAtendimento estado;
    private List<AtendimentoObserver> observadores = new ArrayList<>();

    public Atendimento(Animal animal, ServicoVeterinario servico) {
        this.animal = animal;
        this.servico = servico;
        this.estado = new Agendado();
    }

    public void adicionarObserver(AtendimentoObserver observer) {
        observadores.add(observer);
    }

    public void setEstado(EstadoAtendimento novoEstado) {
        this.estado = novoEstado;
        notificarObservers();
    }

    private void notificarObservers() {
        for (AtendimentoObserver obs : observadores) {
            obs.atualizar(this);
        }
    }

    public void iniciar() { estado.iniciar(this); }
    public void finalizar() { estado.finalizar(this); }
    public void cancelar() { estado.cancelar(this); }

    public Animal getAnimal() { return animal; }
    public Tutor getTutor() { return animal.getTutor(); }
    public ServicoVeterinario getServico() { return servico; }
    public EstadoAtendimento getEstado() { return estado; }

}
