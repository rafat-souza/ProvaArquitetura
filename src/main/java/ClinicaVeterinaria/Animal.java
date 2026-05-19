package ClinicaVeterinaria;

public class Animal {

    private String nome;
    private Tutor tutor;

    public Animal(String nome, Tutor tutor) {
        this.nome = nome;
        this.tutor = tutor;
    }

    public String getNome() { return nome; }
    public Tutor getTutor() { return tutor; }

}
