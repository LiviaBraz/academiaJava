package aula07;

import java.time.LocalDate;

public class Gato extends Animal {

    public Gato(String nome, String raca, LocalDate dataNascimento, String proprietario) {
        super(nome, "Gato", raca, dataNascimento, proprietario);
    }

}